package spr;

import java.time.*;

public class MemberInfo {
	private int idx;
	private String uid, pwd, name, email;
	private LocalDateTime regDate;
	
	public MemberInfo(String uid, String pwd, String name, String email, LocalDateTime regDate) {
		this.uid = uid;	this.pwd = pwd;	this.name = name;	this.email = email;	this.regDate = regDate;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public void changePwd(String oldPwd, String newPwd) {
		if (!pwd.equals(oldPwd)) throw new WrongIdPasswordException();
		this.pwd = newPwd;
	}	
}