package utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utils{

    public static String getProperties(String property)  {

        try{
            FileReader reader=new FileReader("src/test/resources/config.properties");
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

    public static String getSchemaFilePath(String BASE_PATH){
        String jsonSchemaFilePath=null;
        if(BASE_PATH.equalsIgnoreCase("/users")){
            jsonSchemaFilePath="src/test/resources/json-schema/users-schema.json";
        }else if(BASE_PATH.equalsIgnoreCase("./posts")){
            jsonSchemaFilePath="src/test/resources/json-schema/post-schema.json";
        }else{
            jsonSchemaFilePath="src/test/resources/json-schema/comments-schema.json";
        }
        return jsonSchemaFilePath;

    }

}