package lab.spring.board;

import java.sql.Date;

public class Board {
	private int bbsId;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	private String searchKeyWord;
	

	public String getTitle() {
		return title;
	}
	public String getWriter() {
		return writer;
	}
	public String getContent() {
		return content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public int getCnt() {
		return cnt;
	}
	public String getSearchKeyWord() {
		return searchKeyWord;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public void setSearchKeyWord(String searchKeyWord) {
		this.searchKeyWord = searchKeyWord;
	}
	public int getBbsId() {
		return bbsId;
	}
	public void setBbsId(int bbsId) {
		this.bbsId = bbsId;
	}
	@Override
	public String toString() {
		return "Board [bbsId=" + bbsId + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", regDate=" + regDate + ", cnt=" + cnt + ", searchKeyWord=" + searchKeyWord + "]";
	}
	
	
	
}
