import java.util.Scanner;
import java.io.IOException;

//dfs�� bfs�� �Ѵ� �����ε� �̰� dfs

public class bj_2606 {
	
	static int map[][]; //�湮�Ͽ� Ȯ���� ���� ��ǻ��
	static boolean visit[];
	static int n, m; // n = ��ǻ�� , m = ���� ��
	static int result = 0; // ���
	
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