package liurui.questions;

import java.util.Stack;

/***
 * 使用两个栈实现队列功能
 */
public class QueueUsingDoubleStack {
    Stack<Integer> a = new Stack<>();
    Stack<Integer> b = new Stack<>();

    public void push(int data) {
        a.push(data);
    }

    public int getSize() {
        return a.size() + b.size();
    }

    public boolean empty() {
        return a.empty() && b.empty();
    }

    public int pop() {
        if (empty()) throw new IndexOutOfBoundsException();

        if (b.empty()) {
            while (!a.empty()) {
                b.push(a.pop());
            }
        }
        return b.pop();
    }
}
