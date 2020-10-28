
import java.util.Scanner;

public class bj_1018_2 {
	static int M, N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = 0; // ������ ��ĥ�� ���� ī��Ʈ
		int min = 999;  // �ѵ� �ϴ� ũ�� min ����
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		char[][] chess = new char[M][N]; // B W �� �����ϱ�
		
		for(int i = 0; i < M; i++) {
			String tmp = sc.next();
			for(int j = 0; j < N; j++) {
				chess[i][j] = tmp.charAt(j);
			}
		}
		
		
		
		// �� ������ ü������ �Ŵ� ��ǥ�� �����ϸ� �� 
		/*
		 * 00 01 02 03 04 05 06 07
		 * 10 11 12 13 14 15 16 17
		 * 20 21 22 23 24 25 26 27
		 * ...
		 * �̷��� ���� ���� ü������� 0+0 = 0 0+2=2 0+4=4 1+1=2 1+3=4 �̷��� ¦�� ���� ������.
		 * ���� x y ���� ���� ��ǥ�� ���� ¦���� 
		 */
		for(int i = 0; i <= M-8; i++) { // M*N�� 8*8 ���� 
			for(int j = 0; j <= N-8; j++) {
				
				for(int a = 0; a < 8; a++)    // 8*8 �ȿ���
					for(int b= 0; b < 8; b++) {
						if((a+b)%2 == 0) { //¦�� �϶� 
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