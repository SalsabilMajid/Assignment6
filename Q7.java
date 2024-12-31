public class Q7 {
        public static void main(String[] args) {
            // إنشاء قائمة مزدوجة جديدة
            DoublyLinkedList<Integer> originalList = new DoublyLinkedList<>();

            // إضافة بعض العناصر إلى القائمة الأصلية
            originalList.addLast(10);
            originalList.addLast(20);
            originalList.addLast(30);

            // نسخ القائمة باستخدام دالة clone
            DoublyLinkedList<Integer> clonedList = originalList.clone();

            // طباعة العناصر في القائمة الأصلية
            System.out.println("Original List:");
            originalList.printList();

            // طباعة العناصر في القائمة المنسوخة
            System.out.println("Cloned List:");
            clonedList.printList();
        }
    }
