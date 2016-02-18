package com.sogou.bizdev.dubhews.webservice.client.examples.report;

public class User{
    private String apiName;//用户名
    private String apiPass;//密码
    private String accountKey;//key值
    private String  accountSecret;//secret值
    private Integer status;//状态
    private Integer apiType;//渠道
    private Integer disabled;
	public String getApiName() {
		return apiName;
	}
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	public String getApiPass() {
		return apiPass;
	}
	public void setApiPass(String apiPass) {
		this.apiPass = apiPass;
	}
	public String getAccountKey() {
		return accountKey;
	}
	public void setAccountKey(String accountKey) {
		this.accountKey = accountKey;
	}
	public String getAccountSecret() {
		return accountSecret;
	}
	public void setAccountSecret(String accountSecret) {
		this.accountSecret = accountSecret;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getApiType() {
		return apiType;
	}
	public void setApiType(Integer apiType) {
		this.apiType = apiType;
	}
	public Integer getDisabled() {
		return disabled;
	}
	public void setDisabled(Integer disabled) {
		this.disabled = disabled;
	}
    
}