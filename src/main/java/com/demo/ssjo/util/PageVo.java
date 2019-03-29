package com.demo.ssjo.util;

import java.util.List;

/**
 * @author
 */
public class PageVo<T> extends RspVo {
	private int count;
	private List<T> data;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
