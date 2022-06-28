package other.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 118. Pascal's Triangle
 * Difficulty: Easy
 * Link: https://leetcode.com/problemspascals-triangle
 */
public class PascalSTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        l.add(row);
        if (numRows == 1)
            return l;

        row = new ArrayList<>(row);
        row.add(1);
        l.add(row);
        System.out.println(l);
        for (int i = 2; i < numRows; i++)
            l.add(gen(l.get(i - 1), i));

        return l;
    }

    public List<Integer> gen(List<Integer> prevRow, int rowNum) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i < rowNum; i++)
            row.add(prevRow.get(i - 1) + prevRow.get(i));
        row.add(1);
        return row;
    }
}