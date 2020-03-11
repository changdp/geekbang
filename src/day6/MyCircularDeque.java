package day6;

/**
 * day 6 leetcode 641
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 *
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 * 示例：
 *
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);			        // 返回 true
 * circularDeque.insertLast(2);			        // 返回 true
 * circularDeque.insertFront(3);			        // 返回 true
 * circularDeque.insertFront(4);			        // 已经满了，返回 false
 * circularDeque.getRear();  				// 返回 2
 * circularDeque.isFull();				        // 返回 true
 * circularDeque.deleteLast();			        // 返回 true
 * circularDeque.insertFront(4);			        // 返回 true
 * circularDeque.getFront();				// 返回 4
 *  
 *  
 *
 * 提示：
 *
 * 所有值的范围为 [1, 1000]
 * 操作次数的范围为 [1, 1000]
 * 请不要使用内置的双端队列库。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-circular-deque
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
