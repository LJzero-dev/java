package test;

import javax.mail.*;

public class NaverAuthentication extends Authenticator {
	PasswordAuthentication passAuth;
	
	public NaverAuthentication() {
		passAuth = new PasswordAuthentication("네이버 ID", "네이버 PW");
	}
	public PasswordAuthentication getPasswordAuthentication() {
		return passAuth;
	}
}
