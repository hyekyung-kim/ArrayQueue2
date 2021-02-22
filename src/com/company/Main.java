package com.company;

import java.util.Scanner;

class ArrayQueue{
    int front;
    int rear;
    int qSize;
    int[] array;

    public ArrayQueue(int front, int rear, int qSize){
        this.front = front;
        this.rear = rear;
        this.qSize = qSize;
        array = new int[qSize];
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public boolean isFull(){
        return rear == qSize;
    }

    public void enQueue(int data){
        if(!isFull()){
            array[rear++] = data;
        }else{
            System.out.println("Queue is FULL\n");
        }
    }

    public int deQueue(){
        if(!isEmpty()){
            int data = array[front];

            int idx = front;
            while(idx < rear-1){
                array[idx] = array[idx+1];
                idx++;
            }
            rear--;
            return data;
        }else{
            System.out.println("Queue is EMPTY\n");
            return -1;
        }
    }

    public void printQueue(){
        for(int i = front; i < rear; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Queue size: ");
        int qSize = input.nextInt();

        // front, rear가 0이고 배열의 크기가 qSize인 queue 생성
        ArrayQueue queue = new ArrayQueue(0, 0, qSize);

        System.out.println("MENU | 1: enQueue | 2: deQueue | 3: printQueue | -1: exit");
        int check;
        do{
            System.out.print("What do you want? ");
            check = input.nextInt();

            if(check == 1){         // enQueue
                System.out.print("Input data: ");
                int data = input.nextInt();
                queue.enQueue(data);
            }else if(check == 2){   // deQueue
                System.out.print("deQueue: ");
                System.out.println(queue.deQueue());
            }else if(check == 3){   // printQueue
                queue.printQueue();
            }else if(check == -1){  // exit
                System.out.println("exit...");
            }else{                  // exception
                System.out.println("Command not found.\n");
            }

        }while(check != -1);

    }
}
