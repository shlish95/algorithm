package inflearn.recursive_tree_graph;

/* 9.Tree 말단노드까지의 가장 짧은 경로(DFS)
루트 노드 1에서 말단 노드까지 가장 짧은 길이를 출력
 */
class Node09 {                             //노드 클래스 생성
    int data;
    Node09 lt, rt;

    public Node09(int val) {
        data = val;
        lt = rt = null;
    }
}
public class Recursive_Tree_Graph09 {
    Node09 root;

    private int DFS(int L, Node09 root) {   //이동 횟수를 구해야 하므로 매개변수로 Level 입력
        if (root.lt == null && root.rt == null) { //Node 객체의 lt와 rt가 null, 즉 말단노드이면
            return L;                             //L 반환
        } else {                                  //lt와 rt가 null이 아니라면
            return Math.min(DFS(L + 1, root.lt), DFS(L + 1, root.rt));
        }                                         //재귀호출을 통해 lt객체와 rt객체 반환 값을 구한 뒤
    }                                             //min 매서드로 더 작은값 반환

    public static void main(String[] args) {
        Recursive_Tree_Graph09 tree = new Recursive_Tree_Graph09();
        tree.root = new Node09(1);
        tree.root.lt = new Node09(2);
        tree.root.rt = new Node09(3);
        tree.root.lt.lt = new Node09(4);
        tree.root.lt.rt = new Node09(5);
        System.out.println(tree.DFS(0, tree.root));
    }
}
