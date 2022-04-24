package inflearn.recursive_tree_graph;

/* 5. 이진트리순회(DFS)
1 ~ 7 번의 이진트리를 전위순회, 중위순회, 후위순회 연습
 */
class Node {                    //노드객체 생성
    int data;                   //노드에는 data와 lt가지, rt가지 변수 존재
    Node lt, rt;

    public Node(int val) {      //정수형 매개변수를 가진 생성자
        data = val;             //매개변수를 data에 대입
        lt = rt = null;         //lt와 rt는 null로 초기화
    }
}
public class Recursive_Tree_Graph05 {
    Node root;                                      //Node형의 변수 root

    public void DFS(Node root) {                    //DFS 메서드 생성
        if (root == null) {                         //매개변수 값이 null이면 말단노드이므로
            return;                                 //매서드 중단

        } else {                                    //null이 아니라면 하위 노드가 있다는 것을 의미
//            System.out.print(root.data + " ");    //노드의 data를 먼저 출력하는 것은 전위순회를 의미
                                                    //전위순회: 1 2 3 4 5 6 7

            DFS(root.lt);                           //DFS 재귀호출을 통해 왼쪽 노드 생성
//            System.ot.print(root.data + " ");     //lt노드 생성 후 data를 출력하는 것은 중위순회
                                                    //중위순회: 4 2 5 1 6 3 7

            DFS(root.rt);                           //DFS 재귀호출을 통해 오른쪽 노드 생성
            System.out.print(root.data + " ");      //lt노드, rt노드 생성 후 data 출력은 후위순외
        }                                           //후위순회: 4 5 2 6 7 3 1
    }

    public static void main(String[] args) {
        Recursive_Tree_Graph05 tree = new Recursive_Tree_Graph05();
        tree.root = new Node(1);                //루트객체 생성, 매개변수로 1넣어줌
        tree.root.lt = new Node(2);             //루트객체에서 왼쪽에 매개변수 2를 가진 객체 생성
        tree.root.rt = new Node(3);             //오른쪽엔 3을 넣어 객체 생성
        tree.root.lt.lt = new Node(4);          //...
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);                        //루트 객체인 tree.root를 매개변수로
    }                                               //DFS 매서드 호출
}
