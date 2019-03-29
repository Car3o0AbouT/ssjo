package com.demo.ssjo.util;

/**
 * @author
 */
public class RspVo {

	/**0 表示成功，1 表示失败*/
	private int code=1;
	/**一般为错误信息*/
	private String msg = "";

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setSucMsg(String successMsg) {
		this.code=0;
		this.msg = successMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.code=1;
		this.msg = errorMsg;
	}
}
