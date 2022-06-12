package day10;

import day09.ComparatorByNameDemo;
import day09.javaBean.Student;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args){
        showTreeMap();
    }
    private static void showTreeMap() {

        TreeMap<Student,String> treeMap=new TreeMap<Student,String>(new ComparatorByNameDemo()); //以名字来排序。

        treeMap.put(new Student("anpeng",24),"北京");
        treeMap.put(new Student("huli",22),"北京");
        treeMap.put(new Student("xiechao",24),"上海");
        /*
        Student类继承了Person类中复写的HashCode 和equals方法。即姓名和年龄相同的两个学生
        是同一个学生对象key，下面再次添加相同的key,(new Student("xiechao",24))时,
        该key已经存在，故会修改values的值，即写入新的映射关系。
         */
        treeMap.put(new Student("xiechao",24),"铜仁");

//        Set<Student> keySet=hashMap.keySet();
//        Iterator<Student> iterator =keySet.iterator();
        //上面两句代码的缩写。
        Iterator<Map.Entry<Student,String>> iterator=treeMap.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<Student,String> me=iterator.next();
            Student key= me.getKey();
            String value=me.getValue();
            System.out.println("key = " + key.getName()+":"+key.getAge()+"   value = "+value);
        }
    }
}
