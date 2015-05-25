package com.gite.simple.services;

import java.util.List;

import com.gite.simple.beans.BbsCommand;
import com.gite.simple.beans.ReplyCommand;


public interface BbsService {
	void bbsWriteNew(BbsCommand command);
	List<BbsCommand> getArticleList(String pageNo, String keyword);
	BbsCommand getArticle(String bbsNo);
	List<ReplyCommand> getReplies(String bbsNo);
	void addReply(ReplyCommand command);
}
