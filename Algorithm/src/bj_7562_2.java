import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_7562_2{
	static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dc = {1, 2, 2, 1,-1, -2, -2, -1};
	
	static int Tc, I, answer ;
	static int[][] map ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Point> queue = new LinkedList<>();
		
		Tc = sc.nextInt();
		
		for ( int tc =0 ; tc < Tc; tc++) {
			I = sc.nextInt();
			
			map = new int[I][I];
			Point start = new Point(sc.nextInt(), sc.nextInt()); // ��������
			Point end = new Point(sc.nextInt(), sc.nextInt()); // ��������
			
			map[start.x][start.y] = 1; // �湮 ǥ��
			queue.add(new Point(start.x,start.y));
			
			
			L : while ( true) {
				int queuesize = queue.size();
				if ( queuesize ==0 ) break;
				int n=0;
				while( n++ < queuesize) {
					Point Cur = queue.poll();
					
					if ( Cur.x == end.x && Cur.y == end.y) break L; // ������ ����
					
					for ( int d=0; d<8; d++) {
						int nr = Cur.x + dr[d];
						int nc = Cur.y + dc[d];
						
						if ( nr < 0 || nr >= I || nc < 0 || nc >= I || map[nr][nc] == 1) continue; // boundary check , �̹� �湮�� ���̸�
						
						map[nr][nc] = 1; // �湮ó�� �Ŀ� 
						queue.add(new Point(nr,nc)); // ť�� ���� 
						
					}
					
				}
				answer ++;
			}
			
			
			System.out.println(answer);
			answer =0;
			queue.clear();
		}
	}
}