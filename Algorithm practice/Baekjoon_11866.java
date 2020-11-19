package study;

import java.util.*;
/*
 * 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 
 * 이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 
 * 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 
 * 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 
 * 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 1,000)
 */

public class Baekjoon_11866 {
		public static void main(String[] args) { 
			//
			LinkedList<Integer> queue = new LinkedList<>(); 
			//ArrayList<Integer> out = new ArrayList<>();
			StringBuilder sb = new StringBuilder(); 
			Scanner sc = new Scanner(System.in); 
			
			int total = sc.nextInt(); 
			int deletenum = sc.nextInt()-1; 
			int index = deletenum; 
			sb.append("<"); 
			
			// 큐에 순서대로 값 넣기 
			for (int i = 1; i <= total; i++) 
				queue.add(i);
			//큐 안 재료 사라질 때까지 
			while (!queue.isEmpty()) { 
				sb.append(queue.get(index).toString() + ", "); 
				queue.remove(index); 
				index = (index + deletenum) % queue.size(); 
			} 
//			while (!queue.isEmpty()) {
//	            for (int i = 1; i < deletenum; i++) {
//	                int n = queue.poll();queue.offer(n);
//	            }
//	            out.add(queue.poll());
//	        }
//	        for (int i = 0; i < out.size(); i++) {
//	            sb.append(out.get(i));
//	            if (i < out.size() - 1) sb.append(", ");
//	            else sb.append(">");
//	        }
		sb.append(queue.pop().toString() + ">"); 
	       //sb.toString();
		System.out.print(sb); 	
		sc.close();
	}
 
}
