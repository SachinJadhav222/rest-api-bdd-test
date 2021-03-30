package utility;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;

import org.junit.Test;

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

    public static String getEmail(){
        String generatedString= RandomStringUtils.randomAlphabetic(3);
        return (generatedString+"gmail.com");
    }

    public static String  getJSONPayload(){
        JSONObject json=new JSONObject();
        json.put("name",getFirstName());
        json.put("username",getUserName());
        json.put("email",getEmail());

        return json.toString();
    }

}
