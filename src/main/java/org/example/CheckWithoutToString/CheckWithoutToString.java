package org.example.CheckWithoutToString;

import org.example.CheckWithoutToString.DAO.toStringTest;

/**
 * @Author: LIVI
 * @Time: 2022/09/29  17:27
 * @Description:java实体类重写tostring方法的测试调用
 */
public class CheckWithoutToString {
        public static void main(String[] args) {
            Class<?> demo= null;
            //包-类路径   demo=Class.forName("demoTest_zt.Ceks_tostring");
            toStringTest test= new toStringTest();
            test.setName("zout");
            test.setNo(001);
            test.setSex("man");
            test.Show();
            System.out.println("调用实体类返回的是:" +test);
        }
}
