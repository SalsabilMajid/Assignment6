public class Q6 {
        public static void main(String[] args) {
            CircularDoublyLinkedList<String> list = new CircularDoublyLinkedList<>();
            list.addFirst("A");
            list.addLast("B");
            list.addLast("C");
            list.addLast("D");

            System.out.println("Original list: " + list);

            // Rotate the list forward
            list.rotate();
            System.out.println("After rotating forward: " + list);

            // Rotate the list backward
            list.rotateBackward();
            System.out.println("After rotating backward: " + list);

            // Removing elements
            list.removeFirst();
            System.out.println("After removing first: " + list);

            list.removeLast();
            System.out.println("After removing last: " + list);
        }
    }