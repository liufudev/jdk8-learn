package org.lf.demo.function;

import com.google.common.collect.Lists;

import org.junit.Before;
import org.junit.Test;
import org.lf.pojo.Man;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class ComparatorDemo {
	private List<Man> ManList = Lists.newArrayList();

	@Before
	public void init() {
		ManList.add(new Man("A", 20));
		ManList.add(new Man("C", 50));
		ManList.add(new Man("B", 40));
		ManList.add(new Man("E", 40));
	}


	@Test
	public void comparatorTest() {
		Comparator<Man> comparator = Comparator.comparing(Man::getAge);
		ManList.sort(comparator);
		ManList.forEach(System.out::println);
		System.out.println("##############");
		ManList.sort(comparator.reversed());
		ManList.forEach(System.out::println);
	}

	@Test
	public void test2() {
		Function<Man, Integer> function = Man::getAge;
		Comparator<Man> comparator = Comparator.comparing(function).reversed();
		ManList.sort(comparator);
		ManList.forEach(System.out::println);
	}

	@Test
	public void test3() {
		Function<Man, Integer> function = Man::getAge;
		Comparator<Man> comparator = Comparator.comparing(function);
		ManList.sort(comparator);
		ManList.forEach(System.out::println);
	}

	@Test
	public void test4() {
		Comparator<Man> byName = new Comparator<Man>() {
			@Override
			public int compare(Man o1, Man o2) {
				///	return o1.getName().compareTo(o2.getName());
				return o1.getAge() > o2.getAge() ? 1 : -1;
			}
		};
	}

	@Test
	public void test5() {
		Function<Man, Integer> keyExtractor = Man::getAge;
		Comparator<Integer> keyComparator = Comparator.comparing(a -> -a);
		Comparator<Man> comparator = Comparator.comparing(keyExtractor, keyComparator);
		ManList.sort(comparator);
		ManList.stream().sorted(Comparator.comparing(Man::getAge).reversed()).forEach(System.out::print);
		//ManList.forEach(System.out::println);
	}


	@Test
	public void test6() {
		Comparator<Man> byName = new Comparator<Man>() {
			@Override
			public int compare(Man o1, Man o2) {
				///	return o1.getName().compareTo(o2.getName());
				return o1.getAge() > o2.getAge() ? 1 : -1;
			}
		};
	}
}
