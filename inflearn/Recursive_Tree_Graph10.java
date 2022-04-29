package inflearn.recursive_tree_graph;

import java.util.LinkedList;
import java.util.Queue;

/* Tree 말단 노드까지의 가장 짧은 경로(BFS)
루트 노드 1에서 말단 노드까지 가장 짧은 길이를 출력
 */
class Node10 {                             //노드 클래스 생성
    int data;
    Node10 lt, rt;

    public Node10(int val) {
        data = val;
        lt = rt = null;
    }
}
public class Recursive_Tree_Graph10 {
    Node10 root;

    private void BFS(Node10 root) {
        Queue<Node10> Q = new LinkedList<>(); //root 변수를 넣어줄 큐 생성 및 초기화
        Q.offer(root);                      //매개변수로 받은 root를 큐에 넣어줌
        int L = 0;                          //루트 노드부터의 거리인 Level을 표시할 변수 L 선언 및 초기화

        while (!Q.isEmpty()) {              //큐가 비기 전까지 반복
            int len = Q.size();             //len에 큐의 크기를 대입

            for (int i = 0; i < len; i++) { //0부터 큐의 크기만큼 반복
                Node10 cul = Q.poll();      //큐에서 꺼낸 변수를 cul에 대입

                if (cul.lt == null && cul.rt == null) { //cul의 lt, rt가 null이면, 즉 말단노드이면
                    System.out.println(L);              //L 출력
                    return;                             //반복 종료
                }

                if (cul.lt != null) {                   //null이 아니라면, 즉 자식이 있다면
                    Q.offer(cul.lt);                    //큐에 lt객체의 주소값 넣어줌
                }
                if (cul.rt != null) {                   //null이 아니라면, 즉 자식이 있다면
                    Q.offer(cul.rt);                    //큐에 rt객체의 주소값 넣어줌
                }
            }
            L++;                                        //현재 L의 모든 노드를 탐색했으므로
        }                                               //다음 L로 넘어가 탐색하는 것을 표현하기 위해 L증가
    }

    public static void main(String[] args) {
        Recursive_Tree_Graph10 tree = new Recursive_Tree_Graph10();
        tree.root = new Node10(1);
        tree.root.lt = new Node10(2);
        tree.root.rt = new Node10(3);
        tree.root.lt.lt = new Node10(4);
        tree.root.lt.rt = new Node10(5);
        tree.BFS(tree.root);
    }
}
