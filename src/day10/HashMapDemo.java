package day10;

import day09.javaBean.Student;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * 将学生对象和学生的归属地，通过键值对的形式存储到Map集合中。
 */
public class HashMapDemo {
    public static void main(String[] args) {
        showHashMap();
    }

    private static void showHashMap() {
        HashMap<Student,String> hashMap=new HashMap<Student,String>();
        hashMap.put(new Student("anpeng",24),"北京");
        hashMap.put(new Student("huli",22),"北京");
        hashMap.put(new Student("xiechao",24),"上海");
        /*
        Student类继承了Person类中复写的HashCode 和equals方法。即姓名和年龄相同的两个学生
        是同一个学生对象key，下面再次添加相同的key,(new Student("xiechao",24))时,
        该key已经存在，故会修改values的值，即写入新的映射关系。
         */
        hashMap.put(new Student("xiechao",24),"铜仁");

//        Set<Student> keySet=hashMap.keySet();
//        Iterator<Student> iterator =keySet.iterator();
        //上面两句代码的缩写。
        Iterator<Student> iterator=hashMap.keySet().iterator();

        while (iterator.hasNext()){
            Student key= iterator.next();
            String value=hashMap.get(key);
            System.out.println("key = " + key.getName()+":"+key.getAge()+"   value = "+value);
        }
    }
}
