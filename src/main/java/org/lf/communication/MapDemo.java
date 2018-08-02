package org.lf.communication;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import org.junit.Before;
import org.junit.Test;
import org.lf.pojo.Man;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapDemo {

    private Map<String, Man> manMap = Maps.newHashMap();
    private List<Man> manList = Lists.newArrayList();

    @Before
    public void init() {
        Man p1 = new Man("java", 10);
        Man p2 = new Man("php", 8);
        Man p3 = new Man("c", 20);
        manMap.putIfAbsent(p1.getName(), p1);
        manMap.putIfAbsent(p2.getName(), p2);
        manMap.putIfAbsent(p3.getName(), p3);
        manList.add(p1);
        manList.add(p2);
        manList.add(p3);
        Man p4 = new Man("c", 60);
        //manList.add(p4);
    }

    @Test
    public void convert1() {
        Map<String, Man> map = manList.stream().collect(Collectors.toMap(Man::getName, man -> man));
        map.forEach((k, v) -> System.out.println(v));
        Map<String, Man> map1 = manList.stream().collect(Collectors.toMap(Man::getName, Function.identity()));
        map1.forEach((k, v) -> System.out.println(v));
    }

    @Test
    public void convert2() {
        Function<? super Man, ? extends String> function1 = man -> man.getName();
        Function<? super Man, ? extends String> function2 = Man::getName;
        Map<String, Man> map = manList.stream().collect(Collectors.toMap(function1, man -> man, (oldValue, newValue) -> oldValue));
        map.forEach((k, v) -> System.out.println(v));
    }

    @Test
    public void sort() {
        Comparator<Man> comparing = Comparator.comparing(Man::getAge);
        manMap.entrySet().stream().sorted(Map.Entry.comparingByValue(comparing)).forEach(System.out::println);
        manMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
    }
}
