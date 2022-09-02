import com.alibaba.druid.sql.visitor.functions.Now;
import org.junit.Test;

import java.util.Date;

/**
 * @auther DyingZhang
 * @Create 2022-08-27 16:51
 * @Discriptioon
 */
public class testTime {
    @Test
    public void testTime(){
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);

    }
}
