import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	
	public ArrayList<String> getData(String testcaseName) throws IOException
	{
		ArrayList<String> a= new ArrayList<String>();
		FileInputStream fis=new FileInputStream("C://ExcelFile//demoData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int sheets=workbook.getNumberOfSheets();       //return type of workbook.getNumberOfSheets() is int
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("testData"))
			{
			XSSFSheet sheet=workbook.getSheetAt(i); // here return type workbook.getSheetAt(i) is XSSFSheet
			//Step1)  Identify Testcases column by scanning the entire 1st row
			Iterator<Row> rows=sheet.iterator(); //return type is Iterator<Row>  //Sheet is collection of row
			Row firstrow=rows.next();  //Acess to 1st row
			//Scan first row by read each and every cell of that row
			Iterator<Cell> ce=firstrow.cellIterator();  //row is collection of cell
			int k=0;
			int column = 0;
			while(ce.hasNext())  //is next cell present then only goes inside 
			{
				Cell value=ce.next();
				if(value.getStringCellValue().equalsIgnoreCase("Testcases"))     
						{
							column=k;
						}
				k++;
			}
			System.out.println(column);   //print the column number index
			
			
			//Step2) //Once column is identified then scan entire testcase column to identify purchase testcase row.
			while(rows.hasNext())
			{
				Row r=rows.next();
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
				{
					//Step3)After you grab purchase testcase row pull all the data of that row and feed into test
					Iterator<Cell> cv=r.cellIterator();
					while(cv.hasNext())
					{
						//System.out.println(cv.next().getStringCellValue()); //printing data in output
						Cell c=cv.next();
						if(c.getCellType()==CellType.STRING)
						{
						a.add(c.getStringCellValue());						
					}
						else {
							a.add(NumberToTextConverter.toText(c.getNumericCellValue()));  //Parsing the value
							
						}
							
						}
				}
			
			}
						
		}
		
		}
		return a;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
	}
}
