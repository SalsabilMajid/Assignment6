public class Q3 {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> list2 = new DoublyLinkedList<>();

        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);

        list2.addLast(1);
        list2.addLast(2);
        list2.addLast(3);

        System.out.println(list1.equals(list2)); // Output: true

        list2.addLast(4);
        System.out.println(list1.equals(list2)); // Output: false

    }
}
