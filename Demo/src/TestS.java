import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TestS {
    public static void main(String[] args) {
        int s = 29;
        double d = 114.1454587;
        d = (double) Math.round(d * 100) / 100;
        System.out.println(d);
        System.out.println(System.currentTimeMillis()/1000);
        for (int i = (s/15)+1; i < 4; i++) {
//            System.out.println(15*i);
        }
        // 获取当天凌晨0点0分0秒Date
        Calendar calendar1 = Calendar.getInstance(Locale.CHINA);
        calendar1.set(calendar1.get(Calendar.YEAR), calendar1.get(Calendar.MONTH), calendar1.get(Calendar.DAY_OF_MONTH),
                0, 0, 0);
        Date beginOfDate = calendar1.getTime();
        System.out.println(calendar1.get(Calendar.YEAR));
        System.out.println(calendar1.get(Calendar.MONTH));
        System.out.println(calendar1.get(Calendar.DAY_OF_MONTH));
//        System.out.println(beginOfDate.getTime()/1000);


    }
}
