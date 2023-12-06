import javax.print.DocFlavor;
import java.util.EmptyStackException;

public class Linked_List_Stack {
    private static class Node{
        int data; //11
        Node next;
        Node(int data){
            this.data = data; //11
        }
    }
    private Node top;
    public void push(int value){//11
        Node node = new Node(value);
        node.next = top; //null
        top = node;
    }
    public  int pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        int value = top.data;
        top = top.next;
        return value;
    }
    public int peek(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }
    public boolean isEmpty(){
        return top == null;
    }

    public static void main(String[] args) {
        Linked_List_Stack stack = new Linked_List_Stack();
        stack.push(4);
        stack.push(11);
        stack.push(99);
        stack.push(11);
        stack.pop();
        System.out.println(stack.peek());
    }
}
