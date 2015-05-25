package com.gite.simple.beans;

public class ReplyCommand {
	 
	private String replyNo;
	private String writerNo;
	private String writerId;
	private String content;
	private String bbsNo;
	
	
	public String getBbsNo() {
		return bbsNo;
	}
	public void setBbsNo(String bbsNo) {
		this.bbsNo = bbsNo;
	}
	public String getWriterNo() {
		return writerNo;
	}
	public void setWriterNo(String writerNo) {
		this.writerNo = writerNo;
	}
	public String getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(String replyNo) {
		this.replyNo = replyNo;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
