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
        WebElement consentCheckbox = driver.findElement(By.cssSelector(".wpcf7-list-item > input:nth-child(1)"));
        consentCheckbox.click();
    }

    public void sendApplication() {
        WebElement buttonSend = driver.findElement(By.cssSelector(".wpcf7-submit"));
        buttonSend.submit();
    }

    public void assertSuccessMessage(String msg) {
            WebElement successMsg = driver.findElement(By.cssSelector("#wpcf7-f4257-p5033-o1 > form > div.wpcf7-response-output.wpcf7-display-none.wpcf7-spam-blocked"));
            Assert.assertEquals(msg, successMsg.getAttribute("innerText"));
        }

    public void assertColorFirstLastName(String color) { //first name
        WebElement firstLastNameField = driver.findElement(By.name("your-name"));
        Assert.assertEquals(color, firstLastNameField.getCssValue("border-top-color"));
    }

    public void assertColorEmail(String color) { //email
        WebElement emailField = driver.findElement(By.name("your-email"));
        Assert.assertEquals(color, emailField.getCssValue("border-top-color"));
    }

    public void assertColorPhone(String color) { //phone
        WebElement phoneField = driver.findElement(By.name("your-phone"));
        Assert.assertEquals(color, phoneField.getCssValue("border-top-color"));
    }

    public void assertColorPosition(String color) { //position
            WebElement positionDropdown = driver.findElement(By.name("menu-640"));
            Assert.assertEquals(color, positionDropdown.getCssValue("border-top-color"));
    }

    public void assertColorConsentCheckboxField(String color) {
        WebElement consentCheckboxField = driver.findElement(By.cssSelector("#wpcf7-f4257-p5033-o1 > form > p:nth-child(9) > span > span.wpcf7-form-control.wpcf7-checkbox.wpcf7-validates-as-required.wpcf7-not-valid"));
        Assert.assertEquals(color, consentCheckboxField.getCssValue("border-top-color"));
    }

    public void assertValidationFailureMessage(String msg) {
        WebElement errorMsg = driver.findElement(By.cssSelector(".wpcf7-response-output"));
        Assert.assertEquals(msg, errorMsg.getAttribute("innerText"));
    }
}