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
    private void reverseList(){
        if (head == null)return;

        Node dump = new Node("dump");
        dump.next = head;
        Node prev = dump.next;
        Node current = prev.next;
        while (current != null){
            prev.next = current.next;
            current.next = dump.next;
            dump.next = current;
            current = prev.next;
        }
        head = dump.next;
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
        LinkedListCus linkedListCus = new LinkedListCus();
        linkedListCus.insertNode("xiaoming");
        linkedListCus.insertNode("jj");
        linkedListCus.insertNode("baolai");
        linkedListCus.insertNode("bl");
        linkedListCus.insertNode("abc");
        linkedListCus.printList();
        Log.log("---------------");
        linkedListCus.reverseList();
        linkedListCus.printList();
    }

    public static void main(String[] args) {
        new LinkedListCus().test();
    }
}
