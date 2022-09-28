package other.medium;

import utils.linkedlist.Node;
import utils.linkedlist.ListNode;
import utils.trees.TreeNode;
import utils.graphs.Node;

/**
 * Problem: 949. Largest Time for Given Digits
 * Difficulty: Medium
 * Link: https://leetcode.com/problemslargest-time-for-given-digits
 */
public class LargestTimeForGivenDigits {
    List<String> l = new ArrayList<>();

    public String largestTimeFromDigits(int[] arr) {
        backtracking(arr, new LinkedHashSet<>(), new StringBuilder());

        String maxString = "";
        int max = -1;
        for (String s : l) {
            int num = Integer.parseInt(s);
            if (num > max) {
                maxString = s;
                max = num;
            }
        }
        if (maxString.equals(""))
            return "";
        return maxString.substring(0, 2) + ":" + maxString.substring(2, 4);
    }

    public void backtracking(int[] arr, LinkedHashSet<Integer> hs, StringBuilder sb) {
        if (hs.size() == 4)
            l.add(sb.toString());
        else {
            for (int i = 0; i < 4; i++) {
                if (hs.contains(i))
                    continue;
                if (hs.size() == 0 && arr[i] > 2)
                    continue;
                if (hs.size() == 1 && sb.charAt(0) == '2' && arr[i] > 3)
                    continue;
                if (hs.size() == 2 && arr[i] > 5)
                    continue;

                sb.append(arr[i]);
                hs.add(i);
                backtracking(arr, hs, sb);
                hs.remove(i);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}