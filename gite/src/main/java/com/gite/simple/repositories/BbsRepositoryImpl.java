package com.gite.simple.repositories;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gite.simple.beans.BbsCommand;
import com.gite.simple.beans.ReplyCommand;



@Repository
public class BbsRepositoryImpl implements BbsRepository{

	@Autowired SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void bbsWriteNew(BbsCommand command) {
		String preContentsValue = command.getContent().replaceAll("<[^>]*>", "");

		int maxLength = (preContentsValue.length() > 99)? 99:preContentsValue.length();
		preContentsValue = preContentsValue.substring(0, maxLength); // 100�� ������ ����
		command.setPreContents(preContentsValue);

		command.setRegDateDateType(new Date());
		
		command.setViewCnt(0);
		
		String statement = "bbs.insertNewArticle";
		this.sqlSessionTemplate.insert(statement, command);
	}
	
	@Override
	public List<BbsCommand> getArticleList(String pageNo, String keyword) {
		String statement = "bbs.getArticleList";
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		String[] splittedKeywords = null;
		if(keyword != null){
			splittedKeywords = keyword.split("\\s");
			String s = splittedKeywords[0];
			splittedKeywords[0] = keyword;
			splittedKeywords[splittedKeywords.length-1] = s;
			map.put("keywords", splittedKeywords);
		}
		
		int startRowNum = (Integer.parseInt(pageNo)*10) - 10+1;
		int endRowNum = Integer.parseInt(pageNo)*10;		
		map.put("startRowNum", startRowNum);
		map.put("endRowNum", endRowNum);
		
		return this.sqlSessionTemplate.selectList(statement, map);
	}
	
	@Override
	public BbsCommand getArticle(String bbsNo) {
		String statement = "bbs.getArticle";
		return this.sqlSessionTemplate.selectOne(statement, bbsNo);
	}
	
	@Override
	public void addViewCnt(String bbsNo) {
		String statement = "bbs.addViewCnt";
		this.sqlSessionTemplate.update(statement, bbsNo);
	}
	
	@Override
	public List<ReplyCommand> getReplies(String bbsNo) {
		String statement = "bbs.getReplies";
		return this.sqlSessionTemplate.selectList(statement, bbsNo);
	}
	
	@Override
	public void addReply(ReplyCommand command) {
		String statement = "bbs.addReply";
		this.sqlSessionTemplate.insert(statement, command);
	}
}
