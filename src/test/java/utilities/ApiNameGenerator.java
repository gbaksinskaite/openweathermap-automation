package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class ApiNameGenerator {

	public static String perfom() {

		return "keyName".concat(RandomStringUtils.randomNumeric(5));

	}

}
