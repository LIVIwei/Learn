package org.example.ListAndSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: LIVI
 * @Time: 2022/11/29  19:05
 * @Description:
 */


public class Test {
    public List<PeopleInfo> Test() {

        List<PeopleInfo> peopleInfoList = new ArrayList<>();
        List<PeopleInfo> peopleInfoList1 = new ArrayList<>();
        List<PeopleInfo> peopleInfoList2 = new ArrayList<>();
        for (int i = 1; i < 5000; i++) {
            PeopleInfo peopleInfo = new PeopleInfo();
            peopleInfo.setId(i);
            peopleInfo.setUserName("123456");
            if (i % 2 == 0) {
                peopleInfo.setAge("1");
            } else {
                peopleInfo.setAge("2");
            }
            peopleInfoList.add(peopleInfo);
        }
        int c = 3;
        for (int j = 6000; j < 10000; j++) {
            PeopleInfo peopleInfo = new PeopleInfo();
            peopleInfo.setId(j);
            peopleInfo.setUserName("78910");
            if (j % 2 == 0) {
                peopleInfo.setAge("2");
            } else {
                c = c + 1;
                peopleInfo.setAge(String.valueOf(c));
            }

            peopleInfoList1.add(peopleInfo);
        }
        System.out.println("b" + peopleInfoList1);
        peopleInfoList2.addAll(peopleInfoList);
        peopleInfoList2.addAll(peopleInfoList1);
        List<PeopleInfo> peopleInfoList3 = new ArrayList<>();
        List<PeopleInfo> peopleInfoList4 = new ArrayList<>();
        HashMap<String, PeopleInfo> StudentMap = new HashMap<String, PeopleInfo>();
        for (PeopleInfo person : peopleInfoList2) {

            if (StudentMap.get(person.getAge()) == null) {
                StudentMap.put(person.getAge(), person);
                peopleInfoList3.add(person);
            } else {
                peopleInfoList4.add(person);
            }
        }

        return peopleInfoList3;
    }
}