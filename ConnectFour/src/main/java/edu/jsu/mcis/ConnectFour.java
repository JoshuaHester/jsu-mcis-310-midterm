package edu.jsu.mcis;

public class ConnectFour {
    public enum Token { RED, BLACK, EMPTY }
    public enum Result { NONE, RED_WIN, BLACK_WIN, TIE }
    public static final int COLUMNS = 7;
    private final int ROWS = 6;
    private Token[][] board;
    private boolean redTurn;
    
    public ConnectFour() {
        board = new Token[ROWS][COLUMNS];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = Token.EMPTY;
            }
        }
        redTurn = true;
    }
    
    public Token getTopOfColumn(int col) {
        int height = getHeightOfColumn(col);
		if(height==0) return Token.EMPTY;
		else return board[height-1][col];
    }
    
    public int getHeightOfColumn(int col) {
		int count=0;
        for(int i=0;i<ROWS;i++){
			if(board[i][col]!=Token.EMPTY)
				count++;
		}
		return count;
    }
    
    public boolean dropTokenInColumn(int col) {
		if(getHeightOfColumn(col)<ROWS){
			int height = getHeightOfColumn(col);
			if(redTurn) board[height][col]=Token.RED;
			else board[height][col]=Token.BLACK;
			redTurn= !redTurn;
		return true;
		}
		else return false;
    }
    
    public Result getResult() {
		int count=0;
		for(int i=0;i<ROWS;i++){
			for(int j=0;j<COLUMNS;j++){
				if(doesLeadToWin(i, j)){
					if(board[i][j]==Token.RED) return Result.RED_WIN;
					if(board[i][j]==Token.BLACK) return Result.BLACK_WIN;
				}
				if(board[i][j]!=Token.EMPTY){count++;}
			}
		}
		return Result.NONE;
    }
    
    
    // Here are a couple of private methods to give you
    // an idea of a more clever way to determine winners.
    private boolean doesRedWinVerticallyInColumn(int col) {
        String columnString = makeStringFromColumn(col);
        return (columnString.indexOf("RRRR") >= 0);
    }
    
    private String makeStringFromColumn(int col) {
        String s = "";
        for(int row = 0; row < ROWS; row++) {
            if(board[row][col] == Token.RED) s += "R";
            else if(board[row][col] == Token.BLACK) s += "B";
            else s += " "; 
        }
        return s;
    }
	
	private boolean doesLeadToWin(int row, int col){
		if(board[row][col]==Token.EMPTY) return false;
		else{
			Token start = board[row][col];
			int count=1;
			//horizontal
			for(int i=1;i<4;i++){
				if(col+i<COLUMNS){
					if(board[row][col+i]==start){
					count++;
					}
				}
			}
			if(count==4){
				return true;	
			}
			else count=1;
			//vertical
			for(int i=1;i<4;i++){
				if(row+i<ROWS){
					if(board[row+i][col]==start){
					count++;
					}
				}
			}
			if(count==4){
				return true;	
			}
			else count=1;
		}
		return false;
	}
}












