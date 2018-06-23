package org.lf.generics;

import org.junit.Test;

public class MainDemo {
	public static void main(String args[]) {
		Plate<? extends Fruit> p1 = new Plate<Apple>(new Apple());
		Plate<? super Fruit> p2 = new Plate<Food>(new Apple());
	}

	@Test
	public void test1() {
		Plate<? extends Fruit> p1 = new Plate<Apple>(new Apple());
		Fruit fruit = p1.get();
	}

	@Test
	public void test2() {
		Plate<? super Fruit> p2 = new Plate<Food>(new Apple());
		Object object = p2.get();
	}
}
