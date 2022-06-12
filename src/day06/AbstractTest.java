package day06;
/*
雇员示例:
需求：公司中程序员有姓名，工号，薪水，工作内容。
项目经理除了有姓名，工号，薪水，还有奖金，工作内容。
对给出的需求进行数据建模。

分析：
在这个问题领域中，先找出涉及的对象，通过名词提炼法。
程序员：
    属性：姓名，工号，薪水
    行为：工作。
经理：
    属性：姓名，工号，薪水，奖金
    行为：工作。

    程序员和经理不存在着直接继承关系，但是却有责共性内容。
    可以进行抽取，因为他们都是公司的雇员，可以将他们建立体系。
 */

//雇员
abstract class Employee {
    private String name;
    private String id;
    private double pay;

    Employee(String name, String id, double pay) {
        this.name = name;
        this.id = id;
        this.pay = pay;
    }

    public abstract void work();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }


}

//程序员
class Programmer extends Employee {
    Programmer(String name, String id, double pay) {
        super(name, id, pay);
    }

    public void work() {
        System.out.println("code...");
    }
}

//经理
class Manager extends Employee {
    private int bonus;

    Manager(String name, String id, double pay, int bonus) {
        super(name, id, pay);
        this.bonus = bonus;
    }

    public void work() {
        System.out.println("manage...");
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}

public class AbstractTest {
    public static void main(String[] args) {
        Programmer programmer = new Programmer("安鹏", "1013", 18000);
        Manager manager = new Manager("apple", "1115", 36000, 20000);
        System.out.println(programmer.getName() + " " + programmer.getId()
                + " " + programmer.getPay());
        System.out.println(manager.getName() + " " +manager.getId()+" "
                +manager.getPay()+" "+manager.getBonus());
    }
}
