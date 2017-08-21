package liurui.v1.Questions;

import java.util.LinkedList;
import java.util.Queue;

/***
 * 使用两个队列实现栈功能
 */
public class StackUsingDoubleQueue {

    Queue<Integer> a = new LinkedList<>();
    Queue<Integer> b = new LinkedList<>();

    public void push(int data) {
        if (a.isEmpty())
            b.add(data);
        else
            a.add(data);
    }

    public int pop() {
        if (isEmpty()) throw new IndexOutOfBoundsException();

        return a.isEmpty() ? pop(b, a) : pop(a, b);
    }

    private int pop(Queue<Integer> first, Queue<Integer> second) {
        while (first.size() != 1) {
            second.add(first.poll());
        }
        return first.poll();
    }

    public int getSize() {
        return a.size() + b.size();
    }

    public boolean isEmpty() {
        return a.isEmpty() && b.isEmpty();
    }

}
