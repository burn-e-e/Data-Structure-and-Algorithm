import java.util.EmptyStackException;
import java.util.Scanner;

public class Lab3 {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node top;
    private Scanner sc = new Scanner(System.in);

    public void push(int value) {
        Node node = new Node(value);
        node.next = top;
        top = node;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void printStack() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            Node current = top;
            StringBuilder sb = new StringBuilder();
            while (current != null) {
                sb.insert(0, current.data + "\n");
                current = current.next;
            }
            System.out.print(sb.toString());
        }
    }

    public int size() {
        int size = 0;
        Node current = top;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public void inputStackFromArray(int[] arr) {
        for (int value : arr) {
            push(value);
        }
    }

    public void splitStack() {
        int size = size();
        int middle = size / 2;
        Lab3 firstHalf = new Lab3();
        Lab3 secondHalf = new Lab3();
        for (int i = 0; i < middle; i++) {
            firstHalf.push(pop());
        }
        while (!isEmpty()) {
            secondHalf.push(pop());
        }
        System.out.println("First Half:");
        firstHalf.printStack();
        System.out.println("Second Half:");
        secondHalf.printStack();
    }

    public void combineStack(Lab3 otherStack) {
        while (!otherStack.isEmpty()) {
            push(otherStack.pop());
        }
        printStack();
    }
}
