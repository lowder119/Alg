import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		back_7576();
	}
	
	static int M, N;
	static boolean visit[][];
	static int arr[][];
	static int[] po1 = {-1, 1, 0, 0};
	static int[] po2 = {0, 0, -1, 1};
	static Queue<int[]> queue ;
	public static void back_7576(){
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		queue = new LinkedList<>();
		arr = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == 1) {
					queue.add(new int[]{i, j});
				}
			}
		}
		
		back_7576_fuc();
		
		int day = 0;
		boolean allOk = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				day = Math.max(arr[i][j], day);
				if (arr[i][j] == 0) {
					allOk = false;
					break;
				}
			}
		}
		
		if (allOk) {
			System.out.println(day-1);
		} else {
			System.out.println(-1);
		}
	}
	
	public static void back_7576_fuc() {
		while (queue.isEmpty() == false) {
			int vertex[] = queue.poll();
			int fromY = vertex[0];
			int fromX = vertex[1];
			
			for (int i = 0; i < 4; i++) {
				
				int toY = fromY + po1[i];
				int toX = fromX + po2[i];
				if (toY < 0 || toX < 0 || toY >= N || toX >= M) continue;
				if (arr[toY][toX] == -1 || arr[toY][toX] > 0) continue;
				
				queue.add(new int[]{toY, toX});
				arr[toY][toX] = arr[fromY][fromX] + 1;
			}
		}
	}
}
