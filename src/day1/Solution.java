package day1;

import javax.xml.transform.SourceLocator;

/**
 * geekbang day 1 home work
 *
 * @author changdp
 * @create 2020-03-05 23:52
 **/
public class Solution {

    public static int removeDuplicates(int[] n) {

        if(n.length == 0) {
            return 0;
        }

        int i = 0;
        for (int j = 1; j < n.length; j++) {
            if (n[j] != n[i]) {
                i++;
                n[i] = n[j];
            }
        }
        return i + 1;
    }
}
