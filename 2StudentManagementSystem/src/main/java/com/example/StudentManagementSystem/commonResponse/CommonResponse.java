package com.example.StudentManagementSystem.commonResponse;

import java.util.List;

import com.example.StudentManagementSystem.requestDto.RequestDto;

public class CommonResponse {

	private String statusMessage;
	private String statusCode;
	private RequestDto data;
	private List<RequestDto> dtoList;

	public CommonResponse(String statusMessage, String statusCode, List<RequestDto> dtoList) {
		super();
		this.statusMessage = statusMessage;
		this.statusCode = statusCode;
		this.dtoList = dtoList;
	}

	public CommonResponse(String statusMessage, String statusCode, RequestDto data) {
		super();
		this.statusMessage = statusMessage;
		this.statusCode = statusCode;
		this.data = data;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public RequestDto getData() {
		return data;
	}

	public void setData(RequestDto data) {
		this.data = data;
	}

	public List<RequestDto> getDtoList() {
		return dtoList;
	}

	public void setDtoList(List<RequestDto> dtoList) {
		this.dtoList = dtoList;
	}

}
