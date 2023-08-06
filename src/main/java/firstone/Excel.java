package firstone;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static void main(String[] args) {

		File f = new File("C:\\Users\\jp\\Desktop\\Book1.xlsx");
		
		try {
			FileInputStream f1 = new FileInputStream(f);
			Workbook w = new XSSFWorkbook();
			Sheet s = w.createSheet("Sheet1");
			for(int i=0; i<s.getPhysicalNumberOfRows();i++) {
				Row r = s.createRow(i);
				for(int j=0; j<r.getPhysicalNumberOfCells();j++) {
					Cell cell = r.createCell(j);
					int cellType = cell.getCellType();
					if(cellType == 1) {
						String value = cell.getStringCellValue();
						System.out.println(value);
					}
					if(cellType==0) {
						if(DateUtil.isCellDateFormatted(cell)) {
							Date d = cell.getDateCellValue();
							SimpleDateFormat sd = new SimpleDateFormat();
							String format = sd.format(d);
							System.out.println(format);
						}
					}
					else {
						double d = cell.getNumericCellValue();
						long l = (long)d;
						String valueOf = String.valueOf(l);
						System.out.println(valueOf);
					}
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}



















