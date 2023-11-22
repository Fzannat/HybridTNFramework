package com.qa.tutorialsninja.TestBase;


import com.qa.tutorialsninja.Utilties.Util;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;
    public ChromeOptions options;
    public Properties prop;
    public FileInputStream ip;
    public FileInputStream ip1;
    public Properties dataprop;

    public TestBase() throws Exception{
        prop = new Properties();
        ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/qa/tutorialsninja/Config/Config.properties");
        prop.load(ip);

        dataprop = new Properties();
        ip1 = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/com/qa/tutorialsninja/TestData/TestData.properties");
        dataprop.load(ip1);


    }


    public WebDriver initializeBrowserAndOpenApplication(String browserName){
        if(browserName.equals("chrome")){
            options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            options.addArguments("--start-maximized");
            options.addArguments("--incognito");
            options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infobars"));
            driver = new ChromeDriver(options);
        }else if(browserName.equals("firefox")){
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }else if(browserName.equals("edge")){
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.IMPLICIT_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Util.PAGE_LOAD_TIME));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Util.SCRIPT_TIMEOUT));
        return driver;
    }


}