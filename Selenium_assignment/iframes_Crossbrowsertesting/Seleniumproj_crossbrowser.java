import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Seleniumproj_crossbrowser{
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ch.srivastava\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        long starttime = System.currentTimeMillis();
        driver.get("https://www.geminisolutions.com");
        long endtime = System.currentTimeMillis();
        long totalTime1 = endtime-starttime;
        System.out.println("Time taken by chromedriver is : "  + totalTime1 + "millisec");
        System.out.println(driver.getTitle());

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\ch.srivastava\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
        WebDriver driver2 = new FirefoxDriver();
        long starttime2 = System.currentTimeMillis();
        driver2.get("https://www.geminisolutions.com");
        long endtime2 = System.currentTimeMillis();
        long totalTime2 = endtime2-starttime2;
        System.out.println("Time taken by firefox driver is : " + totalTime2 + "millisec");
        System.out.println(driver2.getTitle());

        System.setProperty("webdriver.ie.driver", "C:\\Users\\ch.srivastava\\Downloads\\IEDriverServer_x64_4.0.0\\IEDriverServer.exe");
        WebDriver driver3 = new InternetExplorerDriver();
        long starttime3 = System.currentTimeMillis();
        driver3.get("https://www.geminisolutions.com");
        long endtime3 = System.currentTimeMillis();
        long totalTime3 = endtime3-starttime3;
        System.out.println("Time taken by ie driver is : " + totalTime3 + "millisec");
        System.out.println(driver3.getTitle());

    }
}
