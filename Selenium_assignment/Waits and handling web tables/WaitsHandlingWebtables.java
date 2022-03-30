import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class WaitsHandlingWebtables {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ch.srivastava\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");


       /*System.out.println(" Coloumn elements are :");
       List<WebElement> elements = driver.findElements(By.xpath("//table[@id='customers']//tbody//tr//td[1]"));
        for(int i =0;i<= elements.size();i++) {
            System.out.println(elements.get(i).getText());*/

       /* System.out.println("Row elements are :");

        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='customers']//tbody//tr"));
        for(int i =1;i<= elements.size();i++) {
            System.out.println(elements.get(i).getText());*/



        WebElement element=driver.findElement(By.xpath("//table[@id='customers']//tbody//tr[4]"));
        String s=element.getText();
        String s1;
        WebElement element2;
        if(s.equals("Microsoft")){
            element2=driver.findElement(By.xpath("//table[@id='customers']//tbody//tr[4]//td[2]"));
            s1=element2.getText();
            Assert.isTrue(true, String.valueOf(s1.equals("Roland Mendel")));
        }else{
            Assert.fail();
        }}}


