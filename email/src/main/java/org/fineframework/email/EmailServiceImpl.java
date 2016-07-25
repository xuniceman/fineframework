package org.fineframework.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * 该类实现了处理邮件的相关方法 包括：发送邮件(sendMail)
 *
 */
public class EmailServiceImpl implements EmailService {

	/**
	 * spring提供的邮件封装类
	 */
	private JavaMailSender javaMailSender;

	/**
	 * 系统邮件地址
	 */
	private String systemEmail;

	/**
	 * 发送邮件
	 * 
	 * @param to 发送方
	 * @param subject 发送主题
	 * @param htmlText 发送内容
	 */
	public void sendMail(String to, String subject, String htmlText) throws EmailException {

		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper msgHelper = new MimeMessageHelper(msg);

		try {
			msgHelper.setFrom(systemEmail);
			msgHelper.setTo(to);
			msgHelper.setSubject(subject);
			//true代表邮件的内容为html格式
			msgHelper.setText(htmlText, true);
		} catch (MessagingException e) {
			throw new EmailException("Faild to send mail.",e);
		}

		javaMailSender.send(msg);
	}

	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public String getSystemEmail() {
		return systemEmail;
	}

	public void setSystemEmail(String systemEmail) {
		this.systemEmail = systemEmail;
	}

}
