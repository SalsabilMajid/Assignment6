public class DoublyLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }

    //Q2
    public int sizeQ2() {
        int count = 0;
        Node<E> current = header.getNext();


        while (current != trailer) {
            count++;
            current = current.getNext();
        }

        return count;
    }

    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();
    }

    private void addBetween(E e, Node<E> p, Node<E> n) {
        Node<E> newest = new Node<>(e, p, n);
        p.setNext(newest);
        n.setPrev(newest);
        size++;
    }

    public void addFirst(E e) {
        addBetween(e, header, header.next);
    }

    public void addLast(E e) {
        addBetween(e, trailer.prev, trailer);
    }

    private E remove(Node<E> x) {
        Node<E> p = x.prev;
        Node<E> n = x.next;
        p.setNext(n);
        n.setPrev(p);
        size--;
        return x.element;
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(header.next);

    }

    public E removeLast() {
        if (isEmpty()) return null;
        return remove(trailer.prev);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // إذا كانت القائمتان نفس الكائن
        if (o == null || getClass() != o.getClass()) return false; // إذا كان الكائن null أو ليس من نفس النوع

        DoublyLinkedList<?> other = (DoublyLinkedList<?>) o;

        if (this.size != other.size) return false; // إذا كان حجم القائمتين مختلفًا

        Node<E> thisNode = this.header.getNext(); // البداية من أول عنصر بعد الحارس
        Node<?> otherNode = other.header.getNext();

        while (thisNode != this.trailer) { // التكرار حتى الوصول إلى الحارس الذّيلي
            if (!java.util.Objects.equals(thisNode.getElement(), otherNode.getElement())) {
                return false; // إذا كان هناك عنصر مختلف
            }
            thisNode = thisNode.getNext();
            otherNode = otherNode.getNext();
        }

        return true; // جميع العناصر متساوية
    }

    // Clone method
    public DoublyLinkedList<E> clone() {
        DoublyLinkedList<E> newList = new DoublyLinkedList<>();  // إنشاء قائمة جديدة فارغة
        Node<E> current = this.header.getNext();  // البداية من أول عنصر بعد الرأس

        // التكرار عبر العقد
        while (current != this.trailer) {  // التكرار حتى الوصول إلى العقدة الحارسية
            newList.addLast(current.getElement());  // إضافة العنصر إلى القائمة الجديدة
            current = current.getNext();  // الانتقال إلى العنصر التالي
        }

        return newList;  // إرجاع القائمة الجديدة المنسوخة
    }
    public void printList() {
        Node<E> current = header.getNext();
        while (current != trailer) {
            System.out.print(current.getElement() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

}

