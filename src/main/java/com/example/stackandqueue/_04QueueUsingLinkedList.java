package com.example.stackandqueue;

public class _04QueueUsingLinkedList {
    class QueueNode {
        int val;
        QueueNode next;

        QueueNode(int data) {
            val = data;
            next = null;
        }
    }


    class Queue {
        QueueNode Front = null, Rear = null;
        int size = 0;

        boolean Empty() {
            return Front == null;
        }
        void push(int a)
        {
            //if queue is empty, then new node is front and rear both.
            if (Rear==null)
            {
                Rear = new QueueNode(a);
                Front = Rear;
            }
            //adding the new node at the end of queue and changing rear.
            else
            {
                QueueNode temp = new QueueNode(a);
                Rear.next=temp;
                Rear=temp;
            }
        }
        //Function to pop front element from the queue.
        int pop()
        {
            QueueNode temp = Front;

            //if queue is empty, we return NULL.
            if(temp==null)
                return -1;

            //if more than one node is present, we move temp one node ahead and
            //delete front. we also update front as new temp.
            if(temp.next != null)
            {
                temp = temp.next;
                int k = Front.val;
                Front = temp;
                //returning the popped element.
                return k;
            }
            //else we delete front and make both rear and front as NULL.
            else
            {
                int k = Front.val;
                Front = null;
                Rear = null;
                //returning the popped element.
                return k;
            }
        }
        int Peek() {
            if (Empty()) {
                System.out.println("Queue is Empty");
                return -1;
            } else
                return Front.val;
        }

        void Enqueue(int value) {
            QueueNode Temp;
            Temp = new QueueNode(value);
            if (Temp == null)  //When heap exhausted
                System.out.println("Queue is Full");
            else {
                if (Front == null) {
                    Front = Temp;
                    Rear = Temp;
                } else {
                    Rear.next = Temp;
                    Rear = Temp;
                }
                System.out.println(value + " Inserted into Queue ");
                size++;
            }
        }

        void Dequeue() {
            if (Front == null)
                System.out.println("Queue is Empty");
            else {
                System.out.println(Front.val + " Removed From Queue");
                QueueNode Temp = Front;
                Front = Front.next;
                size--;
            }
        }
    }
}
