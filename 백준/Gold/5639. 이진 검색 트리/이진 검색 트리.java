import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    // 노드 클래스: 각 노드는 정수 값을 가지고 왼쪽/오른쪽 자식 노드를 가질 수 있음
    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }
    }

    static Node root = null; // 트리의 루트 노드

    // 값 하나를 BST에 삽입하는 함수
    public static void insert(int value) {
        Node newNode = new Node(value); // 삽입할 새로운 노드 생성

        if (root == null) {
            root = newNode; // 루트가 없으면 첫 노드가 루트
            return;
        }

        Node curr = root; // 루트부터 시작하여 위치 찾기

        while (true) {
            if (value < curr.value) { // 왼쪽 서브트리
                if (curr.left == null) {
                    curr.left = newNode; // 왼쪽 자식 없으면 삽입
                    break;
                } else {
                    curr = curr.left; // 왼쪽 자식으로 내려감
                }
            } else { // 오른쪽 서브트리
                if (curr.right == null) {
                    curr.right = newNode;
                    break;
                } else {
                    curr = curr.right;
                }
            }
        }
    }

    // 후위 순회 (postorder): 왼 → 오 → 루트
    public static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }

    // 메인 함수: 입력 받고 트리 구성 후, 후위 순회 출력
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = br.readLine()) != null && !str.isEmpty()) {
            int val = Integer.parseInt(str);
            insert(val); // 트리에 삽입
        }

        postOrder(root); // 트리 후위 순회 출력
    }
}
