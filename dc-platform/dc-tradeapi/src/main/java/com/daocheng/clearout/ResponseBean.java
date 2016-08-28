package com.daocheng.clearout;

public class ResponseBean {

    private String mainClassType;
	private String jasonValue;
	public String getMainClassType() {
		return mainClassType;
	}
	public void setMainClassType(String mainClassType) {
		this.mainClassType = mainClassType;
	}
	public String getJasonValue() {
		return jasonValue;
	}
	public void setJasonValue(String jasonValue) {
		this.jasonValue = jasonValue;
	}
	public ResponseBean(String mainClassType, String jasonValue) {
		super();
		this.mainClassType = mainClassType;
		this.jasonValue = jasonValue;
	}

	public ResponseBean(){
		
	}
    
}
