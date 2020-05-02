package pers.edwin.study.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Author edwin-plus
 * Create Data: 2020/5/1 22:50
 */
public class ListUtil {

    /**
     * 在 某个范围内生成固定大小的随机集合
     */
    public static List<Integer> getRandomIntegerList(int start, int end, int size) {

        List<Integer> list = new ArrayList<>();

        Random random = new Random();
        while (list.size() != size) {
            int num = random.nextInt(end - start) + start;
            if (!list.contains(num)) {
                list.add(num);
            }
        }
        return list;
    }
}
