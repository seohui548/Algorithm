import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 
public class bj_7562{
    //����Ʈ�� �̵��� �� �ִ� �ڸ��� ����������.
    static int[] px = {-2,-2,-1,-1,1,1,2,2};
    static int[] py = {-1,1,-2,2,-2,2,-1,1};
    static int[][] map;
    static boolean[][] visit; // �湮���� Ȯ�ο�
    static int l; // ü���� ũ�� lxl
    static int start_x, start_y, end_x, end_y; // ����Ʈ ���� �ڸ�, ������ �ڸ�
    static int count = 0; // ���� �� �ɸ��� Ƚ�� 
    static Queue<point> q = new LinkedList<point>();
 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        //�׽�Ʈ ���̽� ��ŭ ���� - ���� ó������ ����
        int test = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=test; i++) {
        	//ü���� ���̽� ũ�� ����
            l = Integer.parseInt(br.readLine());
            map = new int[l][l];
            visit = new boolean[l][l];
            
            //��°�� ��°�� �߶� ��ǥ�ν�
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
        //�̸� �����ص� �������� �Ǹ� return���ش�.
//        if(p.x == end_x && p.y == end_y) {
//        	//System.out.println("����");
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
                    q.add(new point(x2,y2)); // �ڽ� �߰� - �� �� �ִ� �ٸ� ��
                    visit[x2][y2] = true; //�湮�ߴ�
                    //���� �̵� Ƚ���� +1 �� �����ָ� �̵� Ƚ���� ���������ش�.
                    map[x2][y2] = map[x1][y1] + 1;
                }
            }
        }
        
    }
 
}
 
//��ǥ ���� �׸�
class point {
    int x;
    int y;
    
    public point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
