package IO流.配置文件properties;

import java.io.*;
import java.util.Properties;

public class Properties2 {

    public static void main(String[] args) throws IOException {

        String path = "mysql.properties";
        //1. 加载配置文件
        Properties properties = new Properties();
        properties.load(new FileReader(path));
        //2. 列出来所有的键值对
        properties.list(System.out);
        //3. 根据键获取值
        String name = properties.getProperty("name");
        System.out.println("name的值为：" + name);
        //4. 修改值  设置的意思包含着 如果没有这个键就添加，如果有这个键就修改
        properties.setProperty("name","工藤新一");

        properties.store(new FileOutputStream(path),null);

    }
}
