import java.util.*;
import java.io.*;

public class Main {
	static char[][][] cube = new char[6][3][3];
	
	public static void init() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				cube[0][i][j] = 'w';
				cube[1][i][j] = 'r';
				cube[2][i][j] = 'y';
				cube[3][i][j] = 'o';
				cube[4][i][j] = 'g';
				cube[5][i][j] = 'b';
			}
		}
	}
	
	public static char[][] set(char[][] face, char d) {
		char[][] nface = new char[3][3];
		if(d == '+') {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					nface[j][2-i] = face[i][j];
				}
			}
		}
		else {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					nface[2-j][i] = face[i][j];
				}
			}
		}
		return nface;
	}
	
	public static void turn(String s) {
		char op = s.charAt(0);
		char d = s.charAt(1);
		if(op == 'U') {
			if(d == '+') {
				for(int i = 0; i < 3; i++) {
					char tmp = cube[4][i][2];
					cube[4][i][2] = cube[1][0][i];
					cube[1][0][i] = cube[5][2-i][0];
					cube[5][2-i][0] = cube[3][2][2-i];
					cube[3][2][2-i] = tmp;
				}
			}
			else {
				for(int i = 0; i < 3; i++) {
					char tmp = cube[3][2][2-i];
					cube[3][2][2-i] = cube[5][2-i][0];
					cube[5][2-i][0] = cube[1][0][i];
					cube[1][0][i] = cube[4][i][2];
					cube[4][i][2] = tmp;
				}
			}
			cube[0] = set(cube[0], d);
		}
		else if(op == 'D'){
			if(d == '+') {
				for(int i = 0; i < 3; i++) {
					char tmp = cube[4][2-i][0];
					cube[4][2-i][0] = cube[3][0][i];
					cube[3][0][i] = cube[5][i][2];
					cube[5][i][2] = cube[1][2][2-i];
					cube[1][2][2-i] = tmp;
				}
			}
			else {
				for(int i = 0; i < 3; i++) {
					char tmp = cube[1][2][2-i];
					cube[1][2][2-i] = cube[5][i][2];
					cube[5][i][2] = cube[3][0][i];
					cube[3][0][i] = cube[4][2-i][0];
					cube[4][2-i][0] = tmp;
				}
			}
			cube[2] = set(cube[2], d);
		}
		else if(op == 'F') {
			if(d == '+') {
				for(int i = 0; i < 3; i++) {
					char tmp = cube[4][2][2-i];
					cube[4][2][2-i] = cube[2][0][i];
					cube[2][0][i] = cube[5][2][2-i];
					cube[5][2][2-i] = cube[0][2][2-i];
					cube[0][2][2-i] = tmp;
				}
			}
			else {
				for(int i = 0; i < 3; i++) {
					char tmp = cube[0][2][2-i];
					cube[0][2][2-i] = cube[5][2][2-i];
					cube[5][2][2-i] = cube[2][0][i];
					cube[2][0][i] = cube[4][2][2-i];
					cube[4][2][2-i] = tmp;
				}
			}
			cube[1] = set(cube[1], d);
		}
		else if(op == 'B') {
			if(d == '+') {
				for(int i = 0; i < 3; i++) {
					char tmp = cube[4][0][i];
					cube[4][0][i] = cube[0][0][i];
					cube[0][0][i] = cube[5][0][i];
					cube[5][0][i] = cube[2][2][2-i];
					cube[2][2][2-i] = tmp;
				}
			}
			else {
				for(int i = 0; i < 3; i++) {
					char tmp = cube[2][2][2-i];
					cube[2][2][2-i] = cube[5][0][i];
					cube[5][0][i] = cube[0][0][i];
					cube[0][0][i] = cube[4][0][i];
					cube[4][0][i] = tmp;
				}
			}
			cube[3] = set(cube[3], d);
		}
		else if(op == 'L') {
			if(d == '+') {
				for(int i = 0; i < 3; i++) {
					char tmp = cube[2][2-i][0];
					cube[2][2-i][0] = cube[1][2-i][0];
					cube[1][2-i][0] = cube[0][2-i][0];
					cube[0][2-i][0] = cube[3][2-i][0];
					cube[3][2-i][0] = tmp;
				}
			}
			else {
				for(int i = 0; i < 3; i++) {
					char tmp = cube[3][2-i][0];
					cube[3][2-i][0] = cube[0][2-i][0];
					cube[0][2-i][0] = cube[1][2-i][0];
					cube[1][2-i][0] = cube[2][2-i][0];
					cube[2][2-i][0] = tmp;
				}
			}
			cube[4] = set(cube[4], d);
		}
		else {
			if(d == '+') {
				for(int i = 0; i < 3; i++) {
					char tmp = cube[0][i][2];
					cube[0][i][2] = cube[1][i][2];
					cube[1][i][2] = cube[2][i][2];
					cube[2][i][2] = cube[3][i][2];
					cube[3][i][2] = tmp;
				}
			}
			else {
				for(int i = 0; i < 3; i++) {
					char tmp = cube[3][i][2];
					cube[3][i][2] = cube[2][i][2];
					cube[2][i][2] = cube[1][i][2];
					cube[1][i][2] = cube[0][i][2];
					cube[0][i][2] = tmp;
				}
			}
			cube[5] = set(cube[5], d);
		}
	}
	
	public static void print() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(cube[0][i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(tk.nextToken());
		for(int i = 0; i < n; i++) {
			tk = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(tk.nextToken());
			tk = new StringTokenizer(br.readLine());
			init();
			for(int j = 0; j < m; j++) {
				String s = tk.nextToken();
				turn(s);
			}
			print();
		}
		
	}
}