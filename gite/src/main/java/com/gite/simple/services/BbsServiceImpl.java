package com.gite.simple.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gite.simple.beans.BbsCommand;
import com.gite.simple.beans.ReplyCommand;
import com.gite.simple.repositories.BbsRepository;



@Service
public class BbsServiceImpl implements BbsService{

	@Autowired private BbsRepository repository;
	
	@Override
	@Transactional
	public void bbsWriteNew(BbsCommand command) {
		this.repository.bbsWriteNew(command);
	}	
	
	@Override
	@Transactional(readOnly=true)
	public List<BbsCommand> getArticleList(String pageNo, String keyword) {
		return this.repository.getArticleList(pageNo, keyword);
	}
	
	@Override
	@Transactional
	public BbsCommand getArticle(String bbsNo) {
		this.repository.addViewCnt(bbsNo);
		return this.repository.getArticle(bbsNo);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<ReplyCommand> getReplies(String bbsNo) {
		return this.repository.getReplies(bbsNo);
	}
	
	@Override
	@Transactional
	public void addReply(ReplyCommand command) {
		this.repository.addReply(command);
	}
}
