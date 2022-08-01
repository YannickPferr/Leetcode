package linkedlist.medium;

import java.util.HashMap;

/**
 * Problem: 146. LRU Cache
 * Difficulty: Medium
 * Link: https://leetcode.com/problemslru-cache
 */
class LRUCache {

    public class Node {
        Node prev;
        Node next;
        int value;
        int key;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity = 0;
    HashMap<Integer, Node> cache = new HashMap<>();
    Node head = null;
    Node tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void add(Node n) {
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
    }

    public void remove(Node n) {
        if (n == head && n == tail) {
            head = null;
            tail = null;
        } else if (n == head) {
            head.next.prev = null;
            head = head.next;
        } else if (n == tail) {
            tail.prev.next = null;
            tail = tail.prev;
        } else {
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }
    }

    public Node evict() {
        Node evicted = head;
        if (head != null) {
            head = head.next;
            if (head != null)
                head.prev = null;
        }
        return evicted;
    }

    public int get(int key) {
        Node n = cache.get(key);
        if (n == null)
            return -1;
        remove(n);
        add(n);
        return n.value;
    }

    public void put(int key, int value) {
        Node n = cache.get(key);
        if (n == null) {
            if (cache.size() == capacity) {
                Node evicted = evict();
                if (evicted != null)
                    cache.remove(evicted.key);
            }
            n = new Node(key, value);
            add(n);
            cache.put(key, n);
        } else {
            remove(n);
            n = new Node(key, value);
            add(n);
            cache.put(key, n);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */