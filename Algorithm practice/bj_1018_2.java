
import java.util.Scanner;

public class bj_1018_2 {
	static int M, N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = 0; // 앞으로 색칠할 갯수 카운트
		int min = 999;  // 한도 일단 크게 min 잡음
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		char[][] chess = new char[M][N]; // B W 로 받으니까
		
		for(int i = 0; i < M; i++) {
			String tmp = sc.next();
			for(int j = 0; j < N; j++) {
				chess[i][j] = tmp.charAt(j);
			}
		}
		
		
		
		// 이 시작은 체스판을 거대 좌표로 생각하면 됨 
		/*
		 * 00 01 02 03 04 05 06 07
		 * 10 11 12 13 14 15 16 17
		 * 20 21 22 23 24 25 26 27
		 * ...
		 * 이렇게 갈때 보면 체스모양대로 0+0 = 0 0+2=2 0+4=4 1+1=2 1+3=4 이렇게 짝수 값을 가진다.
		 * 따라서 x y 값을 더한 좌표의 값이 짝수면 
		 */
		for(int i = 0; i <= M-8; i++) { // M*N중 8*8 설정 
			for(int j = 0; j <= N-8; j++) {
				
				for(int a = 0; a < 8; a++)    // 8*8 안에서
					for(int b= 0; b < 8; b++) {
						if((a+b)%2 == 0) { //짝수 일때 
							if(chess[a+i][b+j] != 'B')
								count++;
						}else {
							if(chess[a+i][b+j] != 'W')
								count++;
						}
					}
				min = Math.min(Math.min(64-count, count),min);
				count = 0;
			}
		}
		System.out.println(min);
	}
}