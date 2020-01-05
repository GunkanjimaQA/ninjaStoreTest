package suites;

import menutests.GeneralMenuTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import signintest.SignInParameterized;
import signintest.SignInTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                GeneralMenuTest.class,
                SignInTest.class,
                SignInParameterized.class
        }
)
public class FullSuite {
}
