package com.sleftraining.dto;

import java.io.Serializable;

public class ResponseStatusDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String statusCode;
	private String statusMessageEN;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessageEN() {
		return statusMessageEN;
	}

	public void setStatusMessageEN(String statusMessageEN) {
		this.statusMessageEN = statusMessageEN;
	}

	public ResponseStatusDTO(String statusCode, String statusMessageEN) {
		super();
		this.statusCode = statusCode;
		this.statusMessageEN = statusMessageEN;
	}

	@Override
	public String toString() {
		return "StatusDTO [statusCode=" + statusCode + ", statusMessageEN="
				+ statusMessageEN + "]";
	}
	
}
