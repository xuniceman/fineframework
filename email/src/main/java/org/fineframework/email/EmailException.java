package org.fineframework.email;
/**
 * 邮件处理的自定义异常类
 */
public class EmailException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public EmailException(String message)
	{
		super(message);
	}
	public EmailException(String message , Throwable throwable)
	{
		super(message,throwable);
	}

}
