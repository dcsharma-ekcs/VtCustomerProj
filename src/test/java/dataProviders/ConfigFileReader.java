package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
   // String projectPath = System.getProperty("user.dir");
    private final String propertyFilePath = "configs/$(server.int).properties";


    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getBrowserName() {
        String driverPath = properties.getProperty("browser");
        if (driverPath != null) return driverPath;
        else throw new RuntimeException("browser not specified in the Configuration.properties file.");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public long getFluentWait() {
        String implicitlyWait = properties.getProperty("fluentWait");
        if (implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("fluentWait not specified in the Configuration.properties file.");
    }

    //

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getUserName() {
        String url = properties.getProperty("userName");
        if (url != null) return url;
        else throw new RuntimeException("userName not specified in the Configuration.properties file.");
    }

    public String getUserPassword() {
        String url = properties.getProperty("userPassword");
        if (url != null) return url;
        else throw new RuntimeException("userPassword not specified in the Configuration.properties file.");
    }

    public String getUserWrongPassword() {
        String url = properties.getProperty("userWrongPassword");
        if (url != null) return url;
        else throw new RuntimeException("userWrongPassword not specified in the Configuration.properties file.");
    }

    public String getShopifyStoreUrl() {
        String url = properties.getProperty("shopifyStoreUrl");
        if (url != null) return url;
        else throw new RuntimeException("shopifyStoreUrl not specified in the Configuration.properties file.");
    }

    public String getShopifyStorePassword() {
        String url = properties.getProperty("shopifyStorePassword");
        if (url != null) return url;
        else throw new RuntimeException("shopifyStorePassword not specified in the Configuration.properties file.");
    }

    public String getShopifyStoreName() {
        String url = properties.getProperty("shopifyStoreName");
        if (url != null) return url;
        else throw new RuntimeException("shopifyStoreName not specified in the Configuration.properties file.");
    }

    public String getShopifyPartnersUrl() {
        String url = properties.getProperty("shopifyPartnersUrl");
        if (url != null) return url;
        else throw new RuntimeException("shopifyPartnersUrl not specified in the Configuration.properties file.");
    }

    public String getShopifyPartnersUserName() {
        String url = properties.getProperty("shopifyPartnersUserName");
        if (url != null) return url;
        else throw new RuntimeException("shopifyPartnersUserName not specified in the Configuration.properties file.");
    }

    public String getShopifyPartnersPassword() {
        String url = properties.getProperty("shopifyPartnersPassword");
        if (url != null) return url;
        else throw new RuntimeException("shopifyPartnersPassword not specified in the Configuration.properties file.");
    }

    public String getVestaShopifyPluginApp() {
        String url = properties.getProperty("vestaShopifyPluginApp");
        if (url != null) return url;
        else throw new RuntimeException("vestaShopifyPluginApp not specified in the Configuration.properties file.");
    }

}