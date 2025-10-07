import java.io.*;
import java.util.*;

class Node{
    char left, right;

    Node(char left, char right){
        this.left = left;
        this.right = right;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Character, Node> tree = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.put(parent, new Node(left, right));
        }

        StringBuilder sb = new StringBuilder();

        preorder('A', tree, sb);
        sb.append("\n");
        inorder('A', tree, sb);
        sb.append("\n");
        postorder('A', tree, sb);
        sb.append("\n");

        System.out.println(sb);
    }

    public static void preorder(char current, Map<Character, Node> tree, StringBuilder sb){
        if(current == '.') return;

        Node curNode = tree.get(current);
        char left = curNode.left;
        char right = curNode.right;

        sb.append(current);
        preorder(left, tree, sb);
        preorder(right, tree, sb);
    }

    public static void inorder(char current, Map<Character, Node> tree, StringBuilder sb){
        if(current == '.') return;

        Node curNode = tree.get(current);
        char left = curNode.left;
        char right = curNode.right;

        inorder(left, tree, sb);
        sb.append(current);
        inorder(right, tree, sb);
    }

    public static void postorder(char current, Map<Character, Node> tree, StringBuilder sb){
        if(current == '.') return;

        Node curNode = tree.get(current);
        char left = curNode.left;
        char right = curNode.right;

        postorder(left, tree, sb);
        postorder(right, tree, sb);
        sb.append(current);
    }
}