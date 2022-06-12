package day09;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/*
Vector向量中凡是带element的方法，都是Vector的特有方法。
 */
public class VectorDemo {
    public static void main(String[] args) {
        Vector v=new Vector();
        v.addElement("abc1");
        v.addElement("abc2");
        v.addElement("abc3");
        v.addElement("abc4");

        Enumeration enumeration=v.elements();
        while (enumeration.hasMoreElements()){
            System.out.println("enumeration = " + enumeration.nextElement());
        }
        //两者功能相同，一般采用迭代器。
        Iterator iterator=v.iterator();
        while (iterator.hasNext())
            System.out.println("iterator.next() = " + iterator.next());
    }
}
