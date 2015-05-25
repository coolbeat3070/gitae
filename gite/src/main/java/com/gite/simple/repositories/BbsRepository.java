package com.gite.simple.repositories;

import java.util.List;

import com.gite.simple.beans.BbsCommand;
import com.gite.simple.beans.ReplyCommand;


public interface BbsRepository {
	public void bbsWriteNew(BbsCommand command);
	public List<BbsCommand> getArticleList(String pageNo, String keyword);
	public BbsCommand getArticle(String bbsNo);
	public void addViewCnt(String bbsNo);
	public List<ReplyCommand> getReplies(String bbsNo);
	public void addReply(ReplyCommand command);
}
