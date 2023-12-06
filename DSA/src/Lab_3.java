import java.util.EmptyStackException;
import java.util.Scanner;

public class Lab_3 {
    Scanner sc = new Scanner(System.in);
    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    private Node top;

    public void push(int value){
        Node node = new Node(value);
        node.next = top;
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

      Lab_3 c = new Lab_3();
      c.push(1);
        c.push(2);
        c.push(3);
        System.out.println(c.size());
        c.printStack();
        Lab_3 d = new Lab_3();
        int[] arr = {3,4,5,6};
        d.inputStack(arr);
        d.printStack();
        System.out.println("Combine");
        d.combineStack(c);
        Lab_3 b = new Lab_3();
        b.push(13);
        b.push(11);
        b.push(9);
        b.push(3);
        b.combineStack(c);

    }
    public void printStack(){
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            Node current = top;
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }
    }
    public int size(){
        int size = 0;
        Node current = top;
        while(current != null){
            size++;
            current = current.next;
        }
        return size;
    }
    public void inputStack(int[] arr){
        for (int i:arr){
            this.push(i);
        }
    }
    public void splitStack(){
        int size = this.size();
        int middle = size / 2 ;
        Lab_3 firstHalf = new Lab_3();
        Lab_3 secondHalf = new Lab_3();
        for(int i = 0; i < middle; i++){
            firstHalf.push(this.pop());
        }
        while(!this.isEmpty()){
            secondHalf.push(this.pop());
        }
        System.out.println("Ehnii huvaagdal");
        firstHalf.printStack();
        System.out.println("Daraagiin huvaagdal");
        secondHalf.printStack();
    }
    public void combineStack(Lab_3 a){
        Lab_3 combinedStack = new Lab_3();
        while (!a.isEmpty()) {
            combinedStack.push(a.pop());
        }
        while (!this.isEmpty()) {
            combinedStack.push(this.pop());
        }
        combinedStack.printStack();
    }
}
