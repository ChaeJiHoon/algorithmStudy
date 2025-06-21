package tree;
// 백준 | 트리 | 실버 1
// 1991 번 : 트리 순회
// 시간 제한 : 2초, 메모리 제한 : 128 MB
// 25.06.07
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class TreeTraversal {

    static class Node{
        char value;
        Node left;
        Node right;

        public Node(char value){
            this.value = value;
        }
    }
    static HashMap<Character,Node> tree = new HashMap<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.putIfAbsent(parent,new Node(parent));

            Node parentNode = tree.get(parent);

            if(left != '.'){
                tree.putIfAbsent(left, new Node(left));
                parentNode.left = tree.get(left);
            }
            if(right != '.'){
                tree.putIfAbsent(right, new Node(right));
                parentNode.right = tree.get(right);
            }
        }

        Node root = tree.get('A');

        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();

    }


    // 전위 순회: 루트 → 왼쪽 → 오른쪽
    static void preorder(Node node){
        if(node == null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위 순회: 왼쪽 → 루트 → 오른쪽
    static void inorder(Node node){
        if(node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    // 후위 순회: 왼쪽 → 오른쪽 → 루트
    static void postorder(Node node){
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }
}
