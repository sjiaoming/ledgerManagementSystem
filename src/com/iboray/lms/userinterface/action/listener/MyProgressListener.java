package com.iboray.lms.userinterface.action.listener;

import java.text.NumberFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;

public class MyProgressListener implements ProgressListener {

	private double megaBytes = -1;
	private HttpSession session;
	private HttpServletRequest request;
	public MyProgressListener(HttpServletRequest request) {
		session=request.getSession();
		this.request = request;
	}
	public void update(long pBytesRead, long pContentLength, int pItems) {
		//double mBytes = pBytesRead / 1000000;
		//double total=pContentLength/1000000;
		double mBytes = pBytesRead / 1000;
		double total=pContentLength/1000;
	       if (megaBytes == mBytes) {
	           return;
	       }
//	       System.out.println("total====>"+total);
//	       System.out.println("mBytes====>"+mBytes);
	       megaBytes = mBytes;
//	       System.out.println("megaBytes====>"+megaBytes);
//	       System.out.println("We are currently reading item " + pItems);
	       if (pContentLength == -1) {
//	           System.out.println("So far, " + pBytesRead + " bytes have been read.");
	       } else {
	           //System.out.println("So far, " + pBytesRead + " of " + pContentLength + " bytes have been read.");
	          double read=(mBytes/total);
	          if(read >= 0.6){
	        	  read = 0.6;
	          }
	          NumberFormat nf=NumberFormat.getPercentInstance();
	         // System.out.println("read===>"+nf.format(read));//生成读取的百分比 并放入session中
	          session.setAttribute("read", "已上传计划#"+nf.format(read));
//	          request.setAttribute("readr", "已上传计划#"+nf.format(read));
	       }
	}

}
