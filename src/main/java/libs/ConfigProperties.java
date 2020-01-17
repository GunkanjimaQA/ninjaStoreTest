package libs;

import org.aeonbits.owner.Config;

public interface ConfigProperties extends Config {
	long TIME_FOR_DEFAULT_WAIT();
	long TIME_FOR_EXPLICIT_WAIT_LOW();
	long TIME_FOR_EXPLICIT_WAIT_HIGH();

	//Base data
	String base_url();
	String DATA_FILE();
	String DATA_FILE_PATH();

	//Credentials
	String USER_LOGIN();
	String USER_PASSWORD();
	String WRONG_USER_LOGIN();
	String WRONG_USER_PASSWORD();

	//Currencies
	String CURRENCY_EURO();
	String CURRENCY_GBP();
	String CURRENCY_USD();

	//Localized strings
	String CART_PAGE_EMPTY_TITLE();
	String CART_PAGE_GIFT_CERTIFICATE_TITLE();
	String ACCOUNT_MY_TITLE();
}
