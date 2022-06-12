package day05;
    /*
    封装：是指隐藏对象的属性和实现细节，仅对外提供公共访问方式。
        好处：将变化隔离
              便于使用
              提高重用性
              提高安全性
        原则：将不需要对外提供的内容都隐藏起来。
               把属性都隐藏，提供公共方法对其访问。
     */

    /*
    private:私有，用于修饰成员。
            私有的成员只在本类中有效。私有是封装的一种体现。
     */

    /*
    构造函数：创建对象时调用的函数，
    作用:可以给对象初始化
         创建对象都必须要通过构造函数初始化。
         如果一个类中没有定义过构造函数，那么该类中会有一个默认的空参数构造函数，
         如果在类中定义了指定的空参数构造函数，那么该类中的默认构造函数就没有了。
    注意：1、构造函数没有返回值类型。
          2、构造函数可以调用成员方法，但是成员方法不可以调用构造函数

     一般函数和构造函数的区别：
     构造函数：对象创建时，就会调用与之对应的构造函数，给对象进行初始化
     一般函数：对象创建后，需要函数功能时才调用

     构造函数：对象创建时，会调用且只调用一次。调用时，构造函数会进栈。
     一般函数：对象创建后，可以被调用多次。

     定义构造函数的时机：
            在描述事物时，该事物一存在就具备的一些内容，这些内容都定义在构造函数中。

     构造函数的重载：
        构造函数名相同，参数列表不同。类型、个数、和顺序不同。
     */

public class Person {
    int age;
    String name;

    Person(){//构造函数,给对象初始化
        name="baby";
        age=1;
    }

    Person(String name){//构造函数重载
         /*
            this：代表当前对象，即调用该函数的对象，即this所在函数所属对象的引用。
                  当局部变量和成员变量重名时，可以用this.成员变量名区分。
            注意：1、在调用成员函数或者构造函数时，方法栈中的当前执行函数维持一个
                this引用，用来指向堆中调用该函数的对象。
                  2、this()语句只能写在构造函数第一行，因为初始化动作要先执行。
     */
        this.name=name;
    }

    Person(String name,int age){//构造函数重载
        this(name);//this的第二种使用方法。
        this.age=age;
    }

    public void setAge(int age){
        if(age<0 || age >130){
            System.out.println("年龄错误！");
        }
        else
            this.age=age;
    }

    public void setName(String name){
        this.name=name;
    }

    void speak(){
        if(age==0){
            System.out.println("my name is "+name);
        }
        else
            System.out.println("my name is "+name+" and "+age+" years old.");
    }

    public boolean compare(Person person){
      /*  if(this.age==person.age)//this的引用场景，指向调用该方法的对象。
            return true;
        else
            return false;*/
      return this.age==person.age;
    }
}
