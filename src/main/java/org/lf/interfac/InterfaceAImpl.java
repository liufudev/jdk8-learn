package org.lf.interfac;

import org.junit.Test;

public class InterfaceAImpl implements InterfaceA, InterfaceB {


	public void call() {
		foo();
	}

	@Test
	public void test() {
		call();
	}

	@Override
	public void foo() {
		InterfaceA.super.foo();
	}
}
