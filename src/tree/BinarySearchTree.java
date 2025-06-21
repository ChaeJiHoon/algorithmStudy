package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class BinarySearchTree {

    // 노드를 저장하는 중첩 클래스
    static class Node {
        int value;
        Node left, right;

        public Node(int value) {this.value = value;}
    }

    // 루트 노드
    static Node root = null;

    // 이진 탐색 트리를 복원하는 함수
    public static void insert(int value) {
        Node newNode = new Node(value);

        // 루트가 비어 있다면
        if (root==null) {
            root = newNode;
            return;
        }

        // 루트부터 탐색 시작
        Node curr = root;
        while(true){
            // 들어 온 값이 현재 노드보다 작으면 왼쪽으로
            if(value<curr.value) {
                if(curr.left==null){        // 비어 있으면 삽입
                    curr.left = newNode;
                    break;
                }else curr=curr.left;       // 오른쪽 자식으로 내려감

            }else{// 들어 온 값이 현재 노드보다 크면 오른쪽으로
                if(curr.right==null) {      // 비어 있으면 삽입
                    curr.right=newNode;
                    break;
                }else curr = curr.right;    // 오른쪽 자식으로 내려감
            }
        }
    }

    public static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = br.readLine()) != null && !str.isEmpty()) {
            int val = Integer.parseInt(str);
            insert(val);
        }

        postOrder(root);
    }
}
