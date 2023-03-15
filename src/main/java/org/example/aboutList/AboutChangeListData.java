package org.example.aboutList;


import java.util.*;
/**
 * @Author: LIVI
 * @Time: 2023/03/15  16:19
 * @Description: 任何时候都不要在 for 循环中删除 List 集合元素！！！
 * 首先说结论：无论什么场景，都不要对List使用for循环的同时，删除List集合元素，因为这么做就是不对的。
 * 阿里开发手册也明确说明禁止使用foreach删除、增加List元素。
 */
public class AboutChangeListData {

    /**
     * 正确删除元素的方式是使用迭代器（Iterator），代码如下：
     * */
    // List<String> list = new ArrayList<>();
    // Iterator<String> iterator = list.iterator();
    // while (iterator.hasNext()) {
    //     // 删除元素
    //     iterator.remove();
    // }

    /**
     * JDK8后lambda写法：
     * */
    // list.removeIf(s -> s.contains("a"));

    /**
     * 一个List集合，元素类型为String，有N个元素，删除这些元素中包含字符’‘a’'的元素。
     * */
    //使用迭代器
    public static void main(String[] args) {
        /** List 保证元素的添加顺序，可以重复 **/
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("ab");
        list.add("abc");
        list.add("abcd");

        // Iterator<String> iterator = list.iterator();
        // while (iterator.hasNext()) {
        //     if (iterator.next().contains("a")) {
        //         // 删除元素
        //         iterator.remove();
        //     }
        // }
        // System.out.println(list);
        // // 输出结果为：[]


        // 使用foreach循环
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("a")) {
                list.remove(i);
            }
        }
        System.out.println(list);
        // 输出结果为：[ab, abcd]
        /**
         * 普通for循环遍历List集合的同时，删除List中的元素是可以运行的代码，但在大多数场景下，不能使用这种方式，上边的结果也印证了这一点，
         * 虽然你的代码不会报错，运行也正常，但在本实例中，这么写就是BUG。
         * BUG原因：索引为i的元素删除后，后边元素的索引自动向前补位，即原来索引为i+1的元素，变为了索引为i的元素，但是下一次循环取的索引是i+1，
         * 此时你以为取到的是原来索引为i+1的元素，其实取到是原来索引为i+2的元素。
         * 只要每删除一个元素，就会漏掉下一个元素，所以这种方式从逻辑上来说是存在bug的，无论什么需求场景，都不建议用这种方式，
         * 因为不可控因素太多（鬼知道生产环境中他会删掉多少元素，同时漏掉多少元素）。
         * 既然这么写不报错，那么个别特殊场景确实可以使用这种普通for循环删除元素的，比如我们把实例的需求变动一下，改为：一个List集合，
         * 元素类型为String，有N个元素，删除这些元素中包含字符’a’的元素，
         * 如果有连续两个或以上元素包含’a’，那么只删除当前连续元素中的奇数位元素。虽然这种场景适用，但仍然不推荐，还是因为太不可控。
         * */
    }
}
