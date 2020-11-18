package study;

//import java.util.Arrays;
import java.util.Scanner;

public class Backjoon_17204  {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int student = sc.nextInt(); //학생 수
		int bosung = sc.nextInt(); //보성이의 위치		
		int index[] = new int[student]; //0번째 학생부터 마지막 학생까지
		int itsyou = 0; //보성이 당첨!
		int count; //외치면 올라가는 숫자 
		
		for(int i = 0;i < student; i++) {
			index[i] = sc.nextInt();
		}

		boolean flag = true;
		boolean visit[] = new boolean[student];
		count=0;

		while(flag) {
			if(count == student) {
				flag = false; //한바퀴 다 돌음
				break;
			}else {
				if(itsyou==bosung) {
					break;}
				else{
				itsyou=index[itsyou];
				visit[itsyou]=false;
				count++;
				}
			}
		}
		if(!flag)
			System.out.println(-1);
		else
			System.out.println(count);
	}
}
