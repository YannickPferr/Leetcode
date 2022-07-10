package binarysearch.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Problem: 981. Time Based Key-Value Store
 * Difficulty: Medium
 * Link: https://leetcode.com/problemstime-based-key-value-store
 */
class TimeMap {

    class TimeEntry {
        int timestamp;
        String value;

        public TimeEntry(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    HashMap<String, List<TimeEntry>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<TimeEntry> l = map.getOrDefault(key, new ArrayList<>());
        l.add(new TimeEntry(timestamp, value));
        map.put(key, l);
    }

    public String get(String key, int timestamp) {
        List<TimeEntry> list = map.getOrDefault(key, new ArrayList<>());
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            TimeEntry te = list.get(m);
            if (te.timestamp == timestamp)
                return te.value;
            else if (te.timestamp > timestamp)
                r = m - 1;
            else
                l = m + 1;
        }

        if (r == -1)
            return "";
        return list.get(r).value;
    }

    public int linearSearch(LinkedHashMap<Integer, String> hm, int r) {
        for (int i = r; i >= 1; i--) {
            if (hm.containsKey(i))
                return i;
        }
        return -1;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */