package com.org.queue;

import java.util.Scanner;

/**
 * @author zz
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        //接收用户输入
        char key;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show):显示对列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到对列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            System.out.println("请输入：");
            //接受一个字符
            key = scanner.next().charAt(0);
            switch (key){
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
                        System.out.printf("取出的数据是%d\n",arrayQueue.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                 case 'h':
                     try {
                         System.out.printf("队列头数据是%d\n",arrayQueue.headQueue());
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

/**
 * 使用数组模拟队列-编写一个ArrayQueue类
 */
class ArrayQueue {
    /**
     * 表示数组的最大容量
     */
    private final int maxSize;
    /**
     * 队列头
     */
    private int front;
    /**
     * 队列尾
     */
    private int rear;
    /**
     * 用于存放数据的数组：模拟队列
     */
    private final int[] arr;


    /**
     * 创建队列的构造器
     */
    public ArrayQueue(int arrMaxSize){
        maxSize =arrMaxSize;
        arr = new int[maxSize];
        //指向队列头部，指向队列头的前一个位置
        front = -1;
        //指向队列尾部，指向队尾数据（即就是队列最后一个数据）
        rear = -1;
    }

    /**
     * 判断队列是否满
     */

    public boolean isFull(){
        return rear == maxSize-1;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty(){
        return rear == front;
    }

    /**
     * 添加数据
     */
    public void addQueue(int n){
        //判断队列是否满
        if (isFull()){
            System.out.println("队列已满，不能再添加数据");
            return;
        }
        //让rear后移
        rear++;
        arr[rear]=n;
    }
    /**
     * 数据出队列
     */
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    /**
     * 显示所有队列
     */
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空，不能遍历");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    /**
     * 显示队列的头部
     */
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        return arr[front+1];
    }
}
