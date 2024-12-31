public class DoublyLinkedListQ5<E> {
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

    private Node<E> sentinel;  // عقدة حارس واحدة
    private int size;

    public DoublyLinkedListQ5() {
        sentinel = new Node<>(null, null, null);  // عقدة حارس مع بداية ونهاية متصلتين ببعض
        sentinel.setNext(sentinel);  // الحافة الأولي
        sentinel.setPrev(sentinel);  // الحافة الثانية
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) return null;
        return sentinel.getNext().getElement();  // العنصر الأول بعد الحارس
    }

    public E last() {
        if (isEmpty()) return null;
        return sentinel.getPrev().getElement();  // العنصر الأخير قبل الحارس
    }

    // إضافة عنصر بين عقدتين معينتين
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    // إضافة عنصر في البداية
    public void addFirst(E e) {
        addBetween(e, sentinel, sentinel.getNext());
    }

    // إضافة عنصر في النهاية
    public void addLast(E e) {
        addBetween(e, sentinel.getPrev(), sentinel);
    }

    // إزالة عقدة معينة
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    // إزالة العنصر الأول
    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(sentinel.getNext());
    }

    // إزالة العنصر الأخير
    public E removeLast() {
        if (isEmpty()) return null;
        return remove(sentinel.getPrev());
    }


}

