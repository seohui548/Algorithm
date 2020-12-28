package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_14620 {
    static int N;  //화단의 한 변의 길이 N(6≤N≤10)
    static int[][] cost; //비용 
    static int min = Integer.MAX_VALUE; //최대값으로 초기화 
    static boolean[][] visit; //방문여부 
    //위아래 양옆 
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    /*
     * 일단 1. 외곽 테두리는 생각 안함 -> 꽃 피면 화단 사이즈 벗어남 
     * 그리고 2. 위아래 양옆 둘러싸는 칸은 불가능
     */
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        cost = new int[N][N];
        visit = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer  st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        seedprogram(0,0,1);
        System.out.println(min);
    }
    
    static void seedprogram(int cnt, int sum, int x) {
        if(cnt == 3) {
            min = Math.min(min, sum); // 합친 내용과 이때까지 저장한 최소값 비교
            return;
        }
        
        //화단 외곽 처리 안함 = N-1
        for (int i = x; i < N-1; i++) {
            for (int j = 1; j < N-1; j++) {
                if(visit[i][j]) //방문 했으면 통과
                    continue;
                if(!available(i, j)) //불가능 자리면 통과
                    continue;
              
                int c = cost[i][j];
                visit[i][j] = true;
                
                //꽃피는 자리 돌면서 비용더해주고 방문처리해줌
                for (int k = 0; k < 4; k++) {
                    visit[i+dx[k]][j+dy[k]] = true;
                    c += cost[i+dx[k]][j+dy[k]];
                }
                seedprogram(cnt+1, sum +c, i); //재귀
                
                visit[i][j] = false;
                for (int k = 0; k < 4; k++) {
                    visit[i+dx[k]][j+dy[k]] = false;
                }
            }
        }
    }
    
    static boolean available(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(x < 0 ||  x >= N || y < 0 || y >= N || visit[nx][ny])
                return false;
        }
        return true;
    }
}