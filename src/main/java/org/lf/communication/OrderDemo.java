package org.lf.communication;

import com.google.common.collect.Sets;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class OrderDemo {


    @Test
    public void test1() {
        Stream.of("AAA", "BBB", "CCC").parallel().forEach(s -> System.out.println("Output:" + s));
        Stream.of("AAA", "BBB", "CCC").parallel().forEachOrdered(s -> System.out.println("Output:" + s));

    }

    @Test
    public void test2() {
        for (int i = 0; i < 100; i++) {
            Set<Integer> list = Sets.newHashSet(1, 2, 3, 4, 5, 6, 7, 8, 2, 3, 4, 5, 6, 7, 8, 2, 3, 4, 5, 6, 7, 8);
            List<Integer> collect =
                    list.stream().unordered().parallel().map(a -> a * a * 2 * 4 * 6 - 10).filter(a -> a > 100).collect(Collectors.toList());
            System.out.println(collect);
        }

    }

    @Test
    public void test3() {
        for (int i = 0; i < 100; i++) {
            HashSet<Integer> set = Sets.newHashSet(4, 5, 1, 2, 3);
            System.out.println(set);
            //  System.out.println(set.stream().unordered().map(x -> x * 2).collect(Collectors.toList()));
        }
    }

    @Test
    public void test4() {
    }
}
