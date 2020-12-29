package study;

import java.util.*;
import java.util.Scanner;

public class Backjoon_2583 {
	
	static int m, n;
	static int count;
	
	static int[][] map; //전체 
	static boolean[][] visit; //방문여부
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static ArrayList<Integer> area;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt();
		n = sc.nextInt();
		map = new int[m][n];
		visit = new boolean[m][n];
		area = new ArrayList<Integer>();
		count = 0;
		
		int k = sc.nextInt();
		int[] point = new int[4];
		
		//꼭지점 담기 
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < 4; j++) {
				point[j] = sc.nextInt();
			}
			
			for(int j = point[1]; j < point[3]; j++) {
				for(int w = point[0]; w < point[2]; w++) {
					map[j][w] = 1;
				}
			}
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 0 && visit[i][j] == false) {
					area.add(0);
					dfs(i, j);
					count++;
				}
			}
		}
		
		Collections.sort(area);
		
		System.out.println(count);
		for(int i = 0; i < area.size(); i++) {
			System.out.print(area.get(i) + " ");
		}
	}
	
	//탐색 - 재귀 
	public static void dfs(int x, int y) {
		
		visit[x][y] = true;
		area.set(count, (int)area.get(count)+1);
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < m && ny < n) {
				if(map[nx][ny] == 0 && visit[nx][ny] == false)
					dfs(nx, ny);
			}
		}
	}
	
}