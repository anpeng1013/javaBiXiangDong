package day11;

import java.io.*;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        /**
         * Map
         *  |--Hashtable
         *      |--Properties
         *
         *  Properties集合：
         *  特点:
         *  1、该集合中的键和值都是字符串类型。
         *  2、集合中的数据可以保存到流中，或从流中获取。
         *
         *  该集合通常用于操作以键值对形式存在的配置文件。
         */

        //演示Properties集合的存和取。
//        getStoreDemo();

        //演示Properties集合和流对象相结合的功能。
//        showStream();

        //演示将Properties属性集合存储到磁盘中
//        showStore();

        //演示读取配置信息
//        showGetInfo();

        //模拟load方法
//        myLoad();

        //演示修改配置信息
        showUpdateInfo();
    }

    private static void showUpdateInfo() throws IOException {
        /**
         * 对已有的配置文件中的信息进行修改
         * 思路：
         * 读取这个文件，并将这个文件中的键值对数据存储到集合中
         * 再通过集合对数据进行修改，之后再通过流将修改后的数据存储到文件中。
         */
        //读取配置文件
        File file=new File("properties.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        FileReader fileReader=new FileReader(file);

        //创建集合存储配置信息
        Properties properties=new Properties();

        //将流中信息存储到集合中
        properties.load(fileReader);
        properties.setProperty("anpeng","15");

        //将集合中的信息存储到文件中
        FileWriter fileWriter=new FileWriter(file);
        properties.store(fileWriter,"");

        //关闭流
        fileReader.close();
        fileWriter.close();

    }

    private static void myLoad() throws IOException {
        Properties properties=new Properties();
        BufferedReader bufferedReader=new BufferedReader(new FileReader("properties.txt"));
        String line=null;
        while ((line=bufferedReader.readLine())!=null){
            if(line.startsWith("#"))
                continue;
            String[] arr=line.split("=");
            properties.setProperty(arr[0],arr[1]);
        }
        properties.list(System.out);
        bufferedReader.close();
    }

    private static void showGetInfo() throws IOException {
        Properties properties=new Properties();
        //集合中的数据来自一个文件
        //注意：必须保证该文件中的数据是键值对。
        //需要使用到读取流。
        FileInputStream fileInputStream=new FileInputStream("properties.txt");

        //使用load方法
        properties.load(fileInputStream);
        //输出键值对数据。
        properties.list(System.out);
    }

    private static void showStore() throws IOException {
        //创建一个Properties集合。
        Properties properties=new Properties();
        //存储元素
        properties.setProperty("anpeng","25");
        properties.setProperty("huli","22");
        //想要将这些集合中的字符串键值信息持久化存储到文件中
        //需要关联输出流
        FileOutputStream fileOutputStream=new FileOutputStream("properties.txt");
        //将集合中数据存储到文件中，使用store方法。
        properties.store(fileOutputStream,"name+age");//注释中不能是中文
        fileOutputStream.close();
    }

    private static void showStream() {
        //创建一个Properties集合。
        Properties properties=new Properties();
        //存储元素
//        properties.setProperty("anpeng","25");
//        properties.setProperty("huli","22");

        properties=System.getProperties();
        properties.list(System.out);
    }

    private static void getStoreDemo() {
        //创建一个Properties集合。
        Properties properties=new Properties();
        //存储元素
        properties.setProperty("anpeng","25");
        properties.setProperty("huli","22");
        //修改元素
        properties.setProperty("anpeng","24");
        //取出所有元素。
        Set<String> names=properties.stringPropertyNames();
        for(String name:names){
            String value=properties.getProperty(name);
            System.out.println(name+":"+value);
        }
    }
}
