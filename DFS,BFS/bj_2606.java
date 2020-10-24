import java.util.Scanner;
import java.io.IOException;

//dfs랑 bfs랑 둘다 가능인데 이건 dfs

public class bj_2606 {
	
	static int map[][]; //방문하여 확인할 연결 컴퓨터
	static boolean visit[];
	static int n, m; // n = 컴퓨터 , m = 간선 수
	static int result = 0; // 결과
	
	public static void main(String[] agrs) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n+1][n+1];
		visit = new boolean[n+1];
		
		int num1, num2;
		
		for(int i = 1; i <= m; i++) {
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			map[num1][num2] = map[num2][num1] = 1;
		}
		
		dfs(1);
		
		System.out.println(result);
	}
	
	public static void dfs(int d) {
		visit[d] = true;
		
		for(int i = 1; i < n + 1; i++) {
			if(map[d][i] == 1 && !visit[i]) {
				result++;
				dfs(i);
			}
		}
	}
}