package org.emrahAppiumTest.testUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

    static ExtentReports extent;

    public static ExtentReports getReporterObject()
    {
        ExtentSparkReporter reporter = new ExtentSparkReporter("\\Users\\emrah\\IdeaProjects\\AppiumFrameworkDesign\\src\\test\\java\\org\\emrahAppiumTest\\reports\\index.html");
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Emrah DUZGIT");
        return extent;

    }
}
