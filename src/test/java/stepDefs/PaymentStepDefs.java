package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class PaymentStepDefs {
    private ChromeDriver driver;

    @Given("berada di halaman produk")
    public void berada_di_halaman_produk() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\sqa\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        String baseURL = "https://demo.guru99.com/payment-gateway/index.php";
        driver.get(baseURL);
        driver.manage().window().maximize();
    }

    @When("pilih quantity tertentu")
    public void pilih_quantity_tertentu() {
        Select quantity = new Select(driver.findElement(By.xpath("//select[@name='quantity']")));
        quantity.selectByValue("5");
    }

    @When("menekan tombol buy now")
    public void menekan_tombol_buy_now() {
        WebElement buyNow = driver.findElement(By.xpath("//input[@value='Buy Now']"));
        buyNow.click();
    }

    @When("berada di halaman payment process")
    public void berada_di_halaman_payment_process() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @When("isi card number {string}")
    public void isi_card_number(String string) {
        WebElement cardNumber = driver.findElement(By.xpath("//input[@id='card_nmuber']"));
        cardNumber.sendKeys(string);
    }

    @When("pilih expiration month")
    public void pilih_expiration_month() {
        Select expireMonth = new Select(driver.findElement(By.xpath("//select[@id='month']"))) ;
        expireMonth.selectByValue("11");
    }

    @When("pilih expiration year")
    public void pilih_expiration_year() {
        Select expireYear = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        expireYear.selectByValue("2022");

    }

    @When("isi CVV code {string}")
    public void isi_CVV_code(String string) {
        WebElement cvvCode = driver.findElement(By.xpath("//input[@id='cvv_code']"));
        cvvCode.sendKeys(string);
    }

    @When("menekan tombol pay")
    public void menekan_tombol_pay() {
        WebElement submit = driver.findElement(By.xpath("//input[@name='submit']"));
        submit.click();
    }

    @Then("dapat order id")
    public void dapat_order_id() {
        WebElement succes = driver.findElement(By.cssSelector("div[class='table-wrapper'] h2"));
        String expect = "Payment successfull!";
        assertEquals(succes.getText(), expect);
        driver.close();
    }

}
