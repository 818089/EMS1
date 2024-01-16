package com.maze.helper;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.maze.model.Employee;

public class ExcelHelper {

	
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "Employee Name", "Yash Emp Id", "Grade", "Designation",
			"Base Location", "Current Location","Date Of Joining","Email","Employee Id",
			"Experience","File Name","Irm","Is Approved","Mobile No","Pool Allocation Date",
			"Primary Skills","Resource Availability Status","Resource Competancy","Resource Competancy Name","Secondary Skills"};
	static String SHEET = "Employee";

	public static boolean hasExcelFormat(MultipartFile file) {

	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }

	    return true;
	  }

	public static List<Employee> excelToEms(InputStream is) {
	    try {
	        Workbook workbook = new XSSFWorkbook(is);
	        Sheet sheet = workbook.getSheet(SHEET);
	        Iterator<Row> rows = sheet.iterator();

	        List<Employee> employees = new ArrayList<>();

	        int rowNumber = 0;
	        while (rows.hasNext()) {
	            Row currentRow = rows.next();

	            // skip header
	            if (rowNumber == 0) {
	                rowNumber++;
	                continue;
	            }

	            Iterator<Cell> cellsInRow = currentRow.iterator();

	            Employee employee = new Employee();

	            int cellIdx = 0;
	            while (cellsInRow.hasNext()) {
	                Cell currentCell = cellsInRow.next();

	                switch (cellIdx) {
	                    case 0:
	                        employee.setEmployeeName(currentCell.getStringCellValue());
	                        break;

	                    case 1:
	                        employee.setYashEmpId((long) currentCell.getNumericCellValue());
	                        break;

	                    case 2:
	                        employee.setGrade(currentCell.getStringCellValue());
	                        break;

	                    case 3:
	                        employee.setDesignation (currentCell.getStringCellValue());
	                        break;
	                        
	                    case 4:
	                        employee.setBaseLocation(currentCell.getStringCellValue());
	                        break;

	                    case 5:
	                        employee.setCurrentLocation(currentCell.getStringCellValue());;
	                        break;
	                    case 6:
	                    	if(DateUtil.isCellDateFormatted(currentCell)) {
	                    		Date date = currentCell.getDateCellValue();
	                    		
	                            String dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);
		                    	employee.setDateOfJoining(dateString);

	                    	}
//	                        employee.setDateOfJoining(String.valueOf(currentCell.getNumericCellValue()));
	                        break;
	                    case 7:
	                        employee.setEmail(currentCell.getStringCellValue());
	                        break;
	                    case 8:
	                        employee.setEmployeeId((int) currentCell.getNumericCellValue());
	                        break;
	                    case 9:
	                        employee.setExprience((int) currentCell.getNumericCellValue());
	                        break;
	                    case 10:
	                        employee.setFileName(currentCell.getStringCellValue());
	                        break;
	                    case 11:
	                        employee.setIrm(currentCell.getStringCellValue());
	                        break;
	                    case 12:
	                        employee.setIsapproved(currentCell.getStringCellValue());
	                        break;

	                    case 13:
	                        employee.setMobileNo((long) currentCell.getNumericCellValue());
	                        break;

	                    case 14:
	                    	if(DateUtil.isCellDateFormatted(currentCell)) {
	                    		Date date = currentCell.getDateCellValue();
	                    		
	                            String dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);
		                    	employee.setPoolAllocationDate(dateString);

	                    	}	                        break;

	                    case 15:
	                        employee.setPrimarySkills(currentCell.getStringCellValue());
	                        break;

	                    case 16:
	                        employee.setResourceAvailabilityStatus(currentCell.getStringCellValue());
	                        break;

	                    case 17:
	                        employee.setResourceCompetency((int) currentCell.getNumericCellValue());
	                        break;

	                    case 18:
	                        employee.setResourceCompetencyName(currentCell.getStringCellValue());
	                        break;

	                    case 19:
	                        employee.setSecondarySkills(currentCell.getStringCellValue());
	                        break;


	                    default:
	                        break;
	                }

	                cellIdx++;
	            }

	            employees.add(employee);
	        }

	        workbook.close();

	        return employees;
	    } catch (IOException e) {
	        throw new RuntimeException("Failed to parse Excel file: " + e.getMessage());
	    }
	}
	


}
