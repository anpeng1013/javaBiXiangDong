package day11;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

/*
File对象的常用方法。
1、获取
    1.1获取文件名称
    1.2获取文件路径
    1.3获取文件大小
    1.4获取文件修改时间
    ....
2、创建与删除
    boolean creatNewFile();在磁盘中创建物理文件、
    boolean mkdir();创建单级目录
    boolean mkdirs();创建多级目录。
    boolean delete();删除文件或者目录。4

3、判断

 */
public class FileFunctionDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
//        getDemo();
//        creatDeleteDemo();//只能删除空目录
        deleteDirDemo();//可以删除带内容的目录
//        mkdirDemo();
//        judgeDemo();
//        renameToDemo();
//        listRootsDemo();
//        fileListDemo();//只能列出当前目录下的内容
//        fileNameFilter();//按照过滤器列出当前目录下的内容
//        listAllDemo();//能列出当前目录及子目录下的所有内容。（深度遍历）

    }

    private static void deleteDirDemo() throws IOException, InterruptedException {
        /**
         * 删除带内容的目录
         * 原理：必须从最里面往外删。
         * 需要进行深度遍历
         */
        File dir = new File("dir\\a\\b");
        dir.mkdirs();
        File file = new File(dir, "delete.txt");
        file.createNewFile();
        File directory=new File("dir");

        Thread.sleep(5000);
        removeDir(directory);
    }

    private static void removeDir(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if(file.isDirectory()){
                removeDir(file);
            }
            else{
                System.out.println(file.getName() +":"+ file.delete());
            }
        }
        System.out.println(dir.getName()+":"+dir.delete());
    }

    private static void listAllDemo() {
        File dir = new File("E:\\ProgramProject\\Javaproject\\javaBiXiangDong\\");
//        listAll(dir);//列出的所有内容杂乱，没有形成目录树
        listAll(dir, 0);
    }

    private static void listAll(File dir, int level) {
        System.out.println(getSpace(level) + dir.getName());
        level++;
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                listAll(files[i], level);
            } else {
                System.out.println(getSpace(level) + files[i].getName());
            }

        }
    }

    private static String getSpace(int level) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|--");
        for (int i = 0; i < level; i++) {
            stringBuilder.insert(0, "  ");
        }
        return stringBuilder.toString();
    }

    private static void listAll(File dir) {
        System.out.println("dir:" + dir.getAbsolutePath());
        //获取指定目录下当前所有文件夹或者文件对象
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                listAll(files[i]);//自己调用自己，即递归。
            } else
                System.out.println("file: " + files[i].getAbsolutePath());
        }
    }

    private static void fileNameFilter() {
        File dir = new File("E:\\ProgramProject\\Javaproject\\javaBiXiangDong\\");

        String[] names = dir.list(new MyFilter());
        for (String name : names) {
            System.out.println(name);
        }
    }

    private static void fileListDemo() {
        File file = new File("c:\\");//封装的只能是目录，不能是文件。
        String[] names = file.list();
        /*
        获取当前目录下的文件以及文件夹的名称，包含隐藏文件。
        调用list方法的File对象中封装的必须是目录。
        否则会发生NullPointerException
        如果访问的是系统级目录也会发生空指针异常。

        如果目录存在但是没有内容，会返回一个数组，但是长度为0；
         */
        for (String name : names) {
            System.out.println(name);
        }
    }

    private static void listRootsDemo() {
        File[] files = File.listRoots();
        /*
        获取系统根目录
         */
        for (File file : files) {
            System.out.println(file);
        }

        File file = new File("D:\\");
        System.out.println("file.getFreeSpace= " + file.getFreeSpace());
        System.out.println("file.getTotalSpace = " + file.getTotalSpace());
        System.out.println("file.getUsableSpace = " + file.getUsableSpace());
    }

    private static void renameToDemo() {
        //renameTo()方法重名名
        File file = new File("Demo_1.txt");
        File file1 = new File("demo_11.txt");
        boolean b = file.renameTo(file1);//不能同名。
        System.out.println("b = " + b);
    }

    private static void judgeDemo() {
        File file = new File("Demo.txt");
        boolean b = file.exists();
        System.out.println("b = " + b);
    }

    private static void mkdirDemo() throws InterruptedException {
        File file = new File("mate");//若没有文件后缀名，默认创建的是一个文件夹
        File file1 = new File("a\\b\\c");
        System.out.println("mkdir: " + file.mkdir());//创建单级目录
        System.out.println("mkdirs: " + file1.mkdirs());
        ;//创建多级目录

        Thread.sleep(5000);//五秒后删除单级目录，多级目录只能手动删除。

        System.out.println("delete dir: " + file.delete());//只有当目录为空时，才能删除
        System.out.println("delete dirs: " + file1.delete());//只能删除最里层的空目录。
    }

    private static void creatDeleteDemo() throws IOException, InterruptedException {
        File file = new File("creatDelete.txt");
        //创建文件
        /**
         * 和输出流不一样，如果文件不存在，则创建，否则不创建。
         */
        boolean b = file.createNewFile();
        System.out.println("b = " + b);

        Thread.sleep(5000);//五秒后删除文件
        //删除文件
        boolean b1 = file.delete();
        System.out.println("b1 = " + b1);
    }

    private static void getDemo() {
        File file = new File("a.txt");//有后缀名，创建的是具体类型文件。
        String parent = file.getParent();//使用相对路径关联文件时，获取不到父文件
        String name = file.getName();
        String absolutePath = file.getAbsolutePath();
        String path = file.getPath();
        long length = file.length();

        long time = file.lastModified();
        Date date = new Date(time);
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String str_time = dateFormat.format(date);

        System.out.println("parent = " + parent);
        System.out.println("name = " + name);
        System.out.println("absolutePath = " + absolutePath);
        System.out.println("path = " + path);
        System.out.println("length = " + length);
        System.out.println("time = " + time);
        System.out.println("str_time = " + str_time);
    }
}

class MyFilter implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {

        return name.endsWith(".txt");
    }
}
