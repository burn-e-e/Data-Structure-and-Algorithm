import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.HashMap;

public class Main extends Lab3 {

    private HashTable hashTable;
    public Main() {
        hashTable = new HashTable();
    }
    public static void main(String[] args) {
        Main mainProgram = new Main();
        mainProgram.runMenu();
    }

    private void runMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Lab 1");
            System.out.println("2. Lab 2");
            System.out.println("3. Stack");
            System.out.println("4. Hash Table");
            System.out.println("5. Lab 4");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Implement Lab 1 functionality
                    break;
                case 2:
                    // Implement Lab 2 functionality
                    break;
                case 3:
                    runLab3Menu();
                    break;
                case 4:
                    runHashTableMenu();
                    break;
                case 5:
                    // Implement Lab 4 functionality
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
    private void runHashTableMenu() {
        Scanner sc = new Scanner(System.in);
        int hashTableChoice;

        do {
            System.out.println("\nHash Table Menu:");
            System.out.println("1. Get");
            System.out.println("2. Put");
            System.out.println("3. Update Element");
            System.out.println("4. Update Key");
            System.out.println("5. Delete");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");

            hashTableChoice = sc.nextInt();

            switch (hashTableChoice) {
                case 1:
                    System.out.print("Enter key to get: ");
                    Object getKey = sc.next();
                    Object getValue = hashTable.get(getKey);
                    System.out.println("Value: " + getValue);
                    break;
                case 2:
                    System.out.print("Enter key: ");
                    Object putKey = sc.next();
                    System.out.print("Enter value: ");
                    Object putValue = sc.next();
                    hashTable.put(putKey, putValue);
                    System.out.println("Key-Value pair added to Hash Table.");
                    break;
                case 3:
                    System.out.print("Enter key to update element: ");
                    Object updateElementKey = sc.next();
                    System.out.print("Enter new element: ");
                    Object newElement = sc.next();
                    Object updatedElement = hashTable.updateElement(updateElementKey, newElement);
                    if (updatedElement != null) {
                        System.out.println("Element updated. Previous element: " + updatedElement);
                    } else {
                        System.out.println("Key not found. Cannot update element.");
                    }
                    break;

                case 4:
                    System.out.print("Enter key to update: ");
                    Object updateKey = sc.next();
                    System.out.print("Enter new key: ");
                    Object newKey = sc.next();
                    Object updatedKey = hashTable.updateKey(updateKey, newKey);
                    if (updatedKey != null) {
                        System.out.println("Key updated. Associated value: " + hashTable.get(newKey));
                    } else {
                        System.out.println("Key not found. Cannot update key.");
                    }
                    break;

                case 5:
                    System.out.print("Enter key to delete: ");
                    Object deleteKey = sc.next();
                    Object deletedElement = hashTable;
                    if (deletedElement != null) {
                        System.out.println("Key-Value pair deleted. Value: " + deletedElement);
                    } else {
                        System.out.println("Key not found. Cannot delete.");
                    }
                    break;

                case 0:
                    System.out.println("Returning to Main Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (hashTableChoice != 0);
    }

    private void runLab3Menu() {
        Scanner sc = new Scanner(System.in);
        Lab3 lab3 = new Lab3();
        int lab3Choice;

        do {
            System.out.println("\nLab 3 Menu:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Print Stack");
            System.out.println("5. Split Stack");
            System.out.println("6. Combine with Another Stack");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");

            lab3Choice = sc.nextInt();

            switch (lab3Choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int value = sc.nextInt();
                    lab3.push(value);
                    break;
                case 2:
                    try {
                        int poppedValue = lab3.pop();
                        System.out.println("Popped value: " + poppedValue);
                    } catch (EmptyStackException e) {
                        System.out.println("Stack is empty. Cannot pop.");
                    }
                    break;
                case 3:
                    try {
                        int peekedValue = lab3.peek();
                        System.out.println("Peeked value: " + peekedValue);
                    } catch (EmptyStackException e) {
                        System.out.println("Stack is empty. Cannot peek.");
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Current Stack:");
                        lab3.printStack();
                    } catch (EmptyStackException e) {
                        System.out.println("Stack is empty.");
                    }
                    break;
                case 5:
                    try {
                        lab3.splitStack();
                    } catch (EmptyStackException e) {
                        System.out.println("Stack is empty. Cannot split.");
                    }
                    break;
                case 6:
                    try {
                        System.out.println("Enter values for the other stack (space-separated): ");
                        String input = sc.nextLine();
                        String[] values = input.split(" ");
                        int[] intValues = new int[values.length];
                        for (int i = 0; i < values.length; i++) {
                            intValues[i] = Integer.parseInt(values[i]);
                        }
                        Lab3 otherStack = new Lab3();
                        otherStack.inputStackFromArray(intValues);
                        lab3.combineStack(otherStack);
                    } catch (EmptyStackException e) {
                        System.out.println("Stack is empty. Cannot combine.");
                    }
                    break;
                case 0:
                    System.out.println("Returning to Main Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (lab3Choice != 0);
    }
}
