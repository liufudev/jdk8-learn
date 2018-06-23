package org.lf.demo.function;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.lf.pojo.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReduceDemo {

	private List<Person> personList = Lists.newArrayList();

	@Before
	public void init() {
		personList.add(new Person("A", 20));
		personList.add(new Person("C", 50));
		personList.add(new Person("B", 40));
	}

	@Test
	public void test1() {
		Comparator<Integer> comparator = Comparator.comparing(Integer::intValue);
		System.out.println(Stream.of(1, 2, 3).min(comparator).get());
	}

	@Test
	public void test2() {
		Comparator<Integer> comparator = Comparator.comparing(Integer::intValue);
		BinaryOperator<Integer> operator = (a, b) -> a < b ? a : b;
		System.out.println(Stream.of(1, 2, 3, 4, 5).reduce(20, Integer::sum));
		Optional<Person> personOptional = Optional.empty();
	}

	@Test
	public void test3() {
		Stream<Person> personStream = personList.stream().filter(p -> p.getAge() > 100).limit(2);
		System.out.println(personStream.collect(Collectors.toList()));
	}
}
