package Utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class PropertiesLoader {
    public static Properties properties;
    public static Properties readPropertyFile(String filePath){
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(filePath));
            properties = new Properties();
            try{
                properties.load(reader);
                reader.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return properties;
    }
    private static  String getPropertyValue(String key , File file){
        properties = new Properties();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            properties.load(bufferedReader);
        }catch (FileNotFoundException fileExc){
            fileExc.printStackTrace();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
    }
    public static String readEnvFile(String key){
        File file = new File("src/config/env.properties");
        return getPropertyValue(key,file);
    }
    public static String readBBranchFile(String key){
        File file = new File("src/config/branch.properties");
        return getPropertyValue(key,file);
    }
    public static String readManagerFile(String key){
        File file = new File("src/config/manager.properties");
        return getPropertyValue(key,file);
    }
    public static String readLeaderFile(String key){
        File file = new File("src/config/leader.properties");
        return getPropertyValue(key,file);
    }
    public static String readCashierFile(String key){
        File file = new File("src/config/cashier.properties");
        return getPropertyValue(key,file);
    }
    public static String readGroupFile(String key){
        File file = new File("src/config/group.properties");
        return getPropertyValue(key,file);
    }

    public static String readCategoryFile(String key){
        File file = new File("src/config/category.properties");
        return getPropertyValue(key,file);
    }
    public static String readProductFile(String key){
        File file = new File("src/config/product.properties");
        return getPropertyValue(key,file);
    }
    public static String readModifierFile(String key){
        File file = new File("src/config/modifier.properties");
        return getPropertyValue(key,file);
    }
    public static String readOptionFile(String key){
        File file = new File("src/config/option.properties");
        return getPropertyValue(key,file);
    }
    public static String readClientFile(String key){
        File file = new File("src/config/client.properties");
        return getPropertyValue(key,file);
    }

}
