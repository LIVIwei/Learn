package org.example.CheckWithoutToString.DAO;

/**
 * @Author: LIVI
 * @Time: 2022/09/29  17:28
 * @Description:java实体类重写tostring方法的测试
 */
public class toStringTest {
    private String name;
    private String sex;
    private int No;

    public void Show(){
        System.out.println("这是没有tostring重写实体类的时候！");
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getNo() {
        return No;
    }
    public void setNo(int no) {
        this.No = no;
    }
}
