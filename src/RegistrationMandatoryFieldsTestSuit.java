import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegistrationMandatoryFieldsTestSuit {

    private final static WebDriver driver = new ChromeDriver();

    @BeforeClass
    public static void setUpClass() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    //@AfterClass
    //public static void tearDownClass() {
    //    driver.quit();
    //}

    @Test
    public void testRegistrationMandatoryFields() throws InterruptedException {
        RegistrationPage page = new RegistrationPage(driver);
        page.goToPage();
        page.sendApplication();
        page.assertColorFirstLastName("rgba(191, 21, 21, 1)");
        page.assertMessage("Some sort of validation errors occurred. Please check the form fields and kindly attempt submitting it again - or email it directly to jobs@metasite.net.");

    }

}
