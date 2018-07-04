import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegistrationTestSuit {
    private final static WebDriver driver = new ChromeDriver();

    @BeforeClass
    public static void setUpClass() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    //@AfterClass
    //public static void tearDownClass() {
    //    driver.quit();
    //}

    @Test
    public void testCalculator() throws InterruptedException {
        RegistrationPage page = new RegistrationPage(driver);
        page.goToPage();
        page.insertFirstLastName("Test name");
        page.insertEmail("test@test.com");
        page.insertPhone("123");
        page.selectPosition(1);
        page.insertLinkedinUrl("test");
        page.insertMessage("test message");
        page.clickOnConsentCheckbox();
        //page.sendApplication();
    }
}
