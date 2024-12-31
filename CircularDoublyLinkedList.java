
    public class CircularDoublyLinkedList<E> {
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

        private Node<E> head;
        private int size;

        public CircularDoublyLinkedList() {
            head = null;
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
            return head.getElement();
        }

        public E last() {
            if (isEmpty()) return null;
            return head.getPrev().getElement();
        }

        public void addFirst(E e) {
            Node<E> newNode = new Node<>(e, null, null);
            if (isEmpty()) {
                newNode.setNext(newNode);
                newNode.setPrev(newNode);
                head = newNode;
            } else {
                Node<E> oldHead = head;
                newNode.setNext(oldHead);
                newNode.setPrev(oldHead.getPrev());
                oldHead.getPrev().setNext(newNode);
                oldHead.setPrev(newNode);
                head = newNode;
            }
            size++;
        }

        public void addLast(E e) {
            Node<E> newNode = new Node<>(e, null, null);
            if (isEmpty()) {
                newNode.setNext(newNode);
                newNode.setPrev(newNode);
                head = newNode;
            } else {
                Node<E> oldTail = head.getPrev();
                newNode.setPrev(oldTail);
                newNode.setNext(head);
                oldTail.setNext(newNode);
                head.setPrev(newNode);
            }
            size++;
        }

        public E removeFirst() {
            if (isEmpty()) return null;
            Node<E> oldHead = head;
            if (size == 1) {
                head = null;
            } else {
                Node<E> tail = head.getPrev();
                head = head.getNext();
                tail.setNext(head);
                head.setPrev(tail);
            }
            size--;
            return oldHead.getElement();
        }

        public E removeLast() {
            if (isEmpty()) return null;
            Node<E> oldTail = head.getPrev();
            if (size == 1) {
                head = null;
            } else {
                Node<E> secondLast = oldTail.getPrev();
                secondLast.setNext(head);
                head.setPrev(secondLast);
            }
            size--;
            return oldTail.getElement();
        }

        public void rotate() {
            if (size > 1) {
                head = head.getNext(); // Move head to the next node
            }
        }

        public void rotateBackward() {
            if (size > 1) {
                head = head.getPrev(); // Move head to the previous node
            }
        }

        @Override
        public String toString() {
            if (isEmpty()) return "[]";
            StringBuilder sb = new StringBuilder();
            Node<E> current = head;
            sb.append("[");
            for (int i = 0; i < size; i++) {
                sb.append(current.getElement());
                if (i < size - 1) sb.append(", ");
                current = current.getNext();
            }
            sb.append("]");
            return sb.toString();
        }
    }

