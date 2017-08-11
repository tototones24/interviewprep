import java.util.*;
public class MyStack<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop() {
        if (top == null) {
            System.out.println("The stack is empty");
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
    }

    public T peek() {
        if (top == null) {
            System.out.println("Stack is empty");
        }
        System.out.println(top.data);
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<Integer>();
        stack.push(9);
        
        stack.push(10);
        stack.push(12);
        stack.pop();
        stack.peek();

    }


}