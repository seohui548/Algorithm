import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class bj_1018 {
 
	public static boolean[][] arr; // B w 값을 확인하려고!!!!!!!!!!!!!
	public static int min = 64;  // 8*8 최소
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
 
		arr = new boolean[N][M]; // 발견 체스판 크기 설정
		
 
		// 배열 입력 
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < M; j++) {
				if (str.charAt(j) == 'W') { // 첫번째  판 00이 화이트 인 경우로 설정 
					arr[i][j] = true;		// W일 때는 true 
				} else {
					arr[i][j] = false;		// B일 때는 false
				}
 
			}
		}
 
		
//		int N_row = N - 7;
//		int M_col = M - 7;
 
		for (int i = 0; i < N-7; i++) {
			for (int j = 0; j < M-7; j++) {
				find(i, j); // FIND 함수 실행
			}
		}
		System.out.println(min);
	}
 
	// 칠하는 체스판의 숫자가 가장 작은 것을 찾는 함수
	
	public static void find(int x, int y) {
//		int end_x = x + 8;
//		int end_y = y + 8;
		int count = 0;
 
		boolean TF = arr[x][y];	// 분리해 낸 8*8 의 첫 번째 칸의 색 
 
		for (int i = x; i < x+8; i++) { // 분리된 8*8의 처음부터 끝까지 도는 for 문
			for (int j = y; j < y+8; j++) {
 
				// 다른 색일 경우 칠해야 함   = count 1 증가 
				if (arr[i][j] != TF) {	
					count++;
				}
				
				TF = (!TF); // 변경 시켜줌 다음 칸의 색으로
 // 화이트의 다음 칸은 검정으로 변경 횜
 // 흰 검 흰 검 흰 검 흰 검
 // 검 흰 검 흰 검 흰 검 흰
 // 흰 검 흰 검 흰 검 흰 검

			}
			
			TF = !TF; // 다음 줄 칸으로 첫 번째
		}
		
			// 첫 번째 칸을 기준으로 할 때의 색칠 할 개수(count)= 첫째칸이 화이트 와  색칠 할 개수(64 - count) = 첫 칸 검정
		    //  중 최솟값을 count 에 저장 
		 
		count = Math.min(count, 64 - count);
		
		// 8*8 의 잘라낸 계산 수 중 가장 작은 것을 저장 비교 
		min = Math.min(min, count);
	}
}

