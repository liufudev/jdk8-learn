package org.lf.interfac;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.lf.pojo.Man;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InterfaceDemo {
	private List<Man> ManList = Lists.newArrayList();

	private <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
		Map<Object, Boolean> map = new ConcurrentHashMap<>();
		return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

	@Before
	public void init() {
		ManList.add(new Man("java", 400));
		ManList.add(new Man("php", 20));
		ManList.add(new Man("python", 30));
		ManList.add(new Man("java", 700));
	}

	@Test
	public <T> void test1() {
		Function<? super T, Object> keyExtractor = t ->
				getFilterUser(ManList);
	}

	@Test
	public void test3() {
		Function<Man, Object> keyExtractor = t -> {
			Map<Object, Boolean> map = new ConcurrentHashMap<>();
			return map.putIfAbsent(t, Boolean.TRUE) == null;
		};
		//ManList.stream().filter(distinctByKey(keyExtractor));
		ManList.stream().filter(distinctByKey(Man::getName)).forEach(System.out::println);
		//ManList.stream().distinct().forEach(System.out::println);
	}

	public List<Man> getFilterUser(List<Man> ManList) {
		List<Man> list = Lists.newArrayList();//中间结果,无意义
		for (Man Man : ManList) {
			if (Man.getAge() > 30) {
				list.add(Man);
			}
		}
		return list;
	}

	@Test
	public void test2() {
		Predicate<Man> predicate = t -> t.getAge() > 300;
		System.out.println(getFilterUser(ManList, predicate));
	}

	//返回是空数组，不是null
	public List<Man> getFilterUser(List<Man> ManList, Predicate<Man> predicate) {
		return ManList.stream().filter(predicate).collect(Collectors.toList());
	}

	@Test
	public void test4() {
		Map<String, Integer> map = ManList.stream()
				.collect(Collectors.toMap(a -> a.getName(), a -> a.getAge(), (oldValue, newValue) -> oldValue));
		map.forEach((k, v) -> System.out.println(k + ":" + v));

	}

	@Test
	public void test5() {
		Map<String, Map<Integer, String>> collect = ManList.stream()
				.collect(Collectors.groupingBy(Man::getName, Collectors.toMap(Man::getAge, Man::getName)));
	}

}
