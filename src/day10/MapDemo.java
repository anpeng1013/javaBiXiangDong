package day10;

import java.util.*;

/*
Map：一次添加一对元素，Collection一次添加一个元素。
    Map也称为双列集合，Collection集合也称为单列集合。
    其实Map集合中存储的就是键值对，必须保证键值的唯一性，且键的映射值也是唯一的。

常用方法：
1、添加：
    value put(key,value):返回前一个和key关联的值，如果没有则返回null。
2、删除：
    void clear():清空map集合
    value remove():根据指定的key删除这个键值对。
3、判断：
    boolean containsKey(key);
    boolean containsValue(value);
    boolean isEmpty();
4、获取：
    value get(key);通过键获取值，如果没有该键则返回null。
                    当然可以通过返回null，来判断是否包含指定键。
    int size();获取键值对个数。

5、键集合：
    Set keySet();返回该集合全部的键所在的集合。
6、值集合：
    Collection values();返回该集合所有值的集合。
7、映射关系集合。
    Set entrySet();返回该集合所有映射关系的集合。

---------------------------------------------------------------------------------------------------
Map的常用子类：
    |--Hashtable: 内部结构是哈希表，是同步的，不允许null作为键或者值，是一个遗留类，基本不用了。
        |--Properties:用来存储键值对型的配置文件信息，可以和IO技术结合。
    |--HashMap: 内部结构是哈希表，不是同步的。运行null作为键或者值。
    |--TreeMap: 内部结构是二叉树，不是同步的，可以对Map集合中的键进行排序。
 */
public class MapDemo {
    public static void main(String[] args) {
        //演示Map接口中的四种常用方法。
        //showMapFunction();

        //演示通过Map接口中的keySet方法，间接遍历获取所有的value。
        //showKeySet();

        //演示通过Map接口中的values方法，直接获取所有的value。
        showValues();

        //演示通过Map接口中的entrySet方法，遍历获取映射关系key+value。
        //showEntrySet();
    }

    private static void showEntrySet() {
        Map<Integer, String> map = new HashMap<Integer, String>();//学号和姓名
        map.put(1,"anpeng");
        map.put(3,"huli ");
        map.put(5,"love");
        map.put(7,"baby");

        /*
        通过Map转换成Set集合就可以迭代。
        利用entrySet方法，将键和值的映射关系作为对象存储到了Set集合中，
        而这个映射关系的类型就是Map.Entry类型。Entry是Map接口的内部接口。
         */

        Set<Map.Entry<Integer,String>> entrySet=map.entrySet();
        Iterator<Map.Entry<Integer,String>> entryIterator=entrySet.iterator();
        while(entryIterator.hasNext()){
            Map.Entry<Integer,String> me=entryIterator.next();
            Integer key=me.getKey();
            String value=me.getValue();
            System.out.println("key = " + key+", value="+value);
        }
    }

    private static void showValues() {
        Map<Integer, String> map = new HashMap<Integer, String>();//学号和姓名
        map.put(1,"anpeng");
        map.put(3,"huli ");
        map.put(5,"love");
        map.put(7,"baby");
        map.put(9,"love");

        Collection<String> values=map.values();
        Iterator<String>  stringIterator=values.iterator();
        while (stringIterator.hasNext()){
            System.out.println(stringIterator.next());
        }
    }

    private static void showKeySet() {
        Map<Integer, String> map = new HashMap<Integer, String>();//学号和姓名
        map.put(1,"anpeng");
        map.put(3,"huli ");
        map.put(5,"love");
        map.put(7,"baby");

        //取出map中的所有元素。
        //原理，通过keySet方法获取map中全部键所在的Set集合，通过Set的迭代器，
        //获取到每一个key，再对每一个键获取其对应的value即可。

        Set<Integer> keySet=map.keySet();
        Iterator<Integer> integerIterator=keySet.iterator();
        while (integerIterator.hasNext()){
            Integer key=integerIterator.next();
            String value=map.get(key);
            System.out.println(key+"::"+value);
        }
    }

    private static void showMapFunction() {
        Map<Integer, String> map = new HashMap<Integer, String>();//学号和姓名
        //添加元素
        System.out.println(map.put(8, "anpeng"));//返回的是，之前关联的value ，
        // key 8,之前没有关联value，所以返回为null,
        System.out.println(map.put(8, "huli"));//返回的是，之前关联的value 为anpeng
        //存相同的键，值会被覆盖。所以修改元素可以通过再次添加实现。

        System.out.println(map.put(1, "zhangsan"));//key 1,之前没有关联value，所以返回为null
        System.out.println(map.put(2, "lisi"));//key 2,之前没有关联value，所以返回为null
        System.out.println("map=" + map);

        //删除元素
        System.out.println("remove:" +map.remove(2));//返回的是与该键关联的value。
        System.out.println("map = " + map);

        //判断元素。
        System.out.println("containsKey:"+map.containsKey(8));//返回Boolean值。

        //获取元素
        System.out.println("get:"+map.get(2));
    }
}
