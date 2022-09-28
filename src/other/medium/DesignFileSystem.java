package other.medium;

import java.util.HashMap;

/**
 * Problem: 1166. Design File System
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsdesign-file-system
 */
class FileSystem {

    class Path {
        String name;
        int val;
        HashMap<String, Path> children = new HashMap<>();

        public Path(String name, int val) {
            this.name = name;
            this.val = val;
        }
    }

    Path root;

    public FileSystem() {
        root = new Path("", 0);
    }

    public boolean createPath(String path, int value) {
        String[] parents = path.split("/");
        Path currLevel = root;
        for (int i = 1; i < parents.length - 1; i++) {
            String parent = parents[i];
            if (!currLevel.children.containsKey(parent))
                return false;
            currLevel = currLevel.children.get(parent);
        }
        if (currLevel.children.containsKey(parents[parents.length - 1]))
            return false;
        currLevel.children.put(parents[parents.length - 1], new Path(parents[parents.length - 1], value));
        return true;
    }

    public int get(String path) {
        String[] parents = path.split("/");
        Path currLevel = root;
        for (int i = 1; i < parents.length - 1; i++) {
            String parent = parents[i];
            if (!currLevel.children.containsKey(parent))
                return -1;
            currLevel = currLevel.children.get(parent);
        }
        if (!currLevel.children.containsKey(parents[parents.length - 1]))
            return -1;
        return currLevel.children.get(parents[parents.length - 1]).val;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */