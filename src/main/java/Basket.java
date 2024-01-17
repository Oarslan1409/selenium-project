
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Basket {
    private static WebDriver driver;
    private static final By addBasket =  By.cssSelector("button[id='add-to-basket']");
    private static final By productPriceBasket =  By.cssSelector("span[class='product-new-price']");
    private static final By productCount =  By.cssSelector("option[value='2']");
    private static final By deleteProduct =  By.cssSelector("a[title='Sil']");

    public Basket(WebDriver driver) {
        Basket.driver = driver;
    }

    public static void addBasket() {
        WebElement element = driver.findElement(addBasket);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static String getProductPriceBasket(){
        WebElement nameSpace = driver.findElement(productPriceBasket);
        return nameSpace.getAttribute("innerText");
    }

    public static void goBasket(){
        driver.get("https://www.gittigidiyor.com/sepetim");
        Log4j.info("Sepet sayfası açılmıştır.");
    }

    public static void increaseProduct(){
        final By checkLastProduct =  By.cssSelector("p[class='count-desc']");
        WebElement nameSpace = driver.findElement(checkLastProduct);
        String value =  nameSpace.getAttribute("value");
        if(value.isEmpty()) {
            WebElement element = driver.findElement(productCount);
            ((JavascriptExecutor)driver).executeScript("$(\".amount\").val('2');", element);
            Log4j.info("Ürün sayısı arttırılmıştır.");
       }
        else {
            Log4j.info("Son ürün olduğu için ürün sayısı arttırılamamıştır!");
        }
    }
    public static void productCount(){
        Select select = new Select(driver.findElement(By.xpath("//select")));
        WebElement option = select.getFirstSelectedOption();
        String defaultItem = option.getText();
        if(defaultItem.equals("2")){
            Log4j.info("Ürün sayısı istenilen değere eşittir. Ürün sayısı: " + defaultItem);
        }
        else {

            Log4j.info("Ürün sayısı istenilen değere eşit değildir!. Seçili ürün sayısı: " + defaultItem);
        }
    }

    public static void deleteProduct(){
        WebElement nameSpace = driver.findElement(deleteProduct);
        nameSpace.click();
        Log4j.info("Ürün sepetten silinmiştir.");
    }


}
