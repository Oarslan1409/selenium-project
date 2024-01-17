import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticeFormPage  {

    private static WebDriver driver;
    private static final By email = By.id("L-UserNameField");
    private static final By password = By.id("L-PasswordField");
    private static final By button = By.id("gg-login-enter");


    public PracticeFormPage(WebDriver driver){
        PracticeFormPage.driver = driver;
    }


    public void setEmail(String emailAsString) {
        WebElement nameSpace = driver.findElement(email);
        nameSpace.click();
        nameSpace.sendKeys(emailAsString);
    }

    public void setPassword(String passwordAsString) {
        WebElement nameSpace = driver.findElement(password);
        nameSpace.click();
        nameSpace.sendKeys(passwordAsString);
    }

    public static String getEmail(){
        WebElement nameSpace = driver.findElement(email);
        return nameSpace.getAttribute("value");
    }
    public static String getPassword(){
        WebElement nameSpace = driver.findElement(password);
        return nameSpace.getAttribute("value");
    }

    public static void loginButton() {
        WebElement nameSpace = driver.findElement(button);
        nameSpace.click();
    }

}
