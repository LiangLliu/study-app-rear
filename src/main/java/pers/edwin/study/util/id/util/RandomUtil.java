package pers.edwin.study.util.id.util;

import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 生成ID
 */
public class RandomUtil {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    //生成订单编号-方式一
    public static String generateId() {
        return Instant.now().toEpochMilli() + generateNumber(4);
    }

    //N为随机数流水号
    public static String generateNumber(final int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= num; i++) {
            sb.append(RANDOM.nextInt(9));
        }
        return sb.toString();
    }
}