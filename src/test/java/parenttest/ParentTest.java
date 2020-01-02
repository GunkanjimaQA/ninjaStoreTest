package parenttest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pages.HeadPage;
import pages.NavigationMenuElement;
import pages.SignInPopUpElement;

import java.util.concurrent.TimeUnit;

public class ParentTest {

    protected WebDriver driver;
    protected HeadPage headPage;
    protected NavigationMenuElement navigationMenuElement;
    protected SignInPopUpElement signInPopUpElement;

    @Before
    public void setUp() throws Exception {
// How to quickly add exact driver stored within the project
//        File file = new File("./src/drivers/chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//        driver = new ChromeDriver();

        driver = driverInit();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        navigationMenuElement = new NavigationMenuElement(driver, "");
        headPage = new HeadPage(driver, "");
        signInPopUpElement = new SignInPopUpElement(driver, "");
    }

    private WebDriver driverInit() throws Exception {
        String browser = System.getProperty("browser");
        if ((browser == null) || ("chrome".equalsIgnoreCase(browser))) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if ("ie".equalsIgnoreCase(browser)) {
            WebDriverManager.iedriver().arch32().setup();
            return new InternetExplorerDriver();
        } else  {
            throw new Exception("Browser parameter is incorrect in config!");
        }
    }

    @After
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    protected  void checkExpectedResult(String message, boolean actualResult) {
        Assert.assertEquals(message, true, actualResult);
    };

    protected void expectElementNotPresent(String message, boolean actualResult) {
        Assert.assertEquals(message, false, actualResult);
    }
}
