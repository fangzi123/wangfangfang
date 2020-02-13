import org.springframework.util.DigestUtils;

/**
 * @author wangff
 * @date 2020/2/13 18:40
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes()));
    }
}
