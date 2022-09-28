package other.medium;

import java.util.Arrays;

/**
 * Problem: 622. Design Circular Queue
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsdesign-circular-queue
 */
class MyCircularQueue {

    int size = 0;
    int[] q;
    int front = 0;
    int rear = -1;

    public MyCircularQueue(int k) {
        q = new int[k];
        Arrays.fill(q, -1);
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;

        rear = (rear + 1) % q.length;
        q[rear] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        q[front] = -1;
        front = (front + 1) % q.length;
        size--;
        return true;
    }

    public int Front() {
        return q[front];
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        return q[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == q.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */