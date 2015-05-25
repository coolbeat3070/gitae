package com.gite.simple.controllers;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;







import com.gite.simple.beans.BbsCommand;
import com.gite.simple.beans.FileBean;
import com.gite.simple.beans.LoginInfoSessionBean;
import com.gite.simple.beans.ReplyCommand;
import com.gite.simple.services.BbsService;
import com.gite.simple.util.BbsPaging;
import com.gite.simple.validators.BbsValidator;




@Controller
@RequestMapping("/bbs")
public class BbsController {

	@Autowired private BbsService service;
	@Autowired private BbsPaging bbsPaging;
	// @Autowired private BbsPaging2 bbsPaging;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(@RequestParam(value="pageNo", defaultValue="1") String pageNo, @RequestParam(value="keyword", required=false) String keyword, Model model){
		
		// ĳ���ͼ� ��ȯ�� URL ���ڵ�
		if(keyword != null){
			try{
				keyword = new String(keyword.getBytes("ISO-8859-1"), "EUC-KR");
			}catch(UnsupportedEncodingException e){
				throw new RuntimeException(e);
			}
			try{
				keyword = java.net.URLDecoder.decode(keyword, "UTF-8");
			}catch(java.io.UnsupportedEncodingException e){
				throw new RuntimeException(e);
			}
			
			model.addAttribute("keyword", keyword);
		}
		
		
		//System.out.println("KEYWORD : " + keyword);
		
		// pageNo�� ��ȿ���� ���� �� ������ �˻�
		try{
			Integer.parseInt(pageNo);
		}catch(NumberFormatException e){
			pageNo = "1";
		}
		
		model.addAttribute("pageNo", pageNo);
		
		List<BbsCommand> list = this.service.getArticleList(pageNo, keyword);
		model.addAttribute("articleList", list);
		
		BbsPagingConfigure(pageNo, keyword);
		model.addAttribute("paging", this.bbsPaging);
		
		
		
		return "bbsList";
	}
	
	private void BbsPagingConfigure(String pageNo, String keyword){
		String[] splittedKeywords = null;
		if(keyword != null){
			splittedKeywords = keyword.split("\\s");
			String s = splittedKeywords[0];
			splittedKeywords[0] = keyword;
			splittedKeywords[splittedKeywords.length - 1] = s;
		}
		
		String statement = "bbs.getTotalCntOfArticles";
		this.bbsPaging.configure(10, Integer.parseInt(pageNo), splittedKeywords, statement);
	}
	
	@RequestMapping("writeForm")
	public String writeForm(@ModelAttribute("bbsWriteCommand") BbsCommand command){
		return "bbs/writeForm";
	}
	
	@RequestMapping(value = "/file_upload", method = RequestMethod.POST)
	public String procFileUpload(FileBean fileBean, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String root_path = session.getServletContext().getRealPath("/"); // ������ root ���
		String attach_path = "\\resources\\bbs_image_attach\\";
		
		
		MultipartFile upload = fileBean.getUpload();
		String filename = "";
		String CKEditorFuncNum = "";
		if (upload != null) {
			filename = upload.getOriginalFilename();
			fileBean.setFilename(filename);
			CKEditorFuncNum = fileBean.getCKEditorFuncNum();
			
			try {
				File file = new File(root_path + attach_path + filename);
				upload.transferTo(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		String file_path = "/simple/resources/bbs_image_attach/" + filename;
		
		model.addAttribute("file_path", file_path);
		model.addAttribute("CKEditorFuncNum", CKEditorFuncNum);
		
		return "bbs/fileUploadSuccess";
	}
	
	@RequestMapping(value="/writeApply", method=RequestMethod.POST)
	public String writeApply(@ModelAttribute("bbsWriteCommand") BbsCommand command, BindingResult bindingResult, HttpSession session, RedirectAttributes ra){
		new BbsValidator().validate(command, bindingResult);
		if(bindingResult.hasErrors())
			return "bbs/writeForm";
		
		// �������� ����
		LoginInfoSessionBean sessionBean = (LoginInfoSessionBean) session.getAttribute("loginInfo");
		command.setUserNo(sessionBean.getUserNo());
		command.setUserId(sessionBean.getId());
		command.setUserName(sessionBean.getName());
		
		this.service.bbsWriteNew(command);
		ra.addFlashAttribute("bbsWriteNewSuccessMessage", "��ϵǾ���ϴ�");
		return "redirect:list";
	}
	
	@RequestMapping("/viewArticle")
	public String viewArticle(@RequestParam("bbsNo") String bbsNo, @RequestParam(value="pageNo", defaultValue="1") String pageNo, @RequestParam(value="keyword", required=false) String keyword, Model model){
		try{
			Integer.parseInt(bbsNo);
		}catch(NumberFormatException e){
			bbsNo = "1";
		}
		
		if(keyword != null){
			try{
				keyword = new String(keyword.getBytes("ISO-8859-1"), "EUC-KR");
			}catch(UnsupportedEncodingException e){
				throw new RuntimeException(e);
			}
			
			model.addAttribute("keyword", keyword);
		}
		
		model.addAttribute("pageNo", pageNo);
		if(keyword != null)
		
		System.out.println("PAGE NO : " + pageNo);
		System.out.println("KEYWORD : " + keyword);
		
		BbsCommand command = this.service.getArticle(bbsNo);
		model.addAttribute("command", command);
		
		return "bbs/viewArticle";
	}
	
	@RequestMapping(value="addReply", method=RequestMethod.POST)
	public String addReply(@ModelAttribute("replyCommand") ReplyCommand command, HttpSession session){
		
		LoginInfoSessionBean sessionBean = (LoginInfoSessionBean) session.getAttribute("loginInfo");
		command.setWriterNo(sessionBean.getUserNo());

		this.service.addReply(command);
		
		return "dummy";
	}
	
	@RequestMapping(value="getReplies", method=RequestMethod.GET)
	public String getReplies(@RequestParam("bbsNo") String bbsNo, Model model){
		
		try{
			Integer.parseInt(bbsNo);
		}catch(NumberFormatException e){
			bbsNo = "1";
		}
		
		List<ReplyCommand> list = this.service.getReplies(bbsNo);
		if(list.size() != 0)
			model.addAttribute("replyList", list);
		
		return "bbs/getReplies";
	}
}
