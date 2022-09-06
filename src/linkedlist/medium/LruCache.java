package linkedlist.medium;

import java.util.HashMap;

/**
 * Problem: 146. LRU Cache
 * Difficulty: Medium
 * Link: https://leetcode.com/problemslru-cache
 */
class LRUCache {

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head;
    Node tail;
    HashMap<Integer, Node> cache = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public void add(int key, int val) {
        Node node = new Node(key, val);
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        head.next = node;
        cache.put(key, node);
    }

    public void moveToHead(int key) {
        Node node = remove(key);
        add(node.key, node.val);
    }

    public void evict() {
        Node node = tail.prev;
        remove(node.key);
    }

    public Node remove(int key) {
        Node node = cache.remove(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            moveToHead(key);
            return cache.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key))
            remove(key);
        add(key, value);
        if (cache.size() > capacity)
            evict();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */