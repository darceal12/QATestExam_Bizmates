import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demoblaze_Login_Logout {
    private static final Logger log = LoggerFactory.getLogger(Demoblaze_Login_Logout.class);

    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.msedgedriver.driver", "C:/Users/darry/IdeaProjects/QATestExam_Bizmates/src/main/WebDriver");
        //Open browser
        String url = "https://www.demoblaze.com/index.html";
        WebDriver driver = new EdgeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println("A. Validate if the Username and Password account is valid.");
        try {
            WebElement home_page = driver.findElement(By.xpath("//a[@class='navbar-brand' and @id='nava']"));
            System.out.println("1. User is inside in the Demoblaze " + home_page.getText());
        } catch (NoSuchElementException e) {

        }

        try {
            WebElement login_btn = driver.findElement(By.xpath("//a[@class='nav-link' and @id='login2']"));
            login_btn.click();
            System.out.println("2. Login modal is appeared");

        } catch (ElementNotInteractableException e) {

        }
        //Positive Scenario: Valid username and password
        try {
            Thread.sleep(2000);
            //username=applicant_darrylmontes //valid
            //password=qwerty@123s //valid
            String uname = "applicant_darrylmontes";
            String pword = "qwerty@123s";
            WebElement username = driver.findElement(By.xpath("//input[@id='loginusername']"));
            WebElement password = driver.findElement(By.xpath("//input[@id='loginpassword']"));
            username.sendKeys(uname);
            password.sendKeys(pword);

        } catch (InvalidSelectorException e) {

        }
        try {
            Thread.sleep(2000);
            WebElement login_button = driver.findElement(By.xpath("//button[@type='button' and @class='btn btn-primary' and @onclick='logIn()']"));
            login_button.click();
            System.out.println("3. Successful login using valid account");

        } catch (ElementNotInteractableException e) {

        }

        try {
            Thread.sleep(2000);
            WebElement logout_button = driver.findElement(By.xpath("//a[@id='logout2']"));
            logout_button.click();
            System.out.println("4. Successful logout");
        } catch (ElementNotInteractableException e) {

        }
        System.out.println("/*----------------------------------------------------*/");
        System.out.println("B. Validate if the Username or Password is invalid account");
        try {
            WebElement login_btn = driver.findElement(By.xpath("//a[@class='nav-link' and @id='login2']"));
            login_btn.click();
            System.out.println("1. Login modal is appeared");

        } catch (ElementNotInteractableException e) {

        }
        //Negative Scenario: Invalid username and password
        try {
            Thread.sleep(2000);
            //username=applicant_darrylmontes //valid
            //password=qwerty@123s //valid
            String uname = "applicant_darrylmontes";
            String pword = "qwerty@123s";
            WebElement username = driver.findElement(By.xpath("//input[@id='loginusername']"));
            WebElement password = driver.findElement(By.xpath("//input[@id='loginpassword']"));
            username.sendKeys(uname + "ssssssssss");
            password.sendKeys(pword);

        } catch (InvalidSelectorException e) {

        }
        try {
            Thread.sleep(2000);
            WebElement login_button = driver.findElement(By.xpath("//button[@type='button' and @class='btn btn-primary' and @onclick='logIn()']"));
            login_button.click();
        } catch (ElementNotInteractableException e) {

        }

        try {
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
            System.out.println("3. An error message is displayed: User does not exist.");
        } catch (NoAlertPresentException e) {

        }

        try {
            Thread.sleep(2000);
            //username=applicant_darrylmontes //valid
            //password=qwerty@123s //valid
            String uname = "applicant_darrylmontes";
            String pword = "qwerty@123s";
            WebElement username = driver.findElement(By.xpath("//input[@id='loginusername']"));
            WebElement password = driver.findElement(By.xpath("//input[@id='loginpassword']"));
            username.sendKeys(Keys.CONTROL, "a" + Keys.DELETE);
            password.sendKeys(Keys.CONTROL, "a" + Keys.DELETE);
            username.sendKeys(uname);
            password.sendKeys(pword + uname);

        } catch (InvalidSelectorException e) {

        }
        try {
            Thread.sleep(2000);
            WebElement login_button = driver.findElement(By.xpath("//button[@type='button' and @class='btn btn-primary' and @onclick='logIn()']"));
            login_button.click();
        } catch (ElementNotInteractableException e) {

        }

        try {
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
            System.out.println("4. An error message is displayed 'Wrong Password' ");
        } catch (NoAlertPresentException e) {

        }

        try {
            Thread.sleep(2000);
            //username=applicant_darrylmontes //valid
            //password=qwerty@123s //valid
            String uname = "applicant_darrylmontes";
            String pword = "qwerty@123s";
            WebElement username = driver.findElement(By.xpath("//input[@id='loginusername']"));
            WebElement password = driver.findElement(By.xpath("//input[@id='loginpassword']"));
            username.sendKeys(Keys.CONTROL, "a" + Keys.DELETE);
            password.sendKeys(Keys.CONTROL, "a" + Keys.DELETE);
        } catch (InvalidSelectorException e) {

        }
        try {
            Thread.sleep(2000);
            WebElement login_button = driver.findElement(By.xpath("//button[@type='button' and @class='btn btn-primary' and @onclick='logIn()']"));
            login_button.click();
        } catch (ElementNotInteractableException e) {

        }
        try {
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
            System.out.println("5. An error message is displayed 'Please fill out Username and Password'");
        } catch (NoAlertPresentException e) {

        }

        Thread.sleep(5000);
        driver.quit();
        System.out.println("End of test");

    }
}
