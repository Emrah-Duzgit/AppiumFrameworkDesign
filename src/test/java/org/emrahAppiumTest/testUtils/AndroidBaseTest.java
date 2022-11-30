package org.emrahAppiumTest.testUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.emrahAppiumTest.pageObjects.anrdoid.FormPage;
import org.emrahAppiumTest.utils.AppiumUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class AndroidBaseTest extends AppiumUtils{


    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    public FormPage formPage;


    @BeforeClass
    public void ConfigureAppium() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("\\Users\\emrah\\IdeaProjects\\AppiumFrameworkDesign\\src\\main\\resources\\data.properties");

        prop.load(fis);
        String ipAddress = prop.getProperty("ipAddress");
        String port = prop.getProperty("port");
        String deviceName = prop.getProperty("androidDeviceName");

        service = startAppiumServer(ipAddress,Integer.parseInt(port));
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(deviceName);
        options.setChromedriverExecutable("\\Users\\emrah\\IdeaProjects\\LearningAppium\\src\\test\\java\\Driver\\chromedriver.exe");

        //options.setApp("\\Users\\emrah\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
        options.setApp(System.getProperty("user.dir"+"\\src\\test\\java\\resources\\General-Store.apk"));



        driver = new AndroidDriver(service.getUrl(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        formPage = new FormPage(driver);

    }


    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }

}
