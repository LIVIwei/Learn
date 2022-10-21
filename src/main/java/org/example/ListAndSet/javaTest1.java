package org.example.ListAndSet;

import java.util.*;

/**
 * @Author: LIVI
 * @Time: 2022/10/18  17:16
 * @Description: List有序可重复————顺序有两个概念，一是按添加的顺序排列，二是遍历结果按自然顺序a-z排列。
 * Set并不是无序的，传统说的Set无序是指HashSet,它不能保证元素的添加顺序，更不能保证自然顺序，而Set的其他实现类是可以实现这两种顺序的。
 */
public class javaTest1 {
    public static void main(String[] args) {
        /** List 保证元素的添加顺序，可以重复 **/
        ArrayList<String> list = new ArrayList<>();
        list.add("s1");
        list.add("s3");
        list.add("s2");
        list.add("s4");
        list.add("s4");
        list.add("s1");
        list.add("s5");
        list.forEach(e -> System.out.print(e + " "));
        System.out.println();

        /** HashSet  无序 不能重复**/
        Set<String> hashSet = new HashSet<>();
        hashSet.add("s1");
        hashSet.add("s3");
        hashSet.add("s5");
        hashSet.add("s4");
        hashSet.add("s4");
        hashSet.add("s2");
        hashSet.forEach(e -> System.out.print(e + " "));
        System.out.println();

        /** LinkedHashSet 保证元素添加的顺序**/
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("s1");
        linkedHashSet.add("s3");
        linkedHashSet.add("s5");
        linkedHashSet.add("s4");
        linkedHashSet.add("s4");
        linkedHashSet.add("s2");
        linkedHashSet.forEach(e -> System.out.print(e + " "));
        System.out.println();

        /** 保证元素自然的顺序：TreeSet **/
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("s1");
        treeSet.add("s3");
        treeSet.add("s5");
        treeSet.add("s4");
        treeSet.add("s4");
        treeSet.add("s2");
        treeSet.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}
