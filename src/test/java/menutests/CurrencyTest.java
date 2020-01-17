package menutests;

import libs.ConfigProperties;
import libs.Utils;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Test;
import parenttest.ParentTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Utils.waitABit(2000);

        log.info("Opening currency selector");
        headerElement.clickOnCurrencySelector();
        Utils.waitABit(2000);

        log.info("Compare currencies list from UI and configured on backend");
        List<String> currenciesFromUI = headerElement.getCurrenciesFromSelector();
        checkExpectedResult("Currencies doesn't match!", currenciesFromUI.equals(configuredCurrencies));

        //if list from backend comes with currencies in random order
        //Set<String> configCurrencies = new HashSet<>(configuredCurrencies);
        //Set<String> uiCurrencies = new HashSet<>(currenciesFromUI);
        //checkExpectedResult("Currencies doesn't match!", uiCurrencies.equals(configCurrencies));
    }

    @Test
    public void currencySwitchTest() {

        mainPage.openMainPage();
        Utils.waitABit(2000);

        log.info("Moving to featured section and saving currency from price of featured product");
        mainPage.scrollToFeaturedProductsSection();
        String currentCurrency = mainPage.getCurrencyFromFeaturedProduct(0);
        Utils.waitABit(3000);

        log.info("Moving back to top and opening currency selector");
        headerElement.scrollToHeader();
        headerElement.clickOnCurrencySelector();
        Utils.waitABit(2000);

        log.info("Changing shop's processing currency");
        String newCurrency = mainPage.chooseNewCurrencyForTest(currentCurrency);
        headerElement.selectNewCurrency(newCurrency);

        log.info("Moving to featured section and checking that currency switched");
        mainPage.scrollToFeaturedProductsSection();
        String newSetCurrency = mainPage.getCurrencyFromFeaturedProduct(0);
        checkExpectedResult("Currency didn't switch!", newCurrency.equals(newSetCurrency));
        Utils.waitABit(3000);
    }
}
