package day07;

/*
线程间通信：
    多个线程在处理同一资源，但是任务却不同。

等待/唤醒机制。
    涉及的方法：
    1、wait()：让线程处于阻塞状态，被wait的线程会被存储到
        线程池（理解为装线程的容器）中。
    2、notify()：随机唤醒线程池中的一个线程（任意的线程）。
        没有方法去唤醒一个指定的线程。
    3、notifyAll()：唤醒线程池中的所有阻塞线程。
    这些方法都必须定义在同步中，因为这些方法是用于操作线程状态的方法，
        若不是在同步代码块（即没有加锁）中，会抛出IllegalMonitorStateException。
    必须要明确其操作的是哪个锁上的线程。注意：必须要用该锁（对象）来调用这些方法。

思考：
  wait()，notify()，notifyAll()，用来操作线程的方法为什么定义在Object类中？
    1、这些方法用于线程同步中,是监视器的方法。监视器其实就是锁。
    2、使用这些方法时必须要标识所属的同步的锁。
    3、同步锁可以时任意的对象，所以任意对象都可以调用的方法必须定义在Object根类中。

  wait()，sleep()有什么区别？
    1、wait()：释放正在执行的CPU资源，释放同步锁，必须定义在同步中。
        sleep()：释放正在执行的CPU资源，不释放锁，不必定义在同步中。
    2、wait可以指定等待时间，也可以不指定
        sleep必须指定时间。
 */


//资源,以下代码可以优化，资源中提供设置属性的同步方法。
class Resource {
    private String name;
    private String sex;
    private boolean flag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

//输入
class Input implements Runnable {
    Resource resource;

    public Input(Resource resource) {
        this.resource = resource;
    }

    public void run() {
        int x = 0;
        while (true) {
            synchronized (resource) {
                if (resource.isFlag()) {
                    try {
                        resource.wait();
                    } catch (InterruptedException e) {
                    }
                }
                if (x == 0) {
                    resource.setName("安鹏");
                    resource.setSex("男");
                } else {
                    resource.setName("huli");
                    resource.setSex("girl");
                }
                resource.setFlag(true);
                resource.notify();
            }
            x = (x + 1) % 2;
        }
    }
}

//输出
class Output implements Runnable {
    Resource resource;

    public Output(Resource resource) {
        this.resource = resource;
    }

    public void run() {
        while (true) {
            synchronized (resource) {
                if (!resource.isFlag()) {
                    try {
                        resource.wait();
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println(resource.getName() + "..." + resource.getSex());
                resource.setFlag(false);
                resource.notify();
            }
        }
    }
}

public class InterThreadCommunicationDemo {
    public static void main(String[] args) {
        //创建资源
        Resource resource = new Resource();
        //创建任务
        Input input = new Input(resource);
        Output output = new Output(resource);
        //创建线程
        Thread thread1 = new Thread(input);
        Thread thread2 = new Thread(output);
        //开启线程
        thread1.start();
        thread2.start();
    }
}
