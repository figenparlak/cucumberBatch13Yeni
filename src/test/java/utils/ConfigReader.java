package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    //Java’da sistem bilgilerini Java’nın bize sunduğu anahtar kelimeler aracılığı ile alabiliriz.
    // Properties sınıfı, özellikler dosyasından veri almak
    // ve verileri özellikler dosyasında depolamak için yöntemler sağlar.
    // Ayrıca bir sistemin özelliklerini elde etmek için de kullanılabilir.
    //The Properties class provides methods to get data from the properties file
    // and store data into the properties file.
    // Moreover, it can be used to get the properties of a system.
    static Properties prop;

    public static Properties readProperties(String filePath){
        try {
            FileInputStream fis = new FileInputStream(filePath);
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static String getPropertyValue(String key){
        return prop.getProperty(key);
    }

}
