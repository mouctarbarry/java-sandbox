package org.main;

import java.util.*;

class Program {
    public static boolean isValidSubsequence(
            List<Integer> array, List<Integer> sequence
    ) {
        int i = 0;
        while (i < sequence.size()) {
            if (array.contains(sequence.get(i))) {
                i++;
            } else return false;
        }
        return true;
    }
}
