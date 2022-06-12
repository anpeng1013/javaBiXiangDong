package day11;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileDemo_2 {
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        FileReader fileReader=null;
        FileWriter fileWriter=null;
        try {
            fileReader=new FileReader("demo.txt");
            fileWriter=new FileWriter("demo_3.txt");

            char[] buffer = new char[BUFFER_SIZE];
            int length=0;
            while ((length=fileReader.read(buffer))!=-1){
                fileWriter.write(buffer,0,length);
            }
        }catch (Exception e){
            throw new RuntimeException("读写失败");
        }finally {
            if (fileReader!=null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileReader!=null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
