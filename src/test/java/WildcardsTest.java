import com.google.common.collect.Lists;
import org.junit.Test;
import org.lf.generics.Apple;
import org.lf.generics.Fruit;

import java.util.List;


public class WildcardsTest {

    //<? extends T>：是指 “上界通配符（Upper Bounds Wildcards）”
    @Test
    public void upperTest() {
        List<? extends Fruit> list1 = Lists.newArrayList();
        Fruit fruit = list1.get(1);
        //list1.add(new Apple());

    }

    //<? super T>：是指 “下界通配符（Lower Bounds Wildcards）”
    @Test
    public void lowerTest() {
        List<? super Fruit> list1 = Lists.newArrayList();
        list1.add(new Apple());
        Object object = list1.get(1);
    }

    @Test
    public void test() {
        List<? extends Fruit> list1 = Lists.newArrayList(new Apple());
        System.out.println(list1.get(0));

    }

}
