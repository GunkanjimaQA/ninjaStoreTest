package suites;

import footertests.ContactUsTest;
import footertests.GiftCertificateTest;
import menutests.CurrencyTest;
import menutests.GeneralMenuTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import shoppingcarttests.AddFeaturedProductTest;
import signintests.LoginNegativeParameterizedTest;
import signintests.LoginTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                GeneralMenuTest.class,
                LoginTest.class,
                LoginNegativeParameterizedTest.class,
                AddFeaturedProductTest.class,
                ContactUsTest.class,
                GiftCertificateTest.class,
                CurrencyTest.class
        }
)
public class FullSuite {
}
