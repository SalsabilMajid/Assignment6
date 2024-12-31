import java.util.Scanner;
public class Q5 {
    public static void main(String[] args) {
                DoublyLinkedListQ5<String> l = new DoublyLinkedListQ5<>();
                Scanner in = new Scanner(System.in);
                int choice;

                while (true) {
                    System.out.println("1 add first 2 add last 3 remove First 4 remove last 5 size 6 is the list empty -1 exit");
                    System.out.print("Input your choice: ");
                    choice = in.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.print("Input your element: ");
                            l.addFirst(in.next());
                            System.out.println(l.first() + " was added");
                            break;

                        case 2:
                            System.out.print("Input your element: ");
                            l.addLast(in.next());
                            System.out.println(l.last() + " was added");
                            break;

                        case 3:
                            if (!l.isEmpty()) {
                                System.out.println(l.removeFirst() + " was removed");
                            } else {
                                System.out.println("List is empty, nothing to remove.");
                            }
                            break;

                        case 4:
                            if (!l.isEmpty()) {
                                System.out.println(l.removeLast() + " was removed");
                            } else {
                                System.out.println("List is empty, nothing to remove.");
                            }
                            break;

                        case 5:
                            System.out.println("The list size is " + l.size());
                            break;

                        case 6:
                            System.out.println("Is the list empty? " + l.isEmpty());
                            break;

                        case -1:
                            System.out.println("Exiting program...");
                            System.exit(0);
                            break;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }

                    // Print all elements in the list
                    System.out.print("Current list: ");
                    if (!l.isEmpty()) {
                        // Using a temporary list to iterate over and print elements without modifying the original list
                        DoublyLinkedList<String> tempList = new DoublyLinkedList<>();
                        while (!l.isEmpty()) {
                            String element = l.removeFirst();
                            tempList.addLast(element);
                            System.out.print(element + " ");
                        }

                        // Re-insert elements back to the original list
                        while (!tempList.isEmpty()) {
                            l.addLast(tempList.removeFirst());
                        }
                        System.out.println();
                    } else {
                        System.out.println("The list is empty.");
                    }
                }
            }
        }
