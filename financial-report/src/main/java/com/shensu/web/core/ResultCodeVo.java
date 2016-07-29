package com.shensu.web.core;

/**
 * 返回json对象
 */
public class ResultCodeVo {
	/** 是否成功(true:成功,false:失败) */
	private Boolean success = false;
	/** 错误代码 */
	private Short errorCode;
	/** 消息 */
	private String msg;
	/** 数据 */
	private Object data;

	/**
	 * action通用返回json对象
	 */
	public ResultCodeVo() {

	}

	/**
	 * action通用返回json对象
	 * @param success 是否成功
	 */
	public ResultCodeVo(Boolean success) {
		this.success = success;
	}

	/**
	 * action通用返回json对象
	 * @param success 是否成功
	 * @param msg 消息
	 */
	public ResultCodeVo(Boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}

	/**
	 * action通用返回json对象
	 * @param success 是否成功
	 * @param data 数据
	 */
	public ResultCodeVo(Boolean success, Object data) {
		this.success = success;
		this.data = data;
	}

	/**
	 * action通用返回json对象
	 * @param success 是否成功
	 * @param msg 消息
	 * @param data 数据
	 */
	public ResultCodeVo(Boolean success, String msg, Object data) {
		this.success = success;
		this.msg = msg;
		this.data = data;
	}

	/**
	 * action通用返回json对象
	 * @param success 是否成功
	 * @param errorCode 错误代码
	 * @param msg 消息
	 */
	public ResultCodeVo(Boolean success, Short errorCode, String msg) {
		this.success = success;
		this.errorCode = errorCode;
		this.msg = msg;
	}

	/**
	 * action通用返回json对象
	 * @param success 是否成功
	 * @param errorCode 错误代码
	 * @param msg 消息
	 * @param data 数据
	 */
	public ResultCodeVo(Boolean success, Short errorCode, String msg, Object data) {
		this.success = success;
		this.errorCode = errorCode;
		this.msg = msg;
		this.data = data;
	}

	/**
	 * 获取是否成功
	 * @return 是否成功
	 */
	public Boolean getSuccess() {
		return success;
	}

	/**
	 * 设置是否成功
	 * @param success 是否成功
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	/**
	 * 获取错误代码
	 * @return 错误代码
	 */
	public Short getErrorCode() {
		return errorCode;
	}

	/**
	 * 设置错误代码
	 * @param errorCode 错误代码
	 */
	public void setErrorCode(Short errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * 获取消息
	 * @return 消息
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * 设置消息
	 * @param msg 消息
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 获取数据
	 * @return 数据
	 */
	public Object getData() {
		return data;
	}

	/**
	 * 设置数据
	 * @param data 数据
	 */
	public void setData(Object data) {
		this.data = data;
	}
}
