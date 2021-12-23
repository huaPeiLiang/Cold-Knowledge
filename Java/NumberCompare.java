import org.junit.Test;

/**
 * 数值类型的比较
 * */
public class NumberCompare {

    /**
     * 第一题：自动装箱与自动拆箱
     * */
    @Test
    public void packingAndSplit() {
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

    /**
     * 第二题：缓存池
     * */
    @Test
    public void cache() {
        Integer a = Integer.valueOf(1);
        Integer b = 1;
        Integer c = Integer.valueOf(128);
        Integer d = 128;
        Integer x = new Integer(1);
        Integer y = new Integer(1);
        Integer z = Integer.valueOf(1);
        Integer k = Integer.valueOf(1);
        System.out.println(x == y);
        System.out.println(z == k);
        System.out.println(a == x);
        System.out.println(x == z);
        System.out.println(b == a);
        System.out.println(b == z);
        System.out.println(b == x);
        System.out.println(c == d);
    }


}

/*
    第一题：
        当一个基础数据类型与封装类进行==、+、-、*、/运算时，会将封装类进行拆箱，对基础数据类型进行运算。
        Integer 使用一个内部静态类中的一个静态数组保存了 -128～127 范围内的数据，静态数组在类加载以后是存在方法区的，并不是什么常量池。在自动装箱的时候，首先判断要装箱的数字的范围，如果在 -128～127 的范围则直接返回缓存中已有的对象，否则 new 一个新的对象。
    答案：
        true
        false
        true
        true
        true
        false
        true

    第二题：
        new Integer() 每次都会创建一个新的对象；
        Integer.valueOf() 会使用缓存池中的对象，多次创建引用的是同一个对象，所以 a、z、k 指向同一个对象；
        Integer b = 1 会使用缓存池中的对象，多次创建引用的是同一个对象，所以 a、b、z、k 指向同一个对象；
        受 -128～127 范围限制，所以 c、d 指向不同的对象。
    答案：
        false
        true
        false
        false
        true
        true
        false
        false
 */