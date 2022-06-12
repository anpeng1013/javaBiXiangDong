package day11;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeStreamDemo {
    public static void main(String[] args) throws IOException {
        PipedInputStream input=new PipedInputStream();
        PipedOutputStream output=new PipedOutputStream();
        input.connect(output);

        new Thread(new Input(input)).start();
        new Thread(new Output(output)).start();
    }
}

class Input implements Runnable {
    private PipedInputStream in;

    Input(PipedInputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[1024];
            int length=in.read(buffer);
            String s = new String(buffer,0,length);
            System.out.println("s = " + s);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Output implements Runnable {
    private PipedOutputStream out;

    Output(PipedOutputStream out) {
        this.out = out;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            out.write("hi，管道来了".getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}