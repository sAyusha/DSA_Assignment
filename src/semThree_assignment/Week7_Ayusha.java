package semThree_assignment;

import java.util.*;

public class Week7_Ayusha {
	public static int findingPathUsingDP(int[][] arr)
	{
		int a = arr.length; // a = 3
		int b = arr[0].length; // b = 3
		
		// create a 2D-matrix and initializing
		// with value 0
		int[][] paths = new int[a][b];

		for (int i = 0; i < a; i++) {
		Arrays.fill(paths[i], -1);
		}

		return findPath(i, j, a, b, arr, paths);
	}
	
	static int i = 0;
	static int j = 0;

	public static int findPath(int i, int j, int a, int b, int[][] arr, int[][] paths){
		// boundary condition or constraints
		if (i == a || j == b) {
		return 0;
		}
		else if (arr[i][j] == 1) {
		return 0;
		}
		// base case
		else if (i == a - 1 && j == b - 1) {
		return 1;
		}
		else if (paths[i][j] != -1) {

		return paths[i][j];
		}
		else {
		return findPath(i + 1, j, a, b, arr, paths)+ findPath(i, j + 1, a, b, arr, paths);
		}
	}
	
	public static void main(String[] args){
		int[][] arr = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		System.out.println("output :" + findingPathUsingDP(arr));
	}
}

