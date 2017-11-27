import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by starhaotian on 22/11/2017.
 */
public class test {
    public static void main(String[] args) {
        String s = "201,12,31,21";
        String[] ar = s.split(",");
        List l = new ArrayList();
        l = Arrays.asList(ar);
        System.out.println(l);
        l.add("222");
    }
}
