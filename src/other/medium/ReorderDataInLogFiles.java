package other.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Problem: 937. Reorder Data in Log Files
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsreorder-data-in-log-files
 */
public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        ArrayList<String> letterLogs = new ArrayList<>();
        ArrayList<String> digitLogs = new ArrayList<>();
        for (String log : logs) {
            int firstCharIdx = log.indexOf(" ") + 1;
            if (Character.isDigit(log.charAt(firstCharIdx)))
                digitLogs.add(log);
            else
                letterLogs.add(log);
        }

        Collections.sort(letterLogs, new Comparator<String>() {
            public int compare(String a, String b) {
                int firstCharIdxA = a.indexOf(" ") + 1;
                int firstCharIdxB = b.indexOf(" ") + 1;

                int compare = a.substring(firstCharIdxA, a.length()).compareTo(b.substring(firstCharIdxB, b.length()));
                if (compare == 0)
                    return a.substring(0, firstCharIdxA).compareTo(b.substring(0, firstCharIdxB));
                else
                    return compare;
            }
        });

        int i = 0;
        for (String s : letterLogs)
            logs[i++] = s;
        for (String s : digitLogs)
            logs[i++] = s;
        return logs;
    }
}