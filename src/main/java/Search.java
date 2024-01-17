
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

public class Search{
    private static WebDriver driver;
    private static final By search = By.cssSelector("input[name='k']");
    private static final By searchButton =  By.cssSelector("button[data-cy='search-find-button']");
    private static final By productPricePage =  By.cssSelector("span[id='sp-price-highPrice']");
    private static final By productDiscount =  By.cssSelector("div[id='sp-price-lowPrice']");


    public Search(WebDriver driver) {
        Search.driver = driver;
    }

    public static void setSearchText(String searchTextAsString) {
        WebElement nameSpace = driver.findElement(search);
        nameSpace.click();
        nameSpace.sendKeys(searchTextAsString);
    }

    public static String getSearchText(){
        WebElement nameSpace = driver.findElement(search);
        return nameSpace.getAttribute("value");
    }

    public static void searchButton() {
        WebElement nameSpace = driver.findElement(searchButton);
        nameSpace.click();
    }

    public static void secondPage() {
        /*
        //Pager yapısındaki linke tıklar
        final By secondPage =  By.cssSelector("div.pager.pt30.hidden-m.gg-d-24 ul.clearfix li:nth-of-type(2) a");
        WebElement element = driver.findElement(secondPage);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();*/
        
        driver.get("https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2");
    }

    public static int randomNumber() {
        Random rand = new Random();
        int randomNum = rand.nextInt((47 - 1) + 1) + 1;
        Log4j.info("Rastgele üretilen sayı: " + randomNum);
        Log4j.info("Seçilen ürün: " + randomNum + ".");
        return randomNum;
    }

    public static void selectProduct() {
        int randomNumber = randomNumber();
        final By selectProduct =  By.cssSelector("div.clearfix ul.catalog-view.clearfix.products-container li:nth-of-type("+randomNumber+") a.product-link");
        WebElement nameSpace = driver.findElement(selectProduct);
        Actions actions = new Actions(driver);
        actions.moveToElement(nameSpace).click().perform();
    }

    public static String getProductPricePage(){
        WebElement nameSpace;
        nameSpace = driver.findElement(productDiscount);
        String value =  nameSpace.getAttribute("innerText");
        if(value.isEmpty()) {
            nameSpace = driver.findElement(productPricePage);
        }
        return nameSpace.getAttribute("innerText");
    }

}
