package day11;

import java.io.*;

public class TransStreamDemo {
    //需求：将键盘键入的字母转换成大写，打印在控制台上。
    public static void main(String[] args) throws IOException {
        showTransStream_1();
        //showTransStream_2();
    }

    private static void showTransStream_1() throws IOException {
        InputStream inputStream=System.in;//字节流
        InputStreamReader inputStreamReader=new InputStreamReader(inputStream);//流的转换
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);//字符流
        String line=null;
        while ((line=bufferedReader.readLine())!=null){
            if("over".equals(line))
                break;
            System.out.println(line.toUpperCase());
        }
    }

    private static void showTransStream_2() throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(System.out));

        String line=null;
        while((line=bufferedReader.readLine())!=null){
            if("over".equals(line))
                break;
            bufferedWriter.write(line.toUpperCase());
            bufferedWriter.newLine();//换行
            bufferedWriter.flush();//刷新。
        }
    }
}
