package org.lf.interfac;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.lf.pojo.Person;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InterfaceDemo {
	private List<Person> personList = Lists.newArrayList();

	private <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
		Map<Object, Boolean> map = new ConcurrentHashMap<>();
		return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

	@Before
	public void init() {
		personList.add(new Person("java", 400));
		personList.add(new Person("php", 20));
		personList.add(new Person("python", 30));
		personList.add(new Person("java", 700));
	}

	@Test
	public <T> void test1() {
		Function<? super T, Object> keyExtractor = t ->
		getFilterUser(personList);
	}

	@Test
	public void test3() {
		Function<Person, Object> keyExtractor = t -> {
			Map<Object, Boolean> map = new ConcurrentHashMap<>();
			return map.putIfAbsent(t, Boolean.TRUE) == null;
		};
		//personList.stream().filter(distinctByKey(keyExtractor));
		personList.stream().filter(distinctByKey(Person::getName)).forEach(System.out::println);
		//personList.stream().distinct().forEach(System.out::println);
	}

	public List<Person> getFilterUser(List<Person> personList) {
		List<Person> list = Lists.newArrayList();//中间结果,无意义
		for (Person person : personList) {
			if (person.getAge() > 30) {
				list.add(person);
			}
		}
		return list;
	}

	@Test
	public void test2() {
		Predicate<Person> predicate = t -> t.getAge() > 300;
		System.out.println(getFilterUser(personList, predicate));
	}

	//返回是空数组，不是null
	public List<Person> getFilterUser(List<Person> personList, Predicate<Person> predicate) {
		return personList.stream().filter(predicate).collect(Collectors.toList());
	}

	@Test
	public void test4() {
		Map<String, Integer> map = personList.stream()
				.collect(Collectors.toMap(a -> a.getName(), a -> a.getAge(), (oldValue, newValue) -> oldValue));
		map.forEach((k, v) -> System.out.println(k + ":" + v));

	}

}
