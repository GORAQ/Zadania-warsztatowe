package stepDefinitions;

import FinalProject1.LoginPageTest;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MyStoreAddresses {

    LoginPageTest loginPageTest;
    WebDriver driver;

    @Given("^User is logged in to MyStore shop$")
    public void userIsLoggedInToMyStoreShop() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");

        LoginPageTest loginPageTest = new LoginPageTest(driver);
        loginPageTest.loginAs("kat.tut@mail.pl" , "Pass123");
        
    }

    @When("^User goes to YourAccountPage$")
    public void userGoesToYourAccountPage() {
        WebElement save1 = driver.findElement(By.xpath("//*[@id=\'_desktop_user_info\']/div/a[2]/span"));
        save1.click();
        
    }

    @And("^User goes to Addresses$")
    public void userGoesToAddresses() {
        WebElement save1 = driver.findElement(By.xpath("//*[@id=\'addresses-link\']/span"));
        save1.click();

    }


    @And("^User creates new address \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void userCreatesNewAddress(String arg0, String arg1, String arg2, String arg3, String arg4) {

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=address");

        WebElement Company = driver.findElement(By.name("company"));
        Company.clear();
        Company.sendKeys(arg0);


        WebElement Address = driver.findElement(By.name("address1"));
        Address.clear();
        Address.sendKeys(arg1);


        WebElement City = driver.findElement(By.name("city"));
        City.clear();
        City.sendKeys(arg2);

        WebElement Postcode = driver.findElement(By.name("postcode"));
        Postcode.clear();
        Postcode.sendKeys(arg3);


        WebElement roleSelectElement = driver.findElement(By.name("id_country"));
        Select roleSelect = new Select(roleSelectElement);
        roleSelect.selectByValue("17");

        WebElement Phone = driver.findElement(By.name("phone"));
        Phone.clear();
        Phone.sendKeys(arg4);


        WebElement save5 = driver.findElement(By.xpath("//*[@id=\'content\']/div/div/form/footer/button"));
        save5.click();

    }


    @Then("^User checks data of new created address$")
    public void userChecksDataOfNewCreatedAddress() {
        //pobiera adres ale raczej ta część jest do poprawy
        List<WebElement> address;
        WebElement TxtBoxContent = driver.findElement(By.className("address-body"));
        String getLastAddressText;

        String Txt = TxtBoxContent.getText();
        System.out.println(Txt);

    }

}
