package org.lf.communication;

import com.google.common.collect.Lists;

import org.junit.Before;
import org.junit.Test;
import org.lf.pojo.Man;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamDemo {

    private List<Man> manList = Lists.newArrayList();

    @Before
    public void init() {
        Man p1 = new Man("java", 10);
        Man p2 = new Man("php", 8);
        Man p3 = new Man("c", 20);
        Man p4 = new Man("c++", 15);
        manList.add(p1);
        manList.add(p2);
        manList.add(p3);
        manList.add(p4);
    }

    /**
     * 代替subsubList
     */
    @Test
    public void skipAndLimit() {
        List<Man> collect = manList.stream().skip(1).limit(10).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void sorted() {
        manList.stream().sorted(Comparator.comparing(Man::getAge).reversed()).forEach(System.out::println);
    }

    /**
     * 改变类型
     */
    @Test
    public void map() {
        manList.stream().map(man -> man.getName()).forEach(System.out::println);
        manList.stream().map(Man::getName).forEach(System.out::println);
        System.out.println(manList.stream().mapToInt(Man::getAge).max().getAsInt());
        System.out.println(manList.stream().mapToInt(Man::getAge).summaryStatistics());
    }

    /**
     * 改变个数
     */
    @Test
    public void filter() {
        Predicate<Man> predicate = man -> man.getAge() > 10;
        manList.stream().filter(predicate.negate()).forEach(System.out::println);
    }

    @Test
    public void match() {
        System.out.println(manList.stream().anyMatch(man -> man.getAge() > 3));
        System.out.println(manList.stream().noneMatch(man -> man.getAge() > 3));
    }

    @Test
    public void removeIf() {
        manList.removeIf(man -> man.getAge() > 10);
        System.out.println(manList);
    }
}
