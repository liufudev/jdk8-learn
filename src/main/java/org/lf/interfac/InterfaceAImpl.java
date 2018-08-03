package org.lf.interfac;

import org.junit.Test;

public class InterfaceAImpl implements InterfaceA, InterfaceB {



	@Test
	public void test() {
        foo();
        //InterfaceA.super.foo();
    }


	@Override
	public void foo() {
        System.out.println("InterfaceAImpl");
	}
}
