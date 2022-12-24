package com.techcoders.spring.dto;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class ResponseDTO {
	private Long id;
	private Boolean status;
	private String msg;

	public Long getId() {
		return id;
	}

	public void setId(Long i) {
		this.id = i;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
