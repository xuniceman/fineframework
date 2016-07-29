package com.shensu.financialreport.web.account;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

/**
 * 生成验证码控制器
 * @author nice.man  2011-11-26
 *
 */
@Controller
@RequestMapping("/makecode")
public class KaptchaController {
	
	@Autowired
	private Producer captchaProducer = null;  
	/**
	 * 生成google验证码
	 */
	@RequestMapping("/make")
	public void makeCode(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();  
        response.setDateHeader("Expires", 0);  
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
        response.setHeader("Pragma", "no-cache");  
        response.setContentType("image/jpeg");  
         
        String capText = captchaProducer.createText();  
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);  
         
        BufferedImage bi = captchaProducer.createImage(capText);  
       
        ServletOutputStream out = null;
		try {
			out = response.getOutputStream();
			 ImageIO.write(bi, "jpg", out);  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        finally
        {
        	try {
        		if(out!=null)
        		{
        			out.flush();
        			out.close();
        		}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
        }
	}
}
