package study;

import java.util.ArrayList;
import java.util.Scanner;

public class Backjoon_11725 {
	
    static int n ;
    static ArrayList<Integer>[] list;
    static int[] parents;
    static boolean[] visit;
    
    private static void dfs(int v){
//        if(visit[v]){
//            return;
//        }
        visit[v] =true;
        for (int p : list[v]) {
            if(!visit[p]){
                parents[p] = v;
                dfs(p);
            }
        }
    }
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        list = new ArrayList[n+1];
        parents = new int[n+1];
        visit = new boolean[n+1];

        //1부터 시작므로 1이라고 해줌 
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for (int j = 1; j < n ; j++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            //서로 연결됨 
            list[a].add(b);
            list[b].add(a);
        }

        for (int k = 1; k <= n ; k++) {
            if(!visit[k]){
                dfs(k);
            }
        }
        for (int i = 2; i <= n ; i++) {
            System.out.println(parents[i]);
        }

    }

}