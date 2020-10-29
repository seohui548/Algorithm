import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


// Queue에 들어갈 기준점이 필요

public class bj_3184 {

	static int r;
	static int c;
	static char map[][];
	static int visit[][];
	
	static Queue<Area> location;
	
	static int total_sheep = 0;
	static int total_wolf = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		r = sc.nextInt();
		c = sc.nextInt();
		
		map = new char[r][c];
		visit = new int[r][c];
		location = new LinkedList<>();
		
		for(int i=0;i<r;i++) {
			String str = sc.next();
			for(int j=0;j<c;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		//이동 가능 부분
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j] != '#' && visit[i][j] == 0) { 
					BFS(i, j);
				}
			}
		}
		
		
		System.out.println(total_sheep+" "+total_wolf); 
	}
	/*
    . : 빈 공간
    # : 울타리
    o : 양
    v : 늑대
    */
	
	public static void BFS(int i, int j) {
		int[] xx = {-1, 1, 0, 0};
		int[] yy = {0, 0, 1, -1};
		
		int Sheep = 0;
		int Wolf = 0;
		visit[i][j] = 1;
		location.add(new Area(i, j));
		
		if(map[i][j] == 'o') {
			Sheep++;
		} else if(map[i][j] == 'v') {
			Wolf++;
		}
		
		while(!location.isEmpty()) {
//			int x = location.peek().x;
//			int y = location.poll().y;
			Area q = location.poll();

			for(int k = 0;k < 4;k++) {
				int ax = q.x+xx[k];
				int ay = q.y+yy[k];
				
				if(ax>=0 && ay>=0 && ax<r && ay<c) {
					if(visit[ax][ay] == 0 && map[ax][ay] == 'o') {
						Sheep++;
					} else if( visit[ax][ay] == 0 && map[ax][ay] == 'v') {
						Wolf++;
					}
					
					if(visit[ax][ay] == 0 && map[ax][ay] != '#') {
						location.add(new Area(ax, ay));
						visit[ax][ay] = 1;
					}
				}
			}
		}

		if(Wolf>=Sheep) {
			total_wolf += Wolf;
		} else if(Sheep > Wolf) {
			total_sheep += Sheep;
		}
	}
}

// 좌표

class Area{
	int x;
	int y;
	
	public Area(int x, int y) {

		this.x = x;
		this.y = y;
	}
}
