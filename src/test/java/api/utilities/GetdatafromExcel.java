package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class GetdatafromExcel {
	 private static String s = "SDHLog";
	 private static String s1 = System.getProperty("user.dir")+ProjectConfigurations.LoadProperties("DriverExcel");
	//System.getProperty("user.dir")+"/TestData/DriverExcel.xls";		 	 
	 private static Map<String, String> map = new HashMap<String, String>();

	 public static String get(String testcasename,String columnname) throws IOException {
	 FileInputStream fis;
	 int k =0;
	
	 //System.out.println(s1);
	 try {
		 fis = new FileInputStream(s1);
		 HSSFWorkbook wb = new HSSFWorkbook(fis);
		 HSSFSheet ws = wb.getSheet(s);
		 int rows = ws.getPhysicalNumberOfRows();
		 for(int i=0;i<rows;i++){
			 int cols = ws.getRow(0).getPhysicalNumberOfCells();
			 for (int j = 0; j < cols; j++) { 
			 if(ws.getRow(i).getCell(j,Row.CREATE_NULL_AS_BLANK).toString().replace(".00", "").
				 equalsIgnoreCase(columnname)){ 
				 	k=j;
				 }
				 map.put(ws.getRow(i).getCell(0,Row.CREATE_NULL_AS_BLANK).toString().replace(".00", ""),
				 ws.getRow(i).getCell(k,Row.CREATE_NULL_AS_BLANK).toString().replace(".00", "")); 
			 }
		 } 
	 }catch (Exception e){/*e.printStackTrace();*/ } 
	 return map.get(testcasename);
	 } 
	

}