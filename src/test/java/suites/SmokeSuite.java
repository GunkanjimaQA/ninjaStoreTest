package suites;

import menutests.GeneralMenuTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import signintests.SignInTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                GeneralMenuTest.class,
                SignInTest.class
        }
)
public class SmokeSuite {
}
