package org.example.Thread.Safe;

/**
 * @Author: LIVI
 * @Time: 2022/10/31  20:30
 * @Description: 关于重复调用线程；该离职目的是为了实现线程被占用的例子
 */
public class Safe {

    private int count = 0;

    private  void  add(){
        for(int i=0 ; i<100 ; i++){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
    }
    /**
    *   类Safe中仅有一个count的成员变量初始值为0，现在六个线程访问这个Safe对象，
     *   对count的值进行各累加100次。按照正常情况算出的结果应该为600，但是实际执行的结果却并不是：
    * */
    public static void main(String[] args) throws InterruptedException {
        Safe safe = new Safe();
        new Thread(()->safe.add()).start();
        new Thread(()->safe.add()).start();
        new Thread(()->safe.add()).start();
        new Thread(()->safe.add()).start();
        new Thread(()->safe.add()).start();
        new Thread(()->safe.add()).start();

        Thread.sleep(1000);
        System.out.println(safe.count);
    }
}