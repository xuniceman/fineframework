package com.shensu.web.core;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class PopAuthenticator extends Authenticator {
	 String userName = null;
     String password = null;
     public PopAuthenticator() {
     }
     public PopAuthenticator(String username, String password) {
         this.userName = username;
         this.password = password;
     }
     protected PasswordAuthentication getPasswordAuthentication() {
         return new PasswordAuthentication(userName, password);
     }
}
