import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        DoublyLinkedList<String>l= new DoublyLinkedList<>();
        Scanner in= new Scanner(System.in);
        int choice;
        while (true){
            System.out.println("1 add first 2 add last 3 remove First 4 remove last 5 size 6 is the list empty -1 exit");
            System.out.println("input your choice: ");
            choice= in.nextInt();
            switch (choice)
            {
                case  1:
                    System.out.println("input your element: ");
                    l.addFirst(in.next());
                    System.out.println(l.first()+" was added");
                    break;
                case  2:
                    System.out.println("input your element: ");
                    l.addLast(in.next());
                    System.out.println(l.last()+" was added");
                    break;
                case 3:
                    System.out.println(l.removeFirst()+ " was removed");
                    break;
                case 4:
                    System.out.println(l.removeLast()+ " was removed");
                    break;
                case 5:
                    System.out.println("the list size is "+l.sizeQ2());
                    break;
                case 6:
                    System.out.println("Is the list empty? "+l.isEmpty());
                    break;
                case -1:
                    System.exit(0);


            }

            for (int i = 0; i <l.size() ; i++) {
                System.out.print(l.first()+" ");
                l.addLast(l.removeFirst());
            }
            System.out.println();
        }
    }
}

