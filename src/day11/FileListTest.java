package day11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取指定目录下，指定扩展名的文件（包含子目录中的）
 * 这些文件的的绝对路径写入到一个文本文件中
 *
 * 简单说，就是建立一个指定扩展名的文件列表
 *
 * 思路：
 * 1、必须进行深度遍历
 * 2、要在遍历过程中进行过滤，将符合条件的内容都存储到容器中，方便操作。
 * 3、对容器中的内容进行遍历，并将绝对路径写入到文件中。
 */
public class FileListTest {
    public static void main(String[] args) throws IOException {
        File dir=new File("E:\\ProgramProject\\Javaproject\\javaBiXiangDong");
        FilenameFilter filter=new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".class");
            }
        };
        List<File> list=new ArrayList<File>();

        getFiles(dir,filter,list);
        File destFile=new File(dir,"classFileList.txt");
        writeToFile(list,destFile);
    }
    public static void getFiles(File dir, FilenameFilter filter, List<File> list){
        File[] files=dir.listFiles();
        for(File file:files){
            if(file.isDirectory()){
                getFiles(file,filter,list);//递归
            }
            else{
                if(filter.accept(dir,file.getName())){
                    list.add(file);
                }
            }
        }
    }
    public static void writeToFile(List<File> list,File destFile)
    throws IOException{
        BufferedWriter bufferedWriter=null;
        try {
            bufferedWriter=new BufferedWriter(new FileWriter(destFile));
            for(File file:list){
                bufferedWriter.write(file.getAbsolutePath());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } finally {
            if(bufferedWriter!=null){
                try{
                    bufferedWriter.close();
                }catch (IOException e){
                    throw new RuntimeException("关闭失败");
                }
            }
        }
    }
}
