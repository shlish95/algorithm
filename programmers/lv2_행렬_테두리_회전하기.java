package programmers.dev_matching_웹_백엔드_개발자_2021상반기;

/* 행렬 테두리 회전하기
1부터 숫자를 rows * columns 크기의 행렬을 채워 넣은 다음 (x, y), (nx, ny)를 기준으로 직사각형 모양의 범위를 선택해
테두리 부분의 숫자를 시계 방향으로 회전 시킬 때, 회전 된 숫자들 중 가장 작은 값들을 출력하여라

rows	columns	queries	                                    result
6	    6	    [[2,2,5,4],[3,3,6,6],[5,1,6,3]]	            [8, 10, 25]
3	    3	    [[1,1,2,2],[1,2,2,3],[2,1,3,2],[2,2,3,3]]	[1, 1, 5, 3]
100	    97	    [[1,1,100,97]]	                            [1]
 */
public class lv2_행렬_테두리_회전하기 {
    static int[][] board;

    public static int spin(int x, int y, int nx, int ny) {  //직사각형 테두리를 지정할 좌표를 입력받아 실행
        int tmp = board[x][y];                          //(x, y) 값을 변수 tmp에 대입
        int min = tmp;                                  //최소값을 구할 변수 min에 tmp 대입

        for(int i = 1; i <= nx - x; i++) {              //(nx, y)부터 (x, y)까지 이동
            board[x + i - 1][y] = board[x + i][y];
            min = Math.min(min, board[x + i][y]);       //이동하며 각 좌표값과 min을 비교하여 더 작은 값 대입
        }

        for(int i = 1; i <= ny - y; i++) {              //(nx, ny)부터 (nx, y)까지 이동
            board[nx][y + i - 1] = board[nx][y + i];
            min = Math.min(min, board[nx][y + i]);      //이동하며 각 좌표값과 min을 비교하여 더 작은 값 대입
        }

        for(int i = 1; i <= nx - x; i++) {              //(x, ny)부터 (nx, ny)까지 이동
            board[nx - i + 1][ny] = board[nx - i][ny];
            min = Math.min(min, board[nx - i][ny]);     //이동하며 각 좌표값과 min을 비교하여 더 작은 값 대입
        }

        for(int i = 1; i < ny - y; i++) {               //(x, ny)부터 (x, y)까지 이동
            board[x][ny - i + 1] = board[x][ny - i];
            min = Math.min(min, board[x][ny - i]);      //이동하며 각 좌표값과 min을 비교하여 더 작은 값 대입
        }
        board[x][y + 1] = tmp;                          //(x, y+1)에 tmp값 대입

        return min;                                     //min 값 출력
    }

    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        int[] answer = new int[queries.length];     //정답을 출력할 배열 answer, queries의 크기만큼 설정
        board = new int[rows + 1][columns + 1];     //rows*columns 크기의 2차원 배열 board
        int cnt = 1;

        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= columns; j++) {
                board[i][j] = cnt++;                //board에 1부터 채워 넣어 줌
            }
        }

        for(int i = 0; i < queries.length; i++) {   //spin 메서드를 반복 실행한 결과를 answer에 대입
            answer[i] = spin(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        }

        for (int i = 0; i < answer.length; i++) {   //answer 출력
            System.out.print(answer[i] + " ");
        }
    }
}
