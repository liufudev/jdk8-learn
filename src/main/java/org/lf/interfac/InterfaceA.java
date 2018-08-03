package org.lf.interfac;

public interface InterfaceA {
	default void foo() {
		System.out.println("InterfaceA foo");
	}

    default void foo1() {
        System.out.println("InterfaceA foo1");
    }
}
