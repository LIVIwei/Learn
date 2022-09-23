package org.example;

/**
 * @Author: ${USER}
 * @Time: ${YEAR}/${MONTH}/${DAY}  ${HOUR}:${MINUTE}
 * @Description: ${Description}
 */

public class Main {
    public static class InvalidTriangleException extends RuntimeException {
        public InvalidTriangleException(float x, float y, float z){
            super(String.format("Invalid triangle - (%.3f, %.3f, %.3f)", x, y, z));
        }
    }

    private static float getArea(float x, float y, float z) {
        if ((x + y < z) || (x + z < y) || (y + z < x)){
            throw new InvalidTriangleException(x,y,z);
        }else {
            float p = (x+y+z)/2;
            return (float) Math.sqrt((p-x)*(p-y)*(p-z)*p);
        }
    }

    public static void main(String[] args) {

        System.out.println(Main.getArea(3,4,5));

        /*String s1 = "1";
        int s2 = 2;
        //执行的的是字符串拼接,并没有相加
        System.out.println(s1+s2);*/

        /*
        //这个新建地址的，用== 的话比较地址应该是false的
        // static Integer a = new Integer(10);
        // static Integer b = new Integer(10);
        */

        /*
        //自动拆箱，包装类型==基本数据类型会发生自动拆箱，比较值,包装类型发生自动拆箱
        // static Integer a = new Integer(10);
        // static int b = 10;
        */
        /*
        //Integer 范围[-128~127]
        // Integer a = 128;
        // Integer b = 128;
        // Integer c = -127;
        // Integer d = -127;
        */
        // System.out.println(a == b? 0:1 );
        // System.out.println(c == d? 0:1 );
    }
}