package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtent() {

        if(extent == null){

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter("test-output/ExtentReport.html");

            sparkReporter.config().setReportName("OrangeHRM Automation Report");
            sparkReporter.config().setDocumentTitle("Automation Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Tester", "Gajendra Singh");
            extent.setSystemInfo("Framework", "Selenium-Cucumber-TestNG");
        }

        return extent;
    }
}
