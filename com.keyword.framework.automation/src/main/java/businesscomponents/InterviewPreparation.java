package businesscomponents;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.text.PDFTextStripper;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class InterviewPreparation {
	
	public void filloApi() throws FilloException{
		String filepath = System.getProperty("user.dir")+"\\fillowApi.xlsx";
		String selectQuery = String.format("Select * from Sheet1 WHERE FIRSTNAME = 'Sundar' AND MiddleName = 'Raj' AND  LastName = 'S' AND ID = '1000'");		
		System.out.println("filepath : "+filepath);
		String str= "hello";
		Fillo fillo = new Fillo();
		Connection connection = null;
		Recordset 
		recordset = null;
		try {
			connection = fillo.getConnection(filepath);
			recordset = connection.executeQuery(selectQuery);
			int count = recordset.getCount();
			System.out.println("data set count "+count);
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String phonenumber = null;
		try {
			while(recordset.next()) {
				phonenumber = recordset.getField("PHONENUMBER");
				System.out.println("the User phone number is "+phonenumber);
			}
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void pdfvalidation() throws IOException, InterruptedException {
		String path = System.getProperty("user.dir")+"\\PLAG_report.pdf";
		try {
		    // Use FileInputStream for local file path, not URL
		    InputStream is = new FileInputStream(path);     // Open local file stream
		    BufferedInputStream bis = new BufferedInputStream(is);
		    PDDocument doc = PDDocument.load(bis); // Load PDF from BufferedInputStream as InputStream
		    PDFTextStripper stripper = new PDFTextStripper();
		    String text = stripper.getText(doc);
	    	System.out.println("PDF Text "+text);
		    PDPageTree pages = doc.getDocumentCatalog().getPages();
		    System.out.println("No Of Pages "+doc.getNumberOfPages());
		    for(int i=1;i<=doc.getNumberOfPages();i++) {
		    	stripper.setStartPage(i);
		    	stripper.setEndPage(i);
		    	if(stripper.getText(doc).contains("Plagiarism")) {
		    		Splitter s = new Splitter();
		    		int topage =i+3, frompage =i;
		    		s.setStartPage(i);
		    		s.setEndPage(i+3);
		    		s.setSplitAtPage(topage - frompage-1);
		    		List<PDDocument>doc1= s.split(doc);
		    		PDDocument pd = doc1.get(0);
		    		
		    		String outputDir = "C:\\Users\\S.B. Sundar Raj\\eclipse-workspace-new2024\\com.framework.automation.keyword\\";
		    		File dir = new File(outputDir);
		    		if(!dir.exists()) {
		    		    dir.mkdirs();
		    		}
		    		String fileName = "Splitted_Pages_1_to_4.pdf";
		    		String fullPath = outputDir + fileName;
		    		pd.save(fullPath);
		    		System.out.println("Document page is saved succesfully");
		    	}
		    	
		    }    
		   
		    // Extract text
		    doc.close();
		    bis.close();
		    is.close();
		    String pathtofile = "\"C:\\Users\\S.B. Sundar Raj\\Downloads\\pythonFile.py\"";
		    ProcessBuilder proc = new ProcessBuilder("python",pathtofile);
		    Process p = proc.start();
		    p.waitFor();
		    BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
		    String textterminal = bf.readLine();
		    System.out.println("Text Terminal "+ textterminal);
		    
		    Process pro = Runtime.getRuntime().exec("taskkill /F /IM AcroRd32.exe");
		    pro.waitFor();

		} catch (MalformedURLException e) {
			InputStream isn = new FileInputStream("");
			BufferedInputStream bif = new BufferedInputStream(isn);
			PDDocument pd = PDDocument.load(bif);
			PDFTextStripper txt = new PDFTextStripper();
			String txtPdf = txt.getText(pd);
			for(int i=0;i<pd.getNumberOfPages();i++) {
				txt.setStartPage(i);
				txt.setEndPage(i);
				Splitter s = new Splitter();
				if(txt.getText(pd).contains("")) {
					s.setStartPage(i);
					s.setEndPage(i+3);
					s.setSplitAtPage(i+3-i-1);
					List<PDDocument>pds = s.split(pd);
					PDDocument pd1 = pds.get(0);
					File nf = new File("path");
					if(!nf.exists()) {
						nf.mkdir();
					}
					pd1.save(nf);
					pd.close();
					bif.close();
					isn.close();
					
				}
			}
			
			
			ProcessBuilder pbd = new ProcessBuilder("python","filepath");
			Process p = pbd.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = br.readLine();
			p=Runtime.getRuntime().exec("");
			
			
			
		}
		
	}
	
	

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		InterviewPreparation interviewPreparation = new InterviewPreparation();
		try {
			interviewPreparation.filloApi();
			interviewPreparation.pdfvalidation();
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}

}
