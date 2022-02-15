package com.Project;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.hpsf.HPSFException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class Excel {

	  public  void exportToExcel(String sheetName, ArrayList headers,ArrayList data, String file_path) throws HPSFException {
		  
		  	File outputFile = new File(file_path);
		  	
	        HSSFWorkbook wb = new HSSFWorkbook();
	        
	        HSSFSheet sheet = wb.createSheet(sheetName);

	        int rowIdx = 0;
	        short cellIdx = 0;

	        // Header
	        HSSFRow hssfHeader = sheet.createRow(rowIdx);
	        HSSFCellStyle cellStyle = wb.createCellStyle();
	        
	        for (Iterator cells = headers.iterator(); cells.hasNext();) {
	            HSSFCell hssfCell = hssfHeader.createCell(cellIdx++);
	            hssfCell.setCellStyle(cellStyle);
	            hssfCell.setCellValue((String) cells.next());
	        }
	        // Data
	        rowIdx = 1;
	        for (Iterator rows = data.iterator(); rows.hasNext();) {
	            ArrayList row = (ArrayList) rows.next();
	            HSSFRow hssfRow = sheet.createRow(rowIdx++);
	            cellIdx = 0;
	            for (Iterator cells = row.iterator(); cells.hasNext();) {
	                HSSFCell hssfCell = hssfRow.createCell(cellIdx++);
	                hssfCell.setCellValue((String) cells.next());
	            }
	        }

	        wb.setSheetName(0, sheetName);
	        try {
	            FileOutputStream outs = new FileOutputStream(outputFile);
	            wb.write(outs);
	           
	            outs.close();
	        } catch (IOException e) {
	            throw new HPSFException(e.getMessage());
	        }

	    }
	  
	  public  boolean deletefolder(String folder_path) {
			File file = new File(folder_path);
		    File[] flist = null;

		    if(file == null){
		        return false;
		    }

		    if (file.isFile()) {
		        return file.delete();
		    }

		    if (!file.isDirectory()) {
		        return false;
		    }

		    flist = file.listFiles();
		    if (flist != null && flist.length > 0) {
		        for (File f : flist) {
		            if (!deletefolder(f.getAbsolutePath())) {
		                return false;
		            }
		        }
		    }

		    return file.delete();
		}
	  
	  public void exportToPDF(String sheetName, ArrayList headers,ArrayList data, String file_path) {
		  
		  try {
			  this.exportToExcel(sheetName, headers, data, file_path);

          FileInputStream input_document = new FileInputStream(new File(file_path));
          // Read workbook into HSSFWorkbook
          HSSFWorkbook my_xls_workbook = new HSSFWorkbook(input_document); 
          // Read worksheet into HSSFSheet
          HSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0); 
          // To iterate over the rows
          Iterator<Row> rowIterator = my_worksheet.iterator();
          //We will create output PDF document objects at this point
          Document iText_xls_2_pdf = new Document();
          PdfWriter.getInstance(iText_xls_2_pdf, new FileOutputStream(file_path.replace("xls", "pdf")));
          iText_xls_2_pdf.open();
          //we have two columns in the Excel sheet, so we create a PDF table with two columns
          //Note: There are ways to make this dynamic in nature, if you want to.
          PdfPTable my_table = new PdfPTable(headers.size());
          //We will use the object below to dynamically add new data to the table
          PdfPCell table_cell;
          //Loop through rows.
          while(rowIterator.hasNext()) {
                  Row row = rowIterator.next(); 
                  Iterator<Cell> cellIterator = row.cellIterator();
                          while(cellIterator.hasNext()) {
                                  Cell cell = cellIterator.next(); //Fetch CELL
                                 
                                  
                                  switch(cell.getCellType()) { //Identify CELL type
                                          //you need to add more code here based on
                                          //your requirement / transformations
                                  //Identify CELL type you need to add more code here based on your requirement / transformations
                                  case STRING :
                                	
                                	  	
                                         //Push the data from Excel to PDF Cell
                                         table_cell = new PdfPCell(new Phrase(cell.getStringCellValue()));

                                         //move the code below to suit to your needs
                                         my_table.addCell(table_cell);
                                         
                           
                                         break;

                              
                                  };
                                  

                      }
                                  //next line
                          }

          
          //Finally add the table to PDF document
          iText_xls_2_pdf.add(my_table);                       
          iText_xls_2_pdf.close();                
          //we created our pdf file..
          input_document.close(); //close xls
          
          this.deletefolder(file_path);
		  }
		  catch (Exception e) {
			  
		  }
	  }
}
