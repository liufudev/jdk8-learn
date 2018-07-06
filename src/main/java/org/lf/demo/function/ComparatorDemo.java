package org.lf.demo.function;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class ComparatorDemo {
	private List<Person> personList = Lists.newArrayList();

	@Before
	public void init() {
		personList.add(new Person("A", 20));
		personList.add(new Person("C", 50));
		personList.add(new Person("B", 40));
	}


	@Test
	public void comparatorTest() {
		Comparator<Person> comparator = Comparator.comparing(Person::getAge);
		personList.sort(comparator);
		personList.forEach(System.out::println);
		System.out.println("##############");
		personList.sort(comparator.reversed());
		personList.forEach(System.out::println);
	}

	@Test
	public void test2() {
		Function<Person, Integer> function = Person::getAge;
		Comparator<Person> comparator = Comparator.comparing(function).reversed();
		personList.sort(comparator);
		personList.forEach(System.out::println);
	}

	@Test
	public void test3() {
		Function<Person, Integer> function = Person::getAge;
		Comparator<Person> comparator = Comparator.comparing(function);
		personList.sort(comparator);
		personList.forEach(System.out::println);
	}

	@Test
	public void test4() {
		Comparator<Person> byName = new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				///	return o1.getName().compareTo(o2.getName());
				return o1.getAge() > o2.getAge() ? 1 : -1;
			}
		};
	}

	@Test
	public void test5() {
		Function<Person, Integer> keyExtractor = Person::getAge;
		Comparator<Integer> keyComparator = Comparator.comparing(a -> -a);
		Comparator<Person> comparator = Comparator.comparing(keyExtractor, keyComparator);
		personList.sort(comparator);
		personList.forEach(System.out::println);
	}


	@Test
	public void test6() {
		Comparator<Person> byName = new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				///	return o1.getName().compareTo(o2.getName());
				return o1.getAge() > o2.getAge() ? 1 : -1;
			}
		};
	}
}
