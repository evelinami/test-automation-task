import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegistrationValidationEmptyFieldsTestSuit {

    private final static WebDriver driver = new ChromeDriver();

    @BeforeClass
    public static void setUpClass() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }

    @Test
    public void testRegistrationMandatoryFields() throws InterruptedException {
        RegistrationPage page = new RegistrationPage(driver);
        page.goToPage();
        page.sendApplication();
        page.assertColorFirstLastName("rgba(191, 21, 21, 1)");
        page.assertColorEmail("rgba(191, 21, 21, 1)");
        page.assertColorPhone("rgba(191, 21, 21, 1)");
        page.assertColorPosition("rgba(191, 21, 21, 1)");
        page.assertColorConsentCheckboxField("rgba(191, 21, 21, 1)");
        page.assertValidationFailureMessage("Some sort of validation errors occurred. Please check the form fields and kindly attempt submitting it again - or email it directly to jobs@metasite.net.");

    }

}
