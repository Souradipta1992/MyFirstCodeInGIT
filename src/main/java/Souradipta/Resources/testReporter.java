package Souradipta.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class testReporter {

	public ExtentReports getReportObject() {
		
		String reportPath = System.getProperty("user.dir")+ "\\Reports\\index.html";		
		ExtentSparkReporter extent = new ExtentSparkReporter(reportPath);
		
		ExtentReports reports = new ExtentReports();
		reports.attachReporter(extent);
		return reports;
		
	}

}
