import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.File;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        File file = new File("/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        this.driver = driver;
    }

    public void goToPage() {
        driver.get("https://www.metasite.net/careers/qa-engineer/");
    }

    public void insertFirstLastName(String name) {
        WebElement firstLastNameField = driver.findElement(By.name("your-name"));
        firstLastNameField.sendKeys(name);
    }

    public void insertEmail(String email) {
        WebElement emailField = driver.findElement(By.name("your-email"));
        emailField.sendKeys(email);
    }

    public void insertPhone(String phone) {
        WebElement phoneField = driver.findElement(By.name("your-phone"));
        phoneField.sendKeys(phone);
    }

    public void selectPosition(int index) {
        Select positionDropdown = new Select(driver.findElement(By.name("menu-640")));
        positionDropdown.selectByIndex(index);
    }

    public void insertLinkedinUrl(String linkedin) {
        WebElement linkedinUrl = driver.findElement(By.name("linkedin"));
        linkedinUrl.sendKeys(linkedin);
    }

    public void insertMessage(String message) {
        WebElement messageBox = driver.findElement(By.name("your-message"));
        messageBox.sendKeys(message);
    }

    public void clickOnConsentCheckbox() {
        WebElement consentCheckbox = driver.findElement(By.name("checkbox-consent[]"));
        consentCheckbox.click();
    }

    public void sendApplication() {
        WebElement buttonSend = driver.findElement(By.cssSelector(".wpcf7-submit"));
        buttonSend.submit();
    }
}