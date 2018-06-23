package org.lf.interfac;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.lf.pojo.Person;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InterfaceDemo {
	private List<Person> personList = Lists.newArrayList();

	@Before
	public void init() {
		personList.add(new Person("java", 100));
		personList.add(new Person("php", 20));
		personList.add(new Person("python", 30));
		personList.add(new Person("java", 50));
	}

	@Test
	public void test1() {
		getTargetUser(personList);
	}


	public List<Person> getTargetUser(List<Person> personList) {
		List<Person> list = Lists.newArrayList();//中间结果
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
		System.out.println(getTargetUser(personList, predicate));
	}

	//返回是空数组，不是null
	public List<Person> getTargetUser(List<Person> personList, Predicate<Person> predicate) {
		return personList.stream().filter(predicate).collect(Collectors.toList());
	}
}
