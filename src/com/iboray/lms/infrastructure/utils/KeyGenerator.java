package com.iboray.lms.infrastructure.utils;

public class KeyGenerator{

	public static String computeNewCode(String maxCode,String head,int numCount){
		
		String newCode="";
		if(maxCode!=null && !"".equals(maxCode.trim())){
			int i=head.length();
			int j=maxCode.length();
			int k=j-i;
			
			String numPart=maxCode.substring(i,j);
			int theInt= new Integer(numPart).intValue();
			theInt++;
			String numString =new Integer(theInt).toString();
			k=k-numString.length();
			String temp0="";
			for(;k>0;k--){
				temp0=temp0+"0";
			}
			numString=temp0+numString;
			newCode=head+numString;
		}else{
			String temp0="";
			for(int k=numCount-1;k>0;k--){
				temp0=temp0+"0";
			}
			newCode=head+temp0+"1";
		}
		return newCode;
	}

}


