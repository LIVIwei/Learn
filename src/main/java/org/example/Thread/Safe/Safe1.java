package org.example.Thread.Safe;

/**
 * @Author: LIVI
 * @Time: 2022/10/31  20:45
 * @Description: 改进
 */
public class Safe1 {

    private int count = 0;

    /**
     * 在add方法上添加synchronized关键字，将该方法体设为线程同步块，
     * 方法体每次只能有一个线程执行，这样就有效的解决了线程安全的问题。
    * */
    private synchronized void  add(){
        for(int i=0 ; i<100 ; i++){
            count++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Safe1 safe1 = new Safe1();
        new Thread(()->safe1.add()).start();
        new Thread(()->safe1.add()).start();
        new Thread(()->safe1.add()).start();
        new Thread(()->safe1.add()).start();
        new Thread(()->safe1.add()).start();
        new Thread(()->safe1.add()).start();

        Thread.sleep(1000);
        System.out.println(safe1.count);
    }
}