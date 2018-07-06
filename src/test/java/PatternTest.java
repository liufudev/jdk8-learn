import com.google.common.collect.Lists;

import java.util.List;

public class PatternTest {


    public static void main(String[] str) {
        List<String> list = Lists.newArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        //  list.add("f");
        //   list.add("g");
        List<String> result = list.size() > 6 ? list.subList(0, 6) : list;
        System.out.println(result);
    }
}
