import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

    public class Webtable {
        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ch.srivastava\\Downloads\\chromedriver_win32\\chromedriver.exe");
            ChromeDriver driver = new ChromeDriver();
            driver.get("file:///C:/Users/ch.srivastava/Downloads/assignment.html");

            List<WebElement> elements = driver.findElements(By.xpath("/html/body/table/tbody/tr"));
            ArrayList<String> list=new ArrayList<String>();
            for (WebElement cell : elements) {
                System.out.println("Elemets are   " + cell.getText());
                list.add(cell.getText());

           }}}
