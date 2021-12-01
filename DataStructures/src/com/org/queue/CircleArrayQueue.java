package com.org.queue;

import java.util.Scanner;

/**
 * 数组复用
 *
 * @author zz
 */
public class CircleArrayQueue {
    public static void main(String[] args) {
        CircleArray arrayQueue = new CircleArray(4);
        //接收用户输入
        char key;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示对列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到对列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            System.out.println("请输入：");
            //接受一个字符
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个int类型数字：");
                    int i = scanner.nextInt();
                    arrayQueue.addQueue(i);
                    break;
                case 'e':
                    loop = false;
                    System.out.println("程序退出");
                    break;
                case 'g':
                    try {
                        System.out.printf("取出的数据是%d\n", arrayQueue.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'h':
                    try {
                        System.out.printf("队列头数据是%d\n", arrayQueue.headQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("请正确输入's'、'a'、'e'、'g'、'h'其中一个字符！");
            }
        }
    }
}

class CircleArray {
    /**
     * 表示数组的最大容量
     */
    private final int maxSize;
    /**
     * 队列头指向第一个元素初始值为0
     */
    private int front;
    /**
     * 队列尾指向队列最后一个元素初始值为0
     */
    private int rear;
    /**
     * 用于存放数据的数组：模拟队列
     */
    private final int[] arr;


    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        //指向队列头部，指向队列头的第一个位置
        front = 0;
        //指向队列尾部，指向队尾数据（即就是队列最后一个数据）
        rear = 0;
    }

    /**
     * 断队列是否满判
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return rear == front;
    }


    /**
     * 添加数据
     */
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列已满，不能再添加数据");
            return;
        }
        //数据直接插入
        arr[rear] = n;
        //让rear后移
        rear = (rear + 1) % maxSize;
    }

    /**
     * 数据出队列
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        //front是指向队列的第一个元素
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }


    /**
     * 显示所有队列
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，不能遍历");
            return;
        }

        //从front开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 求出当前队列有效数据个数；
     */

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 显示队列的头部
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        return arr[front];
    }
}

