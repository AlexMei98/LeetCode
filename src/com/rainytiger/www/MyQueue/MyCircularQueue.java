package com.rainytiger.www.MyQueue;


class MyCircularQueue {

    private int[] val;
    private int back;
    private int front;
    private int size;
    private int capacity;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        val = new int[k];
        capacity = k;
        back = front = size = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        val[back++] = value;
        size++;
        if (back == capacity) back = 0;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (size == 0) return false;
        size--;
        front++;
        if (front == capacity) front = 0;
        return true;
    }

    /**
     * Get the back item from the queue.
     */
    public int Rear() {
        if (size == 0) return -1;
        if (back == 0) return val[capacity - 1];
        return val[back - 1];
    }

    /**
     * Get the last item from the queue.
     */
    public int Front() {
        if (size == 0) return -1;
        return val[front];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return size == capacity;
    }

}
