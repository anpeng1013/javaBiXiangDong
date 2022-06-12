package day09.javaBean;

import java.io.Serializable;

/**
 * Serializable：用于给被序列化的类加入ID号
 * 用于判断类和对象是否是同一版本。
 * 强烈建议显示声明ID号,便于反序列化。
 *
 * 静态字段和瞬时字段不可被序列化。
 *
 */
public class Person implements Comparable, Serializable /*标记接口*/{

    private static final long serialVersionUID=9527;
    private /*transient 瞬时字段不可被序列化*/ String name;
    private /*static 静态字段不可被序列化 */ int age;

    public Person() {
    }


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age * 27;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Person))
            throw new ClassCastException("类型错误");
        Person person = (Person) obj;
        return this.name.equals(person.name) && this.age == person.age;
    }

    @Override
    public String toString() {
        return this.getClass().getName()+"@ "+this.name+"::"+this.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object object) {
        Person person = (Person) object;
        /*
        if(this.age> person.age)
            return 1;
        if(this.age<person.age)
            return -1;
        return this.name.compareTo(person.name);//如果年龄相同，则按姓名排序。
        */

        int temp = this.age - person.age;
        return temp == 0 ? this.name.compareTo(person.name) : temp;
    }
}

