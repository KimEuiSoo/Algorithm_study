import java.util.*;
import java.io.*;

class BF{
	int n,m;
	BF(int n, int m){
		this.n = n;
		this.m = m;
	}
}

public class Main{
	static int[][] egg;
	static boolean[][] vi;
	static int n, m;
	static int max=0;
	static int ch = 0;
	static int[] xp = {1, -1, 0, 0};
	static int[] yp = {0, 0, 1, -1};
	static Queue<BF> qu = new LinkedList<BF>(); 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt();
		n = sc.nextInt();
		egg = new int[n][m];
		vi = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				egg[i][j]=sc.nextInt();
				if(egg[i][j]==1) {
					vi[i][j]=true;
					qu.add(new BF(i, j));
					ch++;
				}
				else if(egg[i][j]==-1) ch++;
			}
		}
		BFS();
		if(ch==m*n) {
			if(max!=0) {
				System.out.println(max-1);
			}
			else System.out.println("0");
		}
		else
			System.out.println("-1");
	}
	
	public static void BFS() {
		int a, b;
		while(!qu.isEmpty()) {
			a=qu.peek().n;      //4 
			b=qu.peek().m;		//6
			
			for(int i=0; i<4; i++) {
				if(a+xp[i]<n && a+xp[i]>=0 && b+yp[i]<m && b+yp[i]>=0 && egg[a+xp[i]][b+yp[i]]==0 && !vi[a+xp[i]][b+yp[i]]) {
					vi[a+xp[i]][b+yp[i]]=true;
					qu.add(new BF(a+xp[i], b+yp[i]));
					egg[a+xp[i]][b+yp[i]]=egg[a][b]+1;
					if(max<egg[a][b]+1) {
						max=egg[a][b]+1;
					}
					ch++;
				}
			}
			qu.poll();
		}	
	}
}