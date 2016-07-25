package org.fineframework.email;

/**
 * 该接口定义了处理邮件的相关方法
 * 包括：发送邮件(sendMail)
 *
 */
public interface EmailService {

	/**
	 * 发送邮件
	 * 
	 * @param to 发送方
	 * @param subject 发送主题
	 * @param htmlText 发送内容
	 */
	public void sendMail(String to , String subject ,String htmlText) throws EmailException;
}
