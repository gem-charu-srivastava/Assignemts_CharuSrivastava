import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Keyboardmouseevent {
    public static void main(String[] args) throws InterruptedException {


        //1)Launch https://chercher.tech/practice/practice-pop-ups-selenium-webdriver

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ch.srivastava\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");

        //2)Click on Alert and accept it

        /*driver.findElement(By.name("alert")).click();
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        System.out.println("CHARU");
        alert.accept();*/


        //3)Click on confirmation box and get the text and cancel it

      /*  driver.findElement(By.name("confirmation")).click();
        Thread.sleep(5000);
        Alert confirmationAlert = driver.switchTo().alert();
        String alertText= confirmationAlert.getText();
        System.out.println("Alert message is " + alertText);
        confirmationAlert.dismiss();*/


        //4)  Click on prompt and enter text and accept it

       /* driver.findElement(By.name("prompt")).click();
        Thread.sleep(5000);
        Alert promptAlert  = driver.switchTo().alert();
        String prompttext = promptAlert.getText();
        System.out.println("Alert text is " + prompttext);
        promptAlert.sendKeys("Enter your name");
        Thread.sleep(5000);
        promptAlert.accept(); */

        //5)Upload any sample file

       /* driver.findElement(By.name("upload")).click();
        Alert uploadElement=driver.switchTo().alert();
        uploadElement.sendKeys("C:\\Users\\ch.srivastava\\OneDrive - Gemini Solutions\\Documents\\Samplefile"); */


    //6)Double click on Double click me and get the text from alert

       /* Actions actions=new Actions(driver);
        WebElement element=driver.findElement(By.id("double-click"));
        actions.doubleClick(element).perform();
        String doubleclickalerttext=driver.switchTo().alert().getText();
        System.out.println("Alert Text is : " + doubleclickalerttext); */

 //7)Move mouse to Sub menu and click on it
        /*WebElement element=driver.findElement(By.id("sub-menu"));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        action.moveToElement(element).click();*/

    //8) Press tab key and select google and click on it
        
        WebElement element=driver.findElement(By.id("sub-menu"));
        Actions action =new Actions(driver);
        action.moveToElement(element).perform();
        element.sendKeys(Keys.TAB);
        element.sendKeys(Keys.ENTER);


    }}
