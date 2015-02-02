package com.iboray.lms.infrastructure.utils;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class UUIDHexGenerator extends AbstractUUIDGenerator {  

    public static final UUIDHexGenerator DEFAULT = new UUIDHexGenerator();  

     private String sep = "";  

     protected String format(final int intval) {  

         final String formatted = Integer.toHexString(intval);  

         final StringBuffer buf = new StringBuffer("00000000");  

         buf.replace(8 - formatted.length(), 8, formatted);  

         return buf.toString();  

     }  

    

     protected String format(final short shortval) {  

         final String formatted = Integer.toHexString(shortval);  

         final StringBuffer buf = new StringBuffer("0000");  

         buf.replace(4 - formatted.length(), 4, formatted);  

         return buf.toString();  

     }  

    

     public Serializable generate(final Object obj) {  

         return new StringBuffer(36).append(format(getIP())).append(sep)
               .append(format(getJVM())).append(sep).append(format(getHiTime())).append(sep) 
         .append(format(getLoTime())).append(sep).append(format(getCount())).toString();  

     }  

    

    public void configure(final Properties params) {  

         sep = params.getProperty("separator", "");  

     }  

    

     public static final String generator() {  

         return String.valueOf(UUIDHexGenerator.DEFAULT.generate(null));  

     }  


     public static final String generator(final Object obj) {  

       return String.valueOf(UUIDHexGenerator.DEFAULT.generate(obj));  

     }  

    

     public static void main(final String[] args) {  

         //System.out.println(UUIDHexGenerator.generator());  
         // System.out.println(UUIDHexGenerator.generator());  
         long x = System.currentTimeMillis();
    	
         Set<String> set = new HashSet<String>();
         for(int i=0;i<100;i++){
        	 String s = UUIDHexGenerator.generator();
        	 System.out.println(s + "  " + s.length());
        	 set.add(s);
         }
         long y = System.currentTimeMillis();
         
         System.out.println(y-x);
         System.out.println(set.size());
     }  

 } 
