package com.gite.simple.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gite.simple.beans.JoinBean;
import com.gite.simple.beans.JsonResultOfduplicateIdCheck;
import com.gite.simple.beans.LoginCommand;
import com.gite.simple.beans.LoginInfoSessionBean;
import com.gite.simple.beans.PasswordChangeCommand;
import com.gite.simple.beans.UserInfoCommand;
import com.gite.simple.services.MemberService;
import com.gite.simple.validators.JoinValidator;
import com.gite.simple.validators.LoginValidator;


@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired private MemberService service;
	
	@RequestMapping("home")
	public String home(){
		return "home";
	}
	
	@RequestMapping("/joinSuccess")
	public String joinSuccess() {
		return "member/joinSuccess";
	}
	
	@RequestMapping("/joinInput")
	public String joinInput(@ModelAttribute("joinCommand") JoinBean joinBean){
		return "member/join";
	}
	
	@RequestMapping(value="/joinApply", method=RequestMethod.POST)
	public String joinApply(@ModelAttribute("joinCommand") JoinBean joinBean, BindingResult bindingResult){
		
		new JoinValidator().validate(joinBean, bindingResult);
		
		if(bindingResult.hasErrors())
			return "member/join";
		
		this.service.insertNewMember(joinBean);

		return "redirect:joinSuccess";
	}
	
	/*@InitBinder("joinCommand")
	public void initBinder_joinValidator(WebDataBinder dataBinder){
		dataBinder.setValidator(new JoinValidator());
	}*/
	
	@RequestMapping("/checkIdDuplicate")
	@ResponseBody
	public JsonResultOfduplicateIdCheck checkIdDuplicate(@RequestParam("id") String id){
		JsonResultOfduplicateIdCheck jsonResult = new JsonResultOfduplicateIdCheck();
		jsonResult.setDuplicate(this.service.checkIdDuplicate(id));
		
		return jsonResult;
	}
	
	@RequestMapping("/loginInput")
	public String loginInput(@ModelAttribute("loginCommand") LoginCommand loginCommand){
		return "member/loginInput";
	}
	
	@RequestMapping(value="/loginApply", method=RequestMethod.POST)
	public String loginApply(@ModelAttribute("loginCommand") LoginCommand loginCommand, BindingResult bindingResult, @RequestParam(value="toWhere", required=false) String toWhere, HttpSession session){
		
		new LoginValidator().validate(loginCommand, bindingResult);
		
		if(bindingResult.hasErrors())
			return "/member/loginInput";

		LoginInfoSessionBean sessionBean = this.service.login(loginCommand); 
		
		if(sessionBean == null){
			bindingResult.reject("noValidIdAndPassword");
			return "/member/loginInput";
		}
		
		session.setAttribute("loginInfo", sessionBean);
		
		if(toWhere == null){
			return "redirect:home";
		}
		
		return "redirect:" + toWhere;
			
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		
		session.invalidate();
		
		return "redirect:home";
	}
	
	@ModelAttribute("userInfoCommand")
	public UserInfoCommand userInfoCommand(HttpSession session){
		LoginInfoSessionBean sessionBean = (LoginInfoSessionBean)session.getAttribute("loginInfo");
		
		UserInfoCommand command = new UserInfoCommand();
		
		if(sessionBean != null){
			
			command.setUserNo(sessionBean.getUserNo());
			command.setId(sessionBean.getId());
			command.setName(sessionBean.getName());
		}
		
		return command;
	}
	
	@RequestMapping("/editUserInfoInput")
	public String editUserInfoInput(@ModelAttribute("userInfoCommand") UserInfoCommand userInfoCommand){
		return "member/editUserInfoInput";
	}
	
	@RequestMapping(value="/editUserInfoApply", method=RequestMethod.POST)
	public String editUserInfoApply(@ModelAttribute("userInfoCommand") UserInfoCommand userInfoCommand){
		this.service.editUserInfo(userInfoCommand);
		return "redirect:home";
	}
	
	@RequestMapping("/prePasswordChangeForm")
	public String prePasswordChangeForm(@ModelAttribute("passwordChangeCommand") PasswordChangeCommand command){
		return "member/prePasswordChangeForm";
	}
	
	@RequestMapping(value="/passwordChangeForm", method=RequestMethod.POST)
	public String passwordChangeForm(@ModelAttribute("passwordChangeCommand") PasswordChangeCommand command, BindingResult bindingResult, HttpSession session ){
		LoginInfoSessionBean sessionBean = (LoginInfoSessionBean)session.getAttribute("loginInfo");
		boolean authenticated = command.getPassword().equals(sessionBean.getPassword());
		
		if(!authenticated){
			bindingResult.reject("noValidPasswordInChangingPassword");
			return "member/prePasswordChangeForm";
		}
		
		return "member/passwordChanageForm";
	}
	
	@RequestMapping(value="/changePasswordApply", method=RequestMethod.POST)
	public String changePasswordApply(@ModelAttribute("passwordChangeCommand") PasswordChangeCommand command, HttpSession session, BindingResult bindingResult, RedirectAttributes ra){
		
		LoginInfoSessionBean loginInfo = (LoginInfoSessionBean)session.getAttribute("loginInfo");
		
		if(command.getPassword().equals(loginInfo.getPassword())){
			bindingResult.reject("oldPasswordIsTheSameWithNewPassword");
			return "member/passwordChanageForm";
		}
		
		command.setUserNo(loginInfo.getUserNo());
		loginInfo.setPassword(command.getPassword());
		this.service.changePassword(command);
		
		return "redirect:passwordChangeSuccess";
	}
	
	@RequestMapping("/passwordChangeSuccess")
	public String passwordChangeSuccess(){
		return "member/passwordChangeSuccess";
	}
}
