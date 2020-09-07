package org.halodoc.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseLib {
    protected FileInputStream fileInputStream;
    protected Properties properties = new Properties();
    protected static String baseUrl=null, username=null, password=null;
    protected static WebDriver driver;
    protected static DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    protected static ZonedDateTime now = ZonedDateTime.now();

    protected void initTest(){
        try{
            fileInputStream = new FileInputStream("src\\test\\resources\\config\\config.properties");
            properties.load(fileInputStream);
            //System.out.println(properties.toString());
            this.baseUrl=properties.getProperty("BaseUrl");
            this.username=properties.getProperty("username");
            this.password=properties.getProperty("password");
            //System.out.println("BaseUrl : "+baseUrl+"\nuser:"+username);
        }
        catch (Exception ex){
            System.out.println("File config.properties was not found under src\\test\\resources\\config");
            ex.printStackTrace();
        }
    }

    protected void home(){
        System.setProperty("webdriver.chrome.driver","src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //System.out.println("BaseUrl:"+baseUrl);
        driver.get(baseUrl);
    }

    protected Properties loadPropFile(String fileName){
        Properties propFile = new Properties();
        try {
            String filePath="src\\test\\resources\\pageobjects\\"+fileName;
            System.out.println("filePath : "+filePath);
            FileInputStream fis = new FileInputStream(filePath);
            propFile.load(fis);
        }
        catch (Exception ex){
            System.out.println("Property file not found");
            ex.printStackTrace();
        }
        return propFile;
    }

    protected void setText(String xpath, String value){
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }

    protected void clickItem(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    protected boolean verifyElement(String xpath){
        boolean flag=false;
        if(driver.findElement(By.xpath(xpath)).isDisplayed()){
            flag=true;
        }
        return flag;
    }

    protected String getProperties(String xpath, String propName){
        return driver.findElement(By.xpath(xpath)).getAttribute(propName);
    }

    /*protected void waitForElement(String xpath){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }*/

    protected void waitForServer(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    protected void waitForServer(int time){
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    protected String generateRandomNumber(){
        return dtf.format(now);
    }

    protected void switchToFrame(String xpath){
        driver.switchTo().frame(xpath);
    }
}
