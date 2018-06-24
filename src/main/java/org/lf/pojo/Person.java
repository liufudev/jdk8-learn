package org.lf.pojo;

public class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		int n = 31;
		n = n * 31 + this.name.hashCode();
		n = n * 31 + this.age;
		return n;
	}

	@Override
	public boolean equals(Object obj) {
		Person person = (Person) obj;
		if (this.getName().equals(person.getName())) {
			return true;
		}
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "Person{" + "name='" + name + '\'' + ", age='" + age + '\'' + '}';
	}
}
