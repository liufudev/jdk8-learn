package org.lf.communication;

import com.google.common.collect.Lists;

import org.junit.Test;
import org.lf.generics.Apple;
import org.lf.generics.Fruit;

import java.util.List;

/**
 * Producer Extends Consumer Super
 */
public class PecsDemo {

    @Test
    public void extendsTest() {
        List<? extends Fruit> fruitList = Lists.newArrayList(new Apple());
        Fruit fruit = fruitList.get(0);
        // fruitList.add(new Fruit());
        // fruitList.add(new Apple());
    }

    public void superTest() {
        List<? super Fruit> fruitList = Lists.newArrayList();
        fruitList.add(new Apple());
        //Fruit fruit= fruitList.get(0);
    }


}
