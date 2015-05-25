package com.gite.simple.util;


import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
 
public class BbsPaging {
	 
	@Autowired private SqlSessionTemplate sqlSessionTemplate;
	 
	private int numOfPagePerBlock;
	private int pagePos;
	private String[] keywords;
	private int startPageNum;
	private int endPageNum;
	private int leftButtonPageNum;
	private boolean activatePrevButton = true;
	private boolean activateNextButton = true;
	 
	public void configure(int numOfPagePerBlock, int pagePos, String[] keywords, String statementOfGettingTotalArticles){
	 
		this.numOfPagePerBlock = numOfPagePerBlock;
		this.pagePos = pagePos;
		this.keywords = keywords;
		  
		Map<String, Object> map = new HashMap<String, Object>();
		if(keywords != null)
			map.put("keywords", keywords);
		int totalRowCount = this.sqlSessionTemplate.selectOne(statementOfGettingTotalArticles, map);
		int totalPageCount = (int)Math.ceil(totalRowCount / (double)numOfPagePerBlock);
		  
		startPageNum = pagePos - (pagePos % numOfPagePerBlock) + 1;
		if(pagePos % numOfPagePerBlock == 0)
			startPageNum = pagePos - 9;
		
		//A�� B �� �� ���Ѿ���
		
		//A
		leftButtonPageNum = startPageNum - 1;
		if( leftButtonPageNum % 10 != 0)
			leftButtonPageNum++;
		
		//B
		if( startPageNum % 10 == 0)
			startPageNum++;
		
		
		if(!(startPageNum > 0))
			startPageNum = 1;
		  
		endPageNum = startPageNum + numOfPagePerBlock -1; 
		//���� ���, 1�ϋ� 11�� �ǹǷ� -1 ����
		  
		if(endPageNum > totalPageCount){
			endPageNum = totalPageCount;
			activateNextButton = false;
		}else
			activateNextButton = true;
		  
		if(startPageNum == 1)
			activatePrevButton = false;
		else
			activatePrevButton = true;
	}

	

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public int getNumOfPagePerBlock() {
		return numOfPagePerBlock;
	}

	public void setNumOfPagePerBlock(int numOfPagePerBlock) {
		this.numOfPagePerBlock = numOfPagePerBlock;
	}

	public String[] getKeywords() {
		return keywords;
	}

	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}

	public int getLeftButtonPageNum() {
		return leftButtonPageNum;
	}

	public void setLeftButtonPageNum(int leftButtonPageNum) {
		this.leftButtonPageNum = leftButtonPageNum;
	}

	public int getPagePos() {
		return pagePos;
	}
	 
	public void setPagePos(int pagePos) {
		this.pagePos = pagePos;
	}
	 
	public int getStartPageNum() {
		return startPageNum;
	}
	 
	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}
	 
	public int getEndPageNum() {
		return endPageNum;
	}
	 
	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}
	 
	public boolean isActivatePrevButton() {
		return activatePrevButton;
	}
	 
	public void setActivatePrevButton(boolean activatePrevButton) {
		this.activatePrevButton = activatePrevButton;
	}
	 
	public boolean isActivateNextButton() {
		return activateNextButton;
	}
	 
	public void setActivateNextButton(boolean activateNextButton) {
		this.activateNextButton = activateNextButton;
	}
	 
}
