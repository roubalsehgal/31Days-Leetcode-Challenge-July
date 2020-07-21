class Solution {
	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++)
		for (int j = 0; j < board[0].length; j++)
		if (traverse(board, word, i, j, 0)) return true;
		return false;
	}

	boolean traverse(char[][] board, String word, int i, int j, int idx) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(idx) != board[i][j]) return false;

		board[i][j] = '*';
		
		if (idx == word.length() - 1 || traverse(board, word, i + 1, j, idx + 1) || traverse(board, word, i - 1, j, idx + 1) || traverse(board, word, i, j + 1, idx + 1) || traverse(board, word, i, j - 1, idx + 1)) return true;
		board[i][j] = word.charAt(idx);
		return false;
	}
}