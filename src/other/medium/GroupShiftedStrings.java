package other.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Problem: 249. Group Shifted Strings
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsgroup-shifted-strings
 */
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> groups = new HashMap<>();
        for (String s : strings) {
            String group = dist(s);
            List<String> l = groups.getOrDefault(group, new ArrayList<>());
            l.add(s);
            groups.put(group, l);
        }

        List<List<String>> all = new ArrayList<>();
        for (String group : groups.keySet())
            all.add(groups.get(group));
        return all;
    }

    public String dist(String s) {
        if (s.length() == 1)
            return "";

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            int dist = s.charAt(i) - s.charAt(i - 1);
            if (dist < 0)
                dist = 26 + dist;
            sb.append(dist + "-");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}