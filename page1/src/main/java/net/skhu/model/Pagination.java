package net.skhu.model;

public class Pagination {
	int pg = 1;
	int sz = 15;
	int di = 0;
	int recordCount;
	
	public String getQueryString() {
		return String.format("pg=%d&sz=%d&di=%d",pg,sz,di);
	}

	public int getPg() {
		return pg;
	}

	public void setPg(int pg) {
		this.pg = pg;
	}

	public int getSz() {
		return sz;
	}

	public void setSz(int sz) {
		this.sz = sz;
	}

	public int getDi() {
		return di;
	}

	public void setDi(int di) {
		this.di = di;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	
	
}
