package com.lzq.po;

import java.util.List;

public class CouExte extends Course{
	private int tid;
	private List<Integer> claids;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public List<Integer> getClaids() {
		return claids;
	}
	public void setClaids(List<Integer> claids) {
		this.claids = claids;
	}
	
}
