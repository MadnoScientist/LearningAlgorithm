import java.util.Scanner;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 题解：简单回溯
 */
public class ST012 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt();
        char[][] board = new char[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                board[i][j] = in.next().charAt(0);
            }
        }
        String word = in.next();
        ST012_Solution.exist(board, word);
    }
}
class ST012_Solution {
    static boolean visited[][];
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        char[] cs = word.toCharArray();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //寻找与目标值第一个字母相同再进行判断
                if(word.charAt(0) == board[i][j]){
                    if(dfs(board, cs, 0, i, j))return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, char[] word, int index, int i, int j){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
                board[i][j] != word[index] || visited[i][j])
            return false;
        if (index == word.length - 1) return true;


        visited[i][j] = true;
        if (dfs(board, word, index+1, i - 1, j) || dfs(board, word, index + 1, i, j - 1) ||
                dfs(board, word, index+1, i + 1, j) || dfs(board, word, index + 1, i, j + 1)) return true;
        visited[i][j] = false;
        return false;
    }

}