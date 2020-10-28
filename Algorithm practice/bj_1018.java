import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class bj_1018 {
 
	public static boolean[][] arr; // B w ���� Ȯ���Ϸ���!!!!!!!!!!!!!
	public static int min = 64;  // 8*8 �ּ�
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
 
		arr = new boolean[N][M]; // �߰� ü���� ũ�� ����
		
 
		// �迭 �Է� 
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < M; j++) {
				if (str.charAt(j) == 'W') { // ù��°  �� 00�� ȭ��Ʈ �� ���� ���� 
					arr[i][j] = true;		// W�� ���� true 
				} else {
					arr[i][j] = false;		// B�� ���� false
				}
 
			}
		}
 
		
//		int N_row = N - 7;
//		int M_col = M - 7;
 
		for (int i = 0; i < N-7; i++) {
			for (int j = 0; j < M-7; j++) {
				find(i, j); // FIND �Լ� ����
			}
		}
		System.out.println(min);
	}
 
	// ĥ�ϴ� ü������ ���ڰ� ���� ���� ���� ã�� �Լ�
	
	public static void find(int x, int y) {
//		int end_x = x + 8;
//		int end_y = y + 8;
		int count = 0;
 
		boolean TF = arr[x][y];	// �и��� �� 8*8 �� ù ��° ĭ�� �� 
 
		for (int i = x; i < x+8; i++) { // �и��� 8*8�� ó������ ������ ���� for ��
			for (int j = y; j < y+8; j++) {
 
				// �ٸ� ���� ��� ĥ�ؾ� ��   = count 1 ���� 
				if (arr[i][j] != TF) {	
					count++;
				}
				
				TF = (!TF); // ���� ������ ���� ĭ�� ������
 // ȭ��Ʈ�� ���� ĭ�� �������� ���� Ö
 // �� �� �� �� �� �� �� ��
 // �� �� �� �� �� �� �� ��
 // �� �� �� �� �� �� �� ��

			}
			
			TF = !TF; // ���� �� ĭ���� ù ��°
		}
		
			// ù ��° ĭ�� �������� �� ���� ��ĥ �� ����(count)= ù°ĭ�� ȭ��Ʈ ��  ��ĥ �� ����(64 - count) = ù ĭ ����
		    //  �� �ּڰ��� count �� ���� 
		 
		count = Math.min(count, 64 - count);
		
		// 8*8 �� �߶� ��� �� �� ���� ���� ���� ���� �� 
		min = Math.min(min, count);
	}
}

