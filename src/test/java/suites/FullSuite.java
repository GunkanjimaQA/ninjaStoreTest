package suites;

import footertests.ContactUsTest;
import menutests.GeneralMenuTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import shoppingcarttests.AddFeaturedProduct;
import signintests.SignInParameterized;
import signintests.SignInTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                GeneralMenuTest.class,
                SignInTest.class,
                SignInParameterized.class,
                AddFeaturedProduct.class,
                ContactUsTest.class
        }
)
public class FullSuite {
}
