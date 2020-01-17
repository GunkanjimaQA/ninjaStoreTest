package suites;

import footertests.ContactUsTest;
import menutests.CurrencyTest;
import menutests.GeneralMenuTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import shoppingcarttests.AddFeaturedProduct;
import signintests.LoginNegativeParameterizedTest;
import signintests.LoginTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                GeneralMenuTest.class,
                LoginTest.class,
                LoginNegativeParameterizedTest.class,
                AddFeaturedProduct.class,
                ContactUsTest.class,
                CurrencyTest.class
        }
)
public class FullSuite {
}
