package com.iboray.lms.infrastructure.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ExcelRead {
   
    private HSSFWorkbook workbook;//工作簿
   
   /*
    * 读取文件路径字符串
    */
    
    public void importExcel(String strfile){
        try {
            //获取工作薄workbook
            workbook = new HSSFWorkbook(new FileInputStream(strfile));
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    /*
     * 读取文件
     */
    public void importExcel(File file){
    	try {
			 workbook = new HSSFWorkbook(new FileInputStream(file));
		} catch (Exception e) {
			e.printStackTrace();
		} 
    }
    /*
     * 读取文件流
     */
    public void importExcel(InputStream filestream){
    	try {
			 workbook = new HSSFWorkbook(filestream);
		} catch (Exception e) {
			e.printStackTrace();
		} 
    }
   
   /*
    * 获取想要第几张工作表的数据
    *importExcel导入
    */
//    public List readSet(int sheetNumber){
//        List<List> result = new ArrayList<List>();
//       
//        //获得指定的sheet
//        HSSFSheet sheet = workbook.getSheetAt(sheetNumber);
//        //获得sheet总行数
//        int rowCount = sheet.getLastRowNum();
//        if(rowCount < 1){
//            return result;
//        }
//        //HashMap<Integer, Object> map=new HashMap<Integer, Object>();
//        //遍历行row
//        for (int rowIndex = 0; rowIndex <= rowCount; rowIndex++) {
//            //获得行对象
//            HSSFRow row = sheet.getRow(rowIndex);
//            if(null != row){
//               // List<Object> rowData = new ArrayList<Object>();
//            	Vector<Object> vector=new Vector<Object>();
//                //获得本行中单元格的个数
//                int cellCount = row.getLastCellNum();
//                //遍历列cell
//                for (short cellIndex = 0; cellIndex < cellCount; cellIndex++) {
//                    HSSFCell cell = row.getCell(cellIndex);
//                    //获得指定单元格中的数据
//                    Object cellStr = this.getCellString(cell);
//                    
//                   // map.put(arg0, arg1)
//                    vector.add(cellStr);
//                }
//                result.add(vector);
//            }
//        }
//       
//        return result;
//    }
   
    /**
     * 从第几张工作表第几行的数据
     * importExcel导入
     */
     public List readRow(int sheetNumber,int rowIndex){
         List result = new ArrayList();
         //获得指定的sheet
         HSSFSheet sheet = workbook.getSheetAt(sheetNumber);
         //获得sheet总行数
         int rowCount = sheet.getLastRowNum();
         if(rowCount < 1){
             return result;
         }
         //遍历行row
         //for (int rowIndex = rows+2; rowIndex <= rowCount; rowIndex++) {
             //获得行对象
             HSSFRow row = sheet.getRow(rowIndex);
             if(null != row){
//             	Vector<Object> vector=new Vector<Object>();
                 //获得本行中单元格的个数
                 int cellCount = row.getLastCellNum();
                 //遍历列cell
                 for (short cellIndex = 0; cellIndex < cellCount; cellIndex++) {
                     HSSFCell cell = row.getCell(cellIndex);
                     //获得指定单元格中的数据
                     Object cellStr =this.getCellString(cell);
//                     vector.add(cellStr);
                     if(cellStr!=null){
//	                   	  if(cellIndex == 3){
//	                   		 result.add( new DecimalFormat("#").format(Integer.valueOf((String) cellStr)));
//	                   	 }else{
	                   		 result.add(cellStr.toString());
//	                     	 }
                     }else{
                    	 result.add(null);
                     }
                       
                 }
             }
         //}
        
         return result;
     }
     /**
      * 从第几张工作表第几行的数据
      * importExcel导入
      */
      public List readRow1(int sheetNumber,int rowIndex){
          List result = new ArrayList();
          //获得指定的sheet
          HSSFSheet sheet = workbook.getSheetAt(sheetNumber);
          //获得sheet总行数
          int rowCount = sheet.getLastRowNum();
          if(rowCount < 1){
              return result;
          }
          //遍历行row
          //for (int rowIndex = rows+2; rowIndex <= rowCount; rowIndex++) {
              //获得行对象
              HSSFRow row = sheet.getRow(rowIndex);
              if(null != row){
//              	Vector<Object> vector=new Vector<Object>();
                  //获得本行中单元格的个数
                  int cellCount = row.getLastCellNum();
                  //遍历列cell
                  for (short cellIndex = 0; cellIndex < cellCount; cellIndex++) {
                      HSSFCell cell = row.getCell(cellIndex);
                      //获得指定单元格中的数据
                      Object cellStr =this.getCellString(cell);
//                      vector.add(cellStr);
                      if(cellStr!=null){
 	                   		 result.add(cellStr.toString());
                      }else{
                     	 result.add(null);
                      }
                        
                  }
              }
          //}
         
          return result;
      }
     /**
      * 获取指定工作表的总
      * @param sheetNumber
      * @return
      */
     public int getRowIndex(int sheetNumber){
         HSSFSheet sheet = workbook.getSheetAt(sheetNumber);
         //获得sheet总行数
         int rowCount = sheet.getLastRowNum();
         if(rowCount < 1){
             return 0;
         }
         return rowCount;
     }
     /**
      * 从第几张工作表第几行读到第几行
      * @param sheetNumber
      * @param rows
      * @param getrows
      * @return
      */
//     public List readCell(int sheetNumber,int rows,int getrows){
//         List<List> result = new ArrayList<List>();
//        
//         //获得指定的sheet
//         HSSFSheet sheet = workbook.getSheetAt(sheetNumber);
//         //获得sheet总行数
//         int rowCount = getrows;
//         if(rowCount < 1){
//             return result;
//         }
//         //HashMap<Integer, Object> map=new HashMap<Integer, Object>();
//         //遍历行row
//         for (int rowIndex = rows+2; rowIndex <= rowCount; rowIndex++) {
//             //获得行对象
//             HSSFRow row = sheet.getRow(rowIndex);
//             if(null != row){
//                // List<Object> rowData = new ArrayList<Object>();
//             	Vector<Object> vector=new Vector<Object>();
//                 //获得本行中单元格的个数
//                 int cellCount = row.getLastCellNum();
//                 //遍历列cell
//                 for (short cellIndex = 0; cellIndex < cellCount; cellIndex++) {
//                     HSSFCell cell = row.getCell(cellIndex);
//                     //获得指定单元格中的数据
//                     Object cellStr = this.getCellString(cell);
//                     
//                    // map.put(arg0, arg1)
//                     vector.add(cellStr);
//                 }
//                 result.add(vector);
//             }
//         }
//        
//         return result;
//     }
     /**
      * 读取第几张工作表的第几列
      * @param sheetNumber
      * @param cells
      * @return
      */
//     public List readColum(int sheetNumber,int cells){
//         List<List> result = new ArrayList<List>();
//        
//         //获得指定的sheet
//         HSSFSheet sheet = workbook.getSheetAt(sheetNumber);
//         //获得sheet总行数
//         int rowCount = sheet.getLastRowNum();
//         if(rowCount < 1){
//             return result;
//         }
//         //HashMap<Integer, Object> map=new HashMap<Integer, Object>();
//         //遍历行row
//         for (int rowIndex = 2; rowIndex <= rowCount; rowIndex++) {
//             //获得行对象
//             HSSFRow row = sheet.getRow(rowIndex);
//             if(null != row){
//                // List<Object> rowData = new ArrayList<Object>();
//             	Vector<Object> vector=new Vector<Object>();
//                 //获得本行中单元格的个数
//                     HSSFCell cell = row.getCell(cells);
//                     Object cellStr = this.getCellString(cell);
//                     vector.add(cellStr);
//                     result.add(vector);
//             }
//         }
//        
//         return result;
//     }
   /**
    * 获取一个cell的数据类型
    * @param cell
    * @return
    */
    private Object getCellString(HSSFCell cell) {
        // TODO Auto-generated method stub
        Object result = null;
        if(cell != null){
            //单元格类型：Numeric:0,String:1,Formula:2,Blank:3,Boolean:4,Error:5
            int cellType = cell.getCellType();
            switch (cellType) {
            case HSSFCell.CELL_TYPE_STRING:
                result = cell.getRichStringCellValue().getString();
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
				if(HSSFDateUtil.isCellDateFormatted(cell))
				{
					result = cell.getDateCellValue();
				}
				else{
						double a = cell.getNumericCellValue();
						if(String.valueOf(a).toUpperCase().indexOf('E') > -1 ){ 
							result = String.valueOf(new DecimalFormat("#.######").format(a));
							
						}else{
							result = String.valueOf(new DecimalFormat("#.######").format(a));
						}
					}
				break;
            case HSSFCell.CELL_TYPE_FORMULA:
                result = cell.getNumericCellValue();
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                result = cell.getBooleanCellValue();
                break;
            case HSSFCell.CELL_TYPE_BLANK:
                result = null;
                break;
            case HSSFCell.CELL_TYPE_ERROR:
                result = null;
                break;
            default:
                System.out.println("枚举了所有类型");
                break;
            }
        }
        return result;
    }
   
    
    public static void main(String[] args) throws Exception {

        ExcelRead parser = new ExcelRead();
        parser.importExcel("//Users//shijiaoming//2.xls");
        System.out.println("--行数--"+parser.getRowIndex(0));

    	List<Object> listparam=null;
    	String temp_user_id="";
    	int rowcount=parser.getRowIndex(0);
    	  for (int i = 0; i <= rowcount; i++) {
				List listuser = parser.readRow(0, i);
				System.out.println(listuser.toString());
              for (int j = 0; j < listuser.size(); j++) {
              	temp_user_id=listuser.get(j).toString();
				}
    	  }
        
       
    }
}

