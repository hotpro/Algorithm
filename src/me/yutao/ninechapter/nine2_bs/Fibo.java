package me.yutao.ninechapter.nine2_bs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yutao on 6/30/15.
 */
public class Fibo {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<Integer>();

        array.add(0);;
        array.add(1);;
        array.add(2);;
        array.add(3);;
        array.add(4);;

        Iterator<Integer> iterator = array.iterator();

        while (iterator.hasNext()) {
            if (iterator.next() == 3) {
                iterator.remove();
            }
        }
        System.out.println(array);
    }
}
