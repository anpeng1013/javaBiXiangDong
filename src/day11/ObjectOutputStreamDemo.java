package day11;

import day09.javaBean.Person;

import java.io.*;

public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        writeObject();
        readObject();
    }

    private static void readObject() throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("person.object"));

        //对象的反序列化。
        Person person=(Person) ois.readObject();
        System.out.println(person.getName()+":"+person.getAge());
        ois.close();
    }

    private static void writeObject() throws IOException {

        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("person.object"));
        //对象序列化，将对象排队存储到硬盘上。
        //被序列化的对象必须实现Serializable接口
        oos.writeObject(new Person("anpeng",25));//在day09.javaBean.Person中，Person类必须实现Serializable接口。
        //且静态和瞬时字段不能被序列化。
        oos.close();
    }
}
