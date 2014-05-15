package com.endava.Web;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Pet {
	private String apiVersion;
	private String swaggerVersion;
	private Apis apis[];
	
	public String getApiVersion() {
		return apiVersion;
	}
	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}
	public String getSwaggerVersion() {
		return swaggerVersion;
	}
	public void setSwaggerVersion(String swaggerVersion) {
		this.swaggerVersion = swaggerVersion;
	}
	public Apis[] getApis() {
		return apis;
	}
	public void setApis(Apis[] apis) {
		this.apis = apis;
	}
	

}
