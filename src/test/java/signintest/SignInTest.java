package signintest;

import libs.Utils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parenttest.ParentTest;

public class SignInTest extends ParentTest {

    @Test
    public void successfulSignIn() {
        headPage.openHeadPage();
        Utils.waitABit(3000);
        headPage.clickLogInOutButton();
        Utils.waitABit(6000);

        //driver.switchTo().alert();
        //driver.switchTo().window("content ng-scope");
        //driver.findElement(By.xpath(".//section[@class='main']//div[@class='field field-username-email']//span[@class='input-wrapper']/input[@class='ng-pristine ng-invalid ng-invalid-required ng-valid-pattern ng-touched']")).sendKeys("denis_3000@meta.ua");
        //driver.findElement(By.xpath(".//*[@id='did-ui-view']/div/section/section/form/section/div[1]/div/label/span[2]/input']")).sendKeys("denis_3000@meta.ua");

        //Assert.assertEquals(true, signInPopUpElement.isSignInLOgoDisplayed());

        signInPopUpElement.fillInUserLogin("denis_3000@meta.ua");
        signInPopUpElement.fillInUserPassword("hannah123");
        signInPopUpElement.clickOnSignInButton();
    }
}
