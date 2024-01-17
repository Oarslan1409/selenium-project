
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestControl extends BaseTest{

    public static String email = "beyzagumus64@gmail.com";
    public static String password = "deneme123";
    public static String searchText = "bilgisayar";

    Boolean pass, mail = false;

    @Test
    @Order(1)
    public void setEmailTest() {
        practiceFormPage.setEmail(email);
        Assertions.assertEquals(email, PracticeFormPage.getEmail(), "Email geçerli değil!");
        mail = true;
    }

    @Test
    @Order(2)
    public void setPasswordTest() {
       practiceFormPage.setPassword(password);
       Assertions.assertEquals(password, PracticeFormPage.getPassword(), "Şifre geçerli değil!");
       pass = true;
    }

    @Test
    @Order(3)
    public void loginTest(){
        if (mail && pass){
            Log4j.info("Giriş yapılıyor.");
            PracticeFormPage.loginButton();
            Log4j.info("Giriş işlemi başarılı.");
            Log4j.info("Giriş yapılan mail: "+ email +", Şifre: "+ password);
        }
        else {
            Log4j.info("Giriş işlemi başarısız.");
        }
    }

    @Test
    @Order(4)
    public void searchTest(){
        Search.setSearchText(searchText);
        Assertions.assertEquals(searchText, Search.getSearchText(), "Geçersiz kelime girişi!");
        Log4j.info("Aranan değer: "+ searchText);
    }

    @Test
    @Order(5)
    public void searchButtonTest(){
        Search.searchButton();
        Log4j.info("Arama yapılıyor.");
    }

    @Test
    @Order(6)
    public void secondPageTest(){
        Log4j.info("İkinci sayfa açılıyor..");
        Search.secondPage();
    }

    @Test
    @Order(7)
    public void secondPageControlTest(){
        Log4j.info("İkinci sayfa kontrolü yapılıyor...");
        CheckControls.checkSecondPageOpen(driver);
    }

    @Test
    @Order(8)
    public void selectProductTest(){
        Log4j.info("Ürün seçiliyor...");
        Search.selectProduct();
    }

    @Test
    @Order(9)
    public void addBasketTest(){
        Basket.addBasket();
        Log4j.info("Ürün sepete eklenmiştir.");
    }

    @Test
    @Order(10)
    public void comparePriceTest(){
        Log4j.info("Fiyat karşılaştırması yapılıyor...");
        String pagePrice = Search.getProductPricePage();
        String basketPrice = Basket.getProductPriceBasket();
        if(basketPrice.equals(pagePrice)){
            Log4j.info("Fiyatlar aynıdır. Fiyat: " + pagePrice);
        }
        else {
            Log4j.info("Fiyatlar aynı değildir!. Sayfa fiyatı: "+ pagePrice +", Sepet fiyatı: "+ basketPrice);
        }
    }

    @Test
    @Order(11)
    public void goBasketTest(){
        Log4j.info("Sepete gidiliyor...");
        Basket.goBasket();
    }

    @Test
    @Order(12)
    public void increaseProductTest(){
        Log4j.info("Ürün sayısı arttırılıyor...");
        Basket.increaseProduct();
    }

    @Test
    @Order(13)
    public void productCountTest(){
        Log4j.info("Ürün sayısı kontrol ediliyor...");
        Basket.productCount();
    }

    @Test
    @Order(14)
    public void deleteProductTest(){
        Log4j.info("Ürün sepetten siliniyor...");
        Basket.deleteProduct();
    }

    @Test
    @Order(15)
    public void checkBasketTest(){
        Log4j.info("Sepet kontrol ediliyor...");
        CheckControls.checkBasket(driver);
    }
}
