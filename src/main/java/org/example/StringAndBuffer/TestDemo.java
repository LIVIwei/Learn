package org.example.StringAndBuffer;

/**
 * @Author: LIVI
 * @Time: 2022/10/27  11:28
 * @Description: String 对象的引用变量的指向是可以修改的
 */
public class TestDemo {
    public static void main(String[] args) {
        String s = "林哥";
        s += "love";
        s = "666";
        test(s);
        // s = 666
        System.out.println("s = " + s);
    }

    private static void test(String str) {
        // str 是局部变量, 生命周期只在 test 方法中
        str += 123;
    }
}

