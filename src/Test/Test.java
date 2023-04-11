package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        //Scanner sc = new Scanner(System.in);
//       List<String> grid = new ArrayList<>();
//       grid.add("kc");
//       grid.add("iu");
//       String s = gridChallenge(grid);
//       System.out.println(s);
		String s = "babad";
		String ans = longestPalindrome(s);
		System.out.println(ans);
    }
	
	public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 0;
        int start = 0;
        
        // kiem tra cac chuoi co do dai 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            maxLen = 1;
            start = i;
        }
        
        // kiem tra cac chuoi co do dai 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLen = 2;
                start = i;
            }
        }
        
        // kiem tra cac chuoi co do dai > 2
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    maxLen = len;
                    start = i;
                }
            }
        }
        
        return s.substring(start, start + maxLen);
    }
	public static String gridChallenge(List<String> grid) {
	    // Write your code here
		for (int i = 0; i < grid.size() -1; i++) {
			String s = grid.get(i);
			char [] c = s.toCharArray();
			Arrays.sort(c);
			s = String.valueOf(c);
			for (int j = 0; j < s.length()-1; j++) {
				if(grid.get(i).charAt(j) > grid.get(i+1).charAt(j)) {
					return "NO";
				}
				if(s.charAt(j) > s.charAt(j+1)) {
					return "NO";
				}
			}
		}
		return "YES";
	}
}
