package struct.tree;

import utils.Log;

public class BinaryTreeTest {
    public static void main(String[] args) {
//        new BinaryTreeTest().tst();
//        new BinaryTreeTest().recursion(2);
        Log.log(new BinaryTreeTest().recursion2(5));
    }

    private void tst() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertData(40);
        binaryTree.insertData(30);
        binaryTree.insertData(22);
        binaryTree.insertData(35);
        binaryTree.insertData(37);
        binaryTree.insertData(50);
        binaryTree.insertData(58);
        binaryTree.insertData(46);
        binaryTree.insertData(61);

        binaryTree.frontOrder(binaryTree.root);

        Log.log("min1:" + binaryTree.findMin().data);
        Log.log("min2:" + binaryTree.findMin2(binaryTree.root).data);
    }

    private void recursion(int depth) {
        Log.log("depth:" + depth + " 抱着");
        if (depth == 0) {
            Log.log("我的小鲤鱼");
        } else {
            recursion(--depth);
        }
        Log.log("depth:" + depth + " 的我");
    }

    private int recursion2(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * recursion2(n - 1);
        }
    }

    private final class BinaryTree {

        /**
         * 根节点
         */
        public Node root;

        public BinaryTree() {

        }

        public void insertData(int value) {
            Node newData = new Node(value);
            if (root == null) {
                root = newData;
                return;
            }

            /**
             * 引用当前节点
             */
            Node current = root;

            /**
             * 引用父节点
             */
            Node parent;
            while (true) {
                parent = current;
                if (value < current.data) {
                    current = current.leftNode; //current向左走
                    if (current == null) { //如果左节点为空，那么插入
                        parent.leftNode = newData;
                        break;
                    }
                } else {
                    current = current.rightNode;  //current 向右走
                    if (current == null) { //如果右节点为空，那么插入
                        parent.rightNode = newData;
                        break;
                    }
                }
            }
        }


        public Node find(int value) {
            Node currentNode = root;
            while (currentNode != null) {
                if (value < currentNode.data) {
                    currentNode = currentNode.leftNode;
                } else if (value > currentNode.data) {
                    currentNode = currentNode.rightNode;
                } else {
                    return currentNode;
                }
            }
            return null;
        }

        public Node findMin() {
            if (root == null) {
                return null;
            }
            Node currentNode = root;
            while (currentNode.leftNode != null) {
                currentNode = currentNode.leftNode;
            }
            return currentNode;
        }

        /**
         * 递归找到currentNode的最小值
         *
         * @param currentNode
         * @return
         */
        public Node findMin2(Node currentNode) {
            if (currentNode == null) {
                return null;
            } else if (currentNode.leftNode == null) {
                return currentNode;
            } else {
                return findMin2(currentNode.leftNode);
            }
        }

        /**
         * 前序遍历
         */
        public void frontOrder(Node treeNode) {
            if (treeNode == null) return;
            Log.log(treeNode.data);
            frontOrder(treeNode.leftNode);
            frontOrder(treeNode.rightNode);
        }

        /**
         * 中序遍历
         */
        public void interOrder(Node treeNode) {
            if (treeNode == null) return;
            interOrder(treeNode.leftNode);
            Log.log(treeNode.data);
            interOrder(treeNode.rightNode);
        }

        /**
         * 后续遍历
         */
        public void afterOrder(Node treeNode) {
            if (treeNode == null) return;
            afterOrder(treeNode.leftNode);
            afterOrder(treeNode.rightNode);
            Log.log(treeNode.data);
        }

        /**
         * delete
         */
        public void delete(int value) {
            //先搜索

        }
    }

    private final class Node {
        public int data;
        public Node leftNode;
        public Node rightNode;

        public Node(int data) {
            this.data = data;
        }
    }
}
