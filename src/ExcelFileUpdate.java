import java.io.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.*;
import java.util.HashMap;


public class ExcelFileUpdate {
	 public static void main(String[] args) throws Exception{
         HashMap<String, Double> prices = DownloadPage.prices;
         System.out.println(prices);
         String[] indices = (String[]) prices.keySet().toArray(new String[16]);
         FileInputStream fsIP = new FileInputStream(new File("/Users/danielberlin/Documents/Duke/Fall_2018/ECON256/ECON256_Journal_BerlinDaniel.xlsx")); //Read the spreadsheet that needs to be updated  
         XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook  
         XSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it.
         
         for (int i = 1; i < 16; i++) {
        	 Cell cell = null; // declare a Cell object
             cell = worksheet.getRow(20).getCell(i+1);   // Access the second cell in second row to update the value
             cell.setCellValue(prices.get(indices[i]).toString());  // Get current cell value value and overwrite the value
         }
           
         fsIP.close(); //Close the InputStream
         FileOutputStream output_file = new FileOutputStream(new File("/Users/danielberlin/Documents/Duke/Fall_2018/ECON256/ECON256_Journal_BerlinDaniel.xlsx"));  //Open FileOutputStream to write updates  
         wb.write(output_file); //write changes  
         output_file.close();  //close the stream    
 }
}
