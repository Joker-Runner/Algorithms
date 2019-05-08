package com.joker;

public class MaxHeap {

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 23, 26, 84, 19, 2, 76, 54, 7, 21, 17};
        MaxHeap maxHeap = new MaxHeap(100);
        for (int item : arr)
            maxHeap.insert(item);

        int size = maxHeap.size;
        for (int i = 0; i < size; i++)
            System.out.println(maxHeap.deleteMax());
    }


    private int[] heap; //存储堆数据
    private int size; //堆大小
    private int maxSize; //堆的最大容量

    public int getSize() {
        return size;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        heap = new int[maxSize];
        heap[0] = Integer.MAX_VALUE;
    }

    public boolean insert(int item) {
        if (size == maxSize)
            return false;
        int i = ++size;
        for (; heap[i / 2] < item; i /= 2) {
            heap[i] = heap[i / 2];

        }
        heap[i] = item;

        return true;
    }

    public int deleteMax() {
        int parent, child; //下标
        int maxItem, temp;
        if (size == 0)
            return -1;
        maxItem = heap[1];

        temp = heap[size--];
        for (parent = 1; parent * 2 < size; parent = child) {
            child = parent * 2;
            if (child != size && heap[child] < heap[child + 1])
                child++;
            if (temp >= heap[child])
                break;
            else
                heap[parent] = heap[child];
        }

        heap[parent] = temp;

        return maxItem;
    }
}
