package libs;

import org.aeonbits.owner.Config;

public interface ConfigProperties extends Config {
	long TIME_FOR_DEFAULT_WAIT();
	long TIME_FOR_EXPLICIT_WAIT_LOW();
	long TIME_FOR_EXPLICIT_WAIT_HIGH();

	String base_url();
	String DATA_FILE();
	String DATA_FILE_PATH();

	String USER_LOGIN();
	String USER_PASSWORD();
	String WRONG_USER_LOGIN();
	String WRONG_USER_PASSWORD();
}
