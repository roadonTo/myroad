package IO流.配置文件properties;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Properties1 {

    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();

        properties.setProperty("name", "汤姆");
        properties.setProperty("age", "18");
        properties.setProperty("sex", "公");

        properties.store(new FileWriter("mysql.properties"), null);


    }
}
