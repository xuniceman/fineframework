package org.fineframework.email;

import static org.junit.Assert.assertEquals;

import javax.mail.Message;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;



public class EmailServiceTest {

	private GreenMail greenMail;
	@Before
	public void startMailServer() throws Exception
	{
		greenMail = new GreenMail(ServerSetup.SMTP);
		greenMail.setUser("test@juvenxu.com", "123456");
		greenMail.start();
	}
	@SuppressWarnings("resource")
	@Test
	public void testSendMail() throws Exception
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-email.xml");
		EmailService emailService = (EmailService)ctx.getBean("emailService");
		
		String subject = "Test Subject";
		String htmlText = "<h3>Test</h3>";
		emailService.sendMail("test2@juvenxu.com", subject, htmlText);
		
		greenMail.waitForIncomingEmail(2000,1);
		
		Message [] msgs = greenMail.getReceivedMessages();
		
		assertEquals(1, msgs.length);
		assertEquals(subject,msgs[0].getSubject());
		assertEquals(htmlText, GreenMailUtil.getBody(msgs[0]).trim());
		
	}
	@After
	public void stopMailServer() throws Exception
	{
		greenMail.stop();
	}
}
