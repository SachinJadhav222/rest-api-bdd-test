package utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utils{

    public static String getProperties(String property)  {

        try{
            FileReader reader=new FileReader("src/main/resources/config.properties");
            Properties p=new Properties();
            p.load(reader);
            System.out.println(p.getProperty(property));
            property=p.getProperty(property);

        }
        catch(Exception err){
            System.out.println(err);
        }

        return property;

    }

}