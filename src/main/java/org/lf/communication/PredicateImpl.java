package org.lf.communication;

import org.lf.pojo.Man;

import java.util.function.Predicate;

public class PredicateImpl implements Predicate<Man> {

    @Override
    public boolean test(Man o) {
        return false;
    }
}
