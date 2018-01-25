import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chenhao.ye on 2017/10/7.
 */
public class PatternTest {

    public static void main(String[] args) {
        String content = "I am roob from runoob.com";
        String pattern = ".*runoob.*";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(content);
        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
