/**
 * 数值类型的比较（答案：见文末）
 * */
public class number_compare {

    /**
     * 自动装箱与自动拆箱
     * */
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 128;
        Integer f = 128;
        Long g = 3L;
        int h = 128;
        int j = 128;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
        System.out.println(h == j);
    }

}

/*
重点：
当一个基础数据类型与封装类进行==、+、-、*、/运算时，会将封装类进行拆箱，对基础数据类型进行运算。
Integer 使用一个内部静态类中的一个静态数组保存了 -128～127 范围内的数据，静态数组在类加载以后是存在方法区的，并不是什么常量池。在自动装箱的时候，首先判断要装箱的数字的范围，如果在 -128～127 的范围则直接返回缓存中已有的对象，否则 new 一个新的对象。

结果：
true：指向同一对象
false：值大于127，即使值相同，指向的也是不同的内存地址
true：自动拆箱后他们的值是相等的
true：值相同，而且类型相同
true：自动拆箱后他们的值相等
false：equals 方法不会触发自动装拆箱，所以值相同但是类型不同
true：指向同一对象
 */