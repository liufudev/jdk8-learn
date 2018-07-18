/**
 * @author liufu
 */
public class StringTest {
    public static final String link = "http://legox.yy.com/assets/yijian/{}/preview/index.html#/profile";

    public static void main(String[] args) {
        System.out.println(link.replace("{}", "1.0"));
        System.out.println(link);
    }
}
