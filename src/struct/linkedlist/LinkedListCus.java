package struct.linkedlist;

import utils.Log;

public class LinkedListCus {


    private Node head;

    public LinkedListCus() {
        head = null;
    }

    /**
     * 添加方法，从尾部添加
     */
    public void insertNode(String data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = node;
        }
    }

    /**
     * 打印
     */
    private void printList() {
        Node tmp = head;
        while (tmp != null) {
            tmp.print();
            tmp = tmp.next;
        }
    }

    /**
     * 反转
     * prev断掉和pCur的连线，连接下一次需要反转的节点pCur.next
     * 反转节点pCur:pCur断掉和下一个的连线，连接dump.next
     * 纠正头结点dummy的指向:dump.next断掉和下一个的连线，连接pCur
     * pCur指向下一次要反转的节点:pre.next
     */
    private void reverseList() {
        if (head == null) return;

        Node dump = new Node("dump");
        dump.next = head;
        Node prev = dump.next;
        Node current = prev.next;
        while (current != null) {
            prev.next = current.next;
            current.next = dump.next;
            dump.next = current;
            current = prev.next;
        }
        head = dump.next;
    }


    private void reverseList2() {
        if (head == null || head.next == null) {
            return;
        }
        Node p1 = head;
        Node p2 = head.next;
        Node p3 = null;
        while (p2 != null){
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        head.next = null;
        head = p1;
    }

    private void reversePrint(Node node) {
        if (node == null) {
            return;
        } else {
            reversePrint(node.next);
            Log.log(node.data);
        }
    }

    private final class Node {
        public String data;
        public Node next = null;

        public Node(String data) {
            this.data = data;
        }

        public void print() {
            Log.log(data);
        }
    }

    public void test() {

    }

    public static void main(String[] args) {
        LinkedListCus linkedListCus = new LinkedListCus();
        linkedListCus.insertNode("xiaoming");
        linkedListCus.insertNode("jj");
        linkedListCus.insertNode("baolai");
        linkedListCus.insertNode("bl");
        linkedListCus.insertNode("abc");
        linkedListCus.printList();
        Log.log("---------------head:" + linkedListCus.head.data);
        linkedListCus.reverseList2();
//        linkedListCus.reversePrint(linkedListCus.head);
        linkedListCus.printList();
    }
}
