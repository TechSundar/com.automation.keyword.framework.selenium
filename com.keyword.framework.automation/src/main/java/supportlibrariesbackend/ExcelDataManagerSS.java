package supportlibrariesbackend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataManagerSS {

	public static String runManagerPath;
	FrameworkParameters frameworkParameters = FrameworkParameters.getInstance();
	private String relativePath;

	public static String getPath() {
		return runManagerPath;
	}
	
	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
		}
	public String getRelativePath() {
		return relativePath;
	}

	public static void initialize_relativePath() {
		String path = new File(System.getProperty("user.dir")).getAbsolutePath();
		if (path.contains("supportlibraries")) {
			path = new File(System.getProperty("user.dir")).getParent();
		}
	}

	public static void initialize_runManagerPath() {

		String path = new File(System.getProperty("user.dir")).getAbsolutePath();
		try {
			if (path.contains("com.framework.automation.keyword")) {
				String absoluteFilePath = path + getFileSeparator() + "RunManager" + ".xlsm";
				FileInputStream fileInputStream;
				try {
					System.out.println("Runmanager path" + absoluteFilePath);
					fileInputStream = new FileInputStream (absoluteFilePath); 
					runManagerPath = absoluteFilePath;
					fileInputStream.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					throw new RuntimeException("The Runmanager file \""

					+ absoluteFilePath + "\" does not exist!");

					}
				}
				else if(path.contains("supportlibraries")) {
					path= new File(System.getProperty("user.dir")).getParent();
					if(path.contains("RunManager.xlsm")) {
						String rm= path+"/RunManager.xlsm";
						System.out.println("Runmanager path" + rm);
						runManagerPath = rm;
						

					}
					}
		} catch (Exception e) {
			e.printStackTrace();

		}

}
	

	public static String getFileSeparator() {
		return System.getProperty("file.separator");
	}
	public static List<String[]> loadRunManager() {
			initialize_runManagerPath();
			String path = getPath();
			String excelPath = path;// "C:\\Users\\DUSH024\\framework\\frameworkLearning\\RunManager.xlsm";
			List<String[]> data = new ArrayList<>();
			try (FileInputStream fis =new FileInputStream(excelPath);) {
				Workbook workbook= new XSSFWorkbook(fis); 
				Sheet worksheet= workbook.getSheet("Regression");
				Row headerRow=worksheet.getRow(0);
				int testCaseCol = -1;
				int executeCol = -1;
				for (Cell cell : headerRow) {
					String cellValue = cell.getStringCellValue(); 
					if ("TestCase".equalsIgnoreCase(cellValue)) {

						testCaseCol=cell.getColumnIndex();

						} else if ("Execute".equalsIgnoreCase(cellValue)) {
								executeCol = cell.getColumnIndex();
						}
				}
				if (testCaseCol == -1 || executeCol == -1) { 
					System.out.println("Required columns not found from function loadRunManager");
				}
				for (int r = 1; r <= worksheet.getLastRowNum(); r++) {
					Row row = worksheet.getRow(r);
					if (row != null) {
					Cell testCaseCell = row.getCell(testCaseCol);
					Cell executeCell = row.getCell(executeCol); 
					String testCaseValue = testCaseCell == null? "": testCaseCell.toString(); 
					String executeValue = executeCell == null? "" : executeCell.toString();
					data.add(new String[] { testCaseValue, executeValue });
					}

					} 

				for (String[] rowValues: data) {
	//System.out.println(rowValues[8] + "\t" + rowvalues[1]);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return data;
	}

	public static Map getRunInfo() {
		List<String[]>list=loadRunManager();
		Map<String, String>config = new LinkedHashMap<>();
		for(String[] pair:list) {
			if(pair.length>=2) {
				config.put(pair[0], pair[1]);
			}
		}
		//for(Map.Entry<String, String>entry:config.entrySet()) { }
		//System.out.println("Key: "+entry.getKey()+"---Pair: "+entry.getValue());
		return config;

	}
	
	public String getExecuteStatus(String currentTestcase) {
		String status=null;
		Map<String,String>map = getRunInfo();
		for(Map.Entry<String,String>newMap: map.entrySet()){
			if(newMap.getKey().contains(currentTestcase)) {
				status=newMap.getValue();
			}
			
		}
		return status;
	}

	
}