import com.google.common.collect.Lists;
import org.junit.Test;
import org.lf.pojo.Car;
import org.lf.pojo.Insurance;
import org.lf.pojo.Person;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class OptionalTest {
    public static void main(String[] args) {
        Person person = new Person();
        Optional<Person> optPerson = Optional.of(person);
        Optional<String> name =
                optPerson.flatMap(Person::getCar)
                        .flatMap(Car::getInsurance)
                        .map(Insurance::getName);
    }

    @Test
    public void test1() {
        ArrayList<Integer> list1 = Lists.newArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        ArrayList<Integer> list2 = Lists.newArrayList();
        list1.add(7);
        list1.add(8);
        list1.add(9);
        list1.add(10);
        ArrayList<ArrayList<Integer>> result = Lists.newArrayList();
        // <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
        //Function<? super T, ? extends Stream<? extends R>> mapper
        Function<List<Integer>, Stream<Integer>> mapper = a -> a.stream();
        result.stream().flatMap(mapper);
    }

    @Test
    public void test2() {
        ArrayList<String> list1 = Lists.newArrayList();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        ToIntFunction<String> mapper = a -> Integer.valueOf(a);
        list1.stream().mapToInt(mapper);
        IntSummaryStatistics intSummaryStatistics = list1.stream().mapToInt(Integer::valueOf).summaryStatistics();
    }


}
