package day03;

public class BreakAndContinue {
    public static void main(String[] args) {
        /*
        break(跳出所在的）：选择（switch）结构和循环结构
        continue（继续）：循环结构
        注意：
        1、应用其范围外时会报错
        2、当break语句时单独存在时，下面不要定义其他语句，因为执行不到，会报错。
        for (int i = 0; i < 3; i++) {
            if(i==1)
                break;//break跳出的for循环而不是if选择结构。
            System.out.println("i="+i);
        }
        3、break跳出所在的当前循环。
           如果出现了循环嵌套，break想要跳出指定的循环，可以通过标号来完成。
        out1:for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("i="+i);
                if（i==1)
                    break;//跳出内循环
            }
            break out1;//跳出外循环
        4、continue的作用范围只能是循环结构，结束本次循环，继续下次循环
           如果continue单独存在时，下面不要有任何语句，因为执行不到。
        }
         */
        for (int i = 0; i < 11; i++) {//打印奇数
            if (i % 2 == 0){
                continue;
            }
            System.out.println("i="+i);
        }
    }
}
