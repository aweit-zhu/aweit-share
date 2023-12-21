package org.cdri;

public 	enum Season { 
	
	FIRST(1,3), SECOND(4,6), THRID(7,9), FOURTH(10,12);
	
	final int startMonth;
	
	final int endMonth;
	
	Season(int startMonth,int endMonth) {
		this.startMonth = startMonth;
		this.endMonth = endMonth;
	}

	public int getStartMonth() {
		return startMonth;
	}

	public int getEndMonth() {
		return endMonth;
	}
}