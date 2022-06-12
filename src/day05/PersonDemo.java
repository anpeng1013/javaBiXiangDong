package day05;

public class PersonDemo {
    public static void main(String[] args) {
        Person person=new Person();//构造函数：创建对象时调用的函数。
//        person.setAge(24);
//        person.setName("anpeng");
        person.speak();

        Person person1=new Person("张三");
        person1.speak();

        Person person2=new Person("李四",12);
        person2.speak();
    }
}
