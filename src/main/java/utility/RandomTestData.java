package utility;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomTestData {

    public static String getFirstName(){
        String generatedString= RandomStringUtils.randomAlphabetic(2);
        return ("John"+generatedString);
    }
    public static String getLastName(){
        String generatedString= RandomStringUtils.randomAlphabetic(2);
        return ("Doe"+generatedString);
    }
    public static String getUserName(){
        String generatedString= RandomStringUtils.randomAlphabetic(3);
        return ("John"+generatedString);
    }
    public static String gePassword(){
        String generatedString= RandomStringUtils.randomAlphabetic(3);
        return (generatedString);
    }

    public static String geEmail(){
        String generatedString= RandomStringUtils.randomAlphabetic(3);
        return (generatedString+"gmail.com");
    }

}
