public class Board{
	
	int[][] board= new int [9][9];
	
	public Board(){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				board[i][j]=0;
			}
		}
		board[4][4]=1;
		board[5][5]=1;
		board[4][5]=-1;
		board[5][4]=-1;
	}
	
	public Board(Board b){
		//System.out.println("New Boeard is copied");
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				board[i][j]=b.board[i][j];
			}
		}
	}
	
}