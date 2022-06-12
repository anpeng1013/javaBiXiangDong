package day11;

public class DecorationDemo {
    /*
        装饰设计模式：
            对一组对象的功能进行增强时，就可以使用该模式进行问题解决。
            特点：装饰类和被装饰类都必须所属同一个接口或者父类。

        装饰和继承都能实现一样的特点：进行功能的扩展增强。但是装饰比继承灵活。

     */
    public static void main(String[] args) {
        Person person=new Person();
        person.eat();

        //装饰
        NewPerson person1=new NewPerson(person);
        person1.eat();

        //继承
        NewPerson_2 person2=new NewPerson_2();
        person2.eat();
    }
}

class Person{
    void eat(){
        System.out.println("eating...");
    }
}

//装饰设计模式
class NewPerson{
    //这个类的出现是为了增强Person而出现的
    private Person person;
    NewPerson(Person person){
        this.person=person;
    }

    public void eat(){
        System.out.println("开胃酒");
        person.eat();
        System.out.println("甜点");
    }
}

//继承扩展模式
class NewPerson_2 extends Person{
    void eat(){
        System.out.println("开胃酒");
        super.eat();
        System.out.println("甜点");
    }
}
