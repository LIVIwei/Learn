package org.example.thread;

import org.junit.Test;

// 类里面除了方法就是变量，方法里面可以调用方法
public class Demo1Test {


    // 单线程的两种调用方法
//	threadDemo1 demo1 = new threadDemo1();
    // 方法一：
    // JVM调用Junit,Junit调用Test
//	@Test
//	public void test() {
//		demo1.run();
//	}

    /////////////////////////////////////

    // 方法二：
    // JVM调用方法
//	public static void main(String[] args) {
//		Demo1Test demo1Test = new Demo1Test();
//		demo1Test.test();
//	}
    /////////////////////////////////////

    // 那么如何进行多线程呢？
    public static void main(String[] args) {
        threadDemo1 demo1 = new threadDemo1();  // runable类型
        threadDemo2 demo2 = new threadDemo2();

        // 构造一个线程，指定要执行的逻辑
        Thread thread1 = new Thread(demo1);  // 传入runable类型值
        Thread thread2 = new Thread(demo2);  // 传入runable类型值
        Thread thread3 = new Thread(demo1);  // 传入runable类型值

        // 启动线程
        thread1.start();
        thread2.start();
        thread3.start();
    }



}

