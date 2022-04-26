package inflearn.recursive_tree_graph;

import java.util.LinkedList;
import java.util.Queue;

/* 7.이진트리 순회(BFS: 레벨탐색)
1 ~ 7개의 이진트리를 통해 BFS 연습

출력
1: 1
2: 2 3
4: 4 5 6 7
 */
class Node07 {                          //노드 클래스 생성
    int data;                           //멤버 변수 data와 lt, rt가 있음
    Node07 lt, rt;

    public Node07(int val) {            //val을 매개변수로 한 생성자
        data = val;                     //data에는 val 대입
        lt = rt = null;                 //lt와 rt는 null로 초기화
    }
}
public class Recursive_Tree_Graph07 {
    Node07 root;                        //Node형 객체 root생성

    private void BFS(Node07 root) {
        Queue<Node07> Q = new LinkedList<>(); //큐 생성
        Q.offer(root);                  //큐에 매개변수 root를 offer
        int L = 0;                      //Level을 표시할 변수 L 선언 및 초기화

        while (!Q.isEmpty()) {          //큐가 빌 때까지 반복
            int len = Q.size();         //큐의 크기를 len 변수에 대입
            System.out.print(len + ": "); //현재 레벨을 출력

            for (int i = 0; i < len; i++) { //len 만큼 반복
                Node07 cul = Q.poll();      //Node형 변수 cul에 큐에서 poll한 값 대입
                System.out.print(cul.data + " "); //cul의 data값 출력

                if (cul.lt != null) {   //cul에 lt가 null이 아니면, 즉 하위 객체가 존재한다면
                    Q.offer(cul.lt);    //cul의 lt를 큐에 offer
                }
                if (cul.rt != null) {   //cul에 rt가 null이 아니면, 즉 하위 객체가 존재한다면
                    Q.offer(cul.rt);    //cul의 rt를 큐에 offer
                }
            }
            L++;                        //현재 레벨을 의미하는 L 증가
            System.out.println();       //개행
        }

    }

    public static void main(String[] args) {
        Recursive_Tree_Graph07 tree = new Recursive_Tree_Graph07();
        tree.root = new Node07(1);
        tree.root.lt = new Node07(2);
        tree.root.rt = new Node07(3);
        tree.root.lt.lt = new Node07(4);
        tree.root.lt.rt = new Node07(5);
        tree.root.rt.lt = new Node07(6);
        tree.root.rt.rt = new Node07(7);
        tree.BFS(tree.root);
    }
}
