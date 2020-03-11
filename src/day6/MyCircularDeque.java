package day6;

/**
 * day 6 leetcode 641
 * @author changdp
 * @create 2020-03-11 12:13
 **/
public class MyCircularDeque {

        private int[] Deque = null;
        private int capacity = 0;
        private int front;
        private int rear;
        private int length;


        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            capacity += k;
            Deque = new int[capacity];
            front = 0;
            rear = 0;
            length = 0;

        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            front = (capacity + front - 1) % capacity;
            Deque[front] = value;
            length++;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            Deque[rear] = value;
            rear = (rear + 1) % capacity;
            length++;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            front = (front + 1) % capacity;
            length--;
            return true;

        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            rear = (capacity + rear - 1) % capacity;
            length--;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return Deque[front];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return Deque[(capacity + rear - 1) % capacity];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            if (length == 0) {
                return true;
            }
            return false;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            if (length == capacity) {
                return true;
            }
            return false;
        }

        public static void main(String[] args) {
            MyCircularDeque myCircularDeque = new MyCircularDeque(10);
            System.out.println(myCircularDeque.insertLast(1));
        }
}
