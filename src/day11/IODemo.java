package day11;

public class IODemo {
    public static void main(String[] args) {
        /*

        按IO方向可以分为：输入流和输出流。
            输入流：将外设（硬盘，U盘..)中的数据读取到内存中
            输出流：将内存中的数据写入到外设（硬盘，U盘，打印机）中

        按IO内容可以分为：字节流和字符流
            字节流：将待处理的二进制数据（计算机中的数据都是二进制的）逐一地按照单个字节进行操作处理。
            字符流：在处理二进制数据文件之前，先查指定的编码表，比如Unicode编码表中一个字符由
                    两个字节组成，而ASCII编码表中一个字符由一个字节组成。查完编码表，获取对应的
                    文字字符，再对这个文字字符进行操作处理。

        IO流的常用基类
            字节流的抽象基类：InputStream   OutputStream
                理解：字节流按照单个字节进行处理，不需要查表，直接Input(输入)和Output(输出)
            字符流的抽象基类：Reader      Writer
                理解：字符流需要查表，读取相应的文字字符，所以需要Reader(读)和Writer(写)
            注意：由这四个类派生的子类名称都是以其父类名作为子类名的后缀。
                如：InputStream中的子类： FileInputStream  BufferedInputStream
                    OutputStream中的子类： FileOutputStream  BufferedOutputStream
                    Reader中的子类：FileReader  BufferedReader
                    Writer中的子类：FileWriter  BufferedWriter

-------------------------------------------------------------------------------------------------------------
转换流：
    InputStreamReader：字节到字符的桥梁。解码：从磁盘中读出来，输入到内存中。
    OutputStreamWriter：字符到字节的桥梁。编码：从内存中输出，写入到磁盘中。
转换流的使用时机：
    1、源或者目的对应的设备是字节流，但操作的却是文本数据，可以使用转换流作为桥梁。
    提高对文本数据操作的便捷。
    2、一旦操作文本涉及到具体的指定编码表时，必须使用转换流。

流的操作规律：
    之所以要弄清这个规律，是因为流对象太多，开发时不知道用哪个对象合适。
想要知道开发时用到哪些对象，只要通过下面四个明确即可。
    1、明确源和目的
        源：InputStream  Reader
        目的：OutputStream Writer

    2、明确数据是否为纯文本数据。
        源：是纯文本：Reader
            否：InputStream
        目的：是纯文本：Writer
              否：OutputStream
          到这里，就可以明确需求中具体使用哪个体系。

    3、明确具体的设备：
        源设备：
            硬盘：File
            键盘：System.in
            内存：数组
            网络：Socket流

        目的设备：
            硬盘：File
            控制台：System.out
            内存：数组
            网络：Socket流。

    4、是否需要其他额外功能。
        1、是否需要高效（缓冲区）
            是，就加上buffer。
        2、是否需要转换流。
            是，就使用InputStreamReader或OutputStreamWriter
        */
    }
}
