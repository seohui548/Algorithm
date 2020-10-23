import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 
public class bj_7562{
    //나이트가 이동할 수 있는 자리는 정해져있음.
    static int[] px = {-2,-2,-1,-1,1,1,2,2};
    static int[] py = {-1,1,-2,2,-2,2,-1,1};
    static int[][] map;
    static boolean[][] visit; // 방문여부 확인용
    static int l; // 체스판 크기 lxl
    static int start_x, start_y, end_x, end_y; // 나이트 현재 자리, 가야할 자리
    static int count = 0; // 가는 데 걸리는 횟수 
    static Queue<point> q = new LinkedList<point>();
 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        //테스트 케이스 만큼 돈다 - 가장 처음에만 나옴
        int test = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=test; i++) {
        	//체스판 케이스 크기 설정
            l = Integer.parseInt(br.readLine());
            map = new int[l][l];
            visit = new boolean[l][l];
            
            //둘째줄 셋째줄 잘라서 좌표인식
            StringTokenizer st = new StringTokenizer(br.readLine());
            start_x = Integer.parseInt(st.nextToken());
            start_y = Integer.parseInt(st.nextToken());
            
 
            st = new StringTokenizer(br.readLine());
            end_x = Integer.parseInt(st.nextToken());
            end_y = Integer.parseInt(st.nextToken());
            
            bfs(new point(start_x, start_y));

           
            System.out.println(map[end_x][end_y]);
            	
           //System.out.println("0");
        }
        
    }
    
    static void bfs(point p) {
        //미리 설정해둔 도착지가 되면 return해준다.
//        if(p.x == end_x && p.y == end_y) {
//        	//System.out.println("도착");
//            return;
//        }
        visit[p.x][p.y] = true;
        
        q.add(p);
        
        while(!q.isEmpty()) {
            point test = q.poll();
            int x1 = test.x;
            int y1 = test.y;
            
            for(int i=0; i<px.length; i++) {
                int x2 = x1 + px[i];
                int y2 = y1 + py[i];
                
                if(x2>=0 && x2<l && y2>=0 && y2<l && !visit[x2][y2]) {
                    q.add(new point(x2,y2)); // 자식 추가 - 갈 수 있는 다른 길
                    visit[x2][y2] = true; //방문했다
                    //전의 이동 횟수에 +1 씩 더해주며 이동 횟수를 증가시켜준다.
                    map[x2][y2] = map[x1][y1] + 1;
                }
            }
        }
        
    }
 
}
 
//좌표 담을 그릇
class point {
    int x;
    int y;
    
    public point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
