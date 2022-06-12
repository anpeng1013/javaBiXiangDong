package day11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        showBufferedReader();
    }

    private static void showBufferedReader() throws IOException {
        FileReader fileReader=new FileReader("demo_4.txt");

        BufferedReader bufferedReader=new BufferedReader(fileReader);

        String line=null;
        while((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        bufferedReader.close();
    }
}
