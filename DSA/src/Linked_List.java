import org.w3c.dom.Node;

import javax.print.DocFlavor;

public class Linked_List {
    private Node head;
    public boolean isEmpty(){
        return head == null;
    }
    public void insertFirst(char value){
        Node node  = new Node(value);
        node.next = head;
        head = node;
    }
    public void insertAfter(char predValue, char value){
        Node pred = head;
        while(pred != null && pred.data != predValue){
            pred = pred.next;
        }
        if (pred != null){
            Node node = new Node(value);
            node.next = pred.next;
            pred.next = node;
        }
    }
    public void insertLast(char value){
        if (isEmpty()){
            head = new Node(value);
            return;
        }
        Node pred = head;
        while (pred.next != null){
            pred = pred.next;
        }
        pred.next = new Node(value);
    }
    public Node deleteFirst(){
        if (isEmpty()){
            return null;
        }
        if (head.next == null){
            Node temp = head;
            head = null;
            return temp;
        }
        Node pred = head;
        Node temp = head.next;
        while (temp.next != null){
            pred = pred.next;
            temp = temp.next;
        }
        pred.next = null;
        return temp;
    }
    public Node deleteByValue(char value){
        if (isEmpty()){
            return null;
        }
        if (head.data == value){
            Node temp = head;
            head = head.next;
            return  temp;
        }
        Node pred = head;
        Node temp = head.next;
        while (temp != null && temp.data != value){
            pred = pred.next;
            temp = temp.next;
        }
        if (temp != null){
            pred.next = temp.next;
        }
        return temp;
    }
    public Node deleteLast(){
        if (isEmpty()){
            return null;
        }
        Node temp = head;
        head = head.next;
        return temp;
    }

    private static class Node{
        char data;
        Node next;
        Node(char data){
            this.data = data;
        }
}

}
