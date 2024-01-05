import java.util.*;
import java.io.*;
import java.io.FileInputStream;

class Hi{
	int x, y;
	Hi(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main{
	static int n;
	static int map[][];
	static boolean vi[][];
	static int count;
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	static ArrayList<Integer> ar = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		map = new int[n][n];
		vi = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			String s = sc.next();
			for(int j=0; j<n; j++) {
				map[i][j]=s.charAt(j)-48;
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==1 && !vi[i][j]) {
					count=1;
					dfs(i, j);
					ar.add(count);
				}
			}
		}
		Collections.sort(ar);
		System.out.println(ar.size());
		for(int i=0; i<ar.size(); i++) {
			System.out.println(ar.get(i));
		}
	}
	
	public static void dfs(int x, int y) {
		vi[x][y]=true;
		for(int i=0; i<4; i++) {
			int tx = x+dx[i];
			int ty = y+dy[i];
			if(tx>=0 && ty>=0 && tx<n && ty<n) {
				if(map[tx][ty]==1 && !vi[tx][ty]) {
					count++;
					dfs(tx, ty);
				}
			}
		}
	}
}