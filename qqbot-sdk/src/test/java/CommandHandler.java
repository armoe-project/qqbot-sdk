import me.zhenxin.qqbot.annotation.Command;

/**
 * @author 真心
 * @since 2021/12/30 15:15
 */
public class CommandHandler {
    @Command("天气")
    public void test(String args) {
        System.out.println(args);
    }
}
