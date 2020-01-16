package menutests;

import libs.ConfigProperties;
import libs.Utils;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Test;
import parenttest.ParentTest;

import java.util.ArrayList;
import java.util.List;

public class CurrencyTest extends ParentTest {

    private ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    @Test
    public void verifyCurrencyListTest() {

        log.info("Preparing test data - mocking backend response");
        List<String> configuredCurrencies = new ArrayList<>();
        configuredCurrencies.add(configProperties.CURRENCY_EURO());
        configuredCurrencies.add(configProperties.CURRENCY_GBP());
        configuredCurrencies.add(configProperties.CURRENCY_USD());

        mainPage.openMainPage();
        Utils.waitABit(3000);

        log.info("Opening currency selector");
        headerElement.clickOnCurrencySelector();
        Utils.waitABit(3000);

        log.info("Compare currencies list from UI and configured on backend");
        List<String> currenciesFromUI = headerElement.getCurrenciesFromSelector();
        checkExpectedResult("Currencies doesn't match!", currenciesFromUI.equals(configuredCurrencies));
    }

    @Test
    public void currencySwitchTest() {

    }
}
