import com.beust.jcommander.IStringConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Seleniumproj_dropdown{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ch.srivastava\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://codepen.io/abdulmlik/pen/dJOJov");

        driver.switchTo().frame("result");

        Select day = new Select(driver.findElement(By.xpath("//*[@id='day']")));
        day.selectByVisibleText("5");
        System.out.println(day.getFirstSelectedOption().getText());

       Select month  = new Select(driver.findElement(By.xpath("//*[@id='month']")));
        month.selectByVisibleText("5");
        System.out.println(month.getFirstSelectedOption().getText());


       Select year = new Select(driver.findElement(By.xpath("//*[@id='year']")));
        year.selectByVisibleText("2005");
        System.out.println(year.getFirstSelectedOption().getText());


        List<WebElement> elements=driver.findElements(By.xpath("//*[@id='year']"));
       List<String> mylist= new ArrayList<String>();
        for(WebElement element : elements){
          mylist.add(element.getText());
        }
    Collections.sort(mylist);

        for(int i=0;i<mylist.size();i++){
            System.out.println(mylist.get(i));
        }}}




