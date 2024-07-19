package com.example.AttendanceManagemetSystem.commonresponse;

import java.util.List;

public class CommonResponse <T>{
	  private String statusmessage;
	    private String statuscode;
	    
	    public String message2;
	    private T data;
	    private List<T> dataList;
	    
	    
	    
	 




		public CommonResponse(String statusmessage, String statuscode, List<T> dataList) {
			super();
			this.statusmessage = statusmessage;
			this.statuscode = statuscode;
			this.dataList = dataList;
		}





		public CommonResponse(String statusmessage, String statuscode) {
			super();
			this.statusmessage = statusmessage;
			this.statuscode = statuscode;
		}
		
		
		
		
		
		public String getStatusmessage() {
			return statusmessage;
		}
		public void setStatusmessage(String statusmessage) {
			this.statusmessage = statusmessage;
		}
		public String getStatuscode() {
			return statuscode;
		}
		public void setStatuscode(String statuscode) {
			this.statuscode = statuscode;
		}
		public String getMessage2() {
			return message2;
		}
		public void setMessage2(String message2) {
			this.message2 = message2;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public List<T> getDataList() {
			return dataList;
		}
		public void setDataList(List<T> dataList) {
			this.dataList = dataList;
		}

}
