//import java.util.*;
/*

public class Reversi{
	
	public static List<Board> getAllMoves(Board b,int playerToMove){
		
		List<Board> retval= new ArrayList<>();
		for(int i=1;i<=8;i++){
			for(int j=1;j<=8;j++){
				boolean moved=false;
				if(b.board[i][j]==0){
						
						boolean flag=false;
						int count=0;
						Board temp=null;
						//direction1
						for(int k=1;i-k>=1&&j-k>=1;k++){
							if(b.board[i-k][j-k]==0)
								break;
							if(b.board[i-k][j-k]==-playerToMove){
								count++;
							} 
							if(b.board[i-k][j-k]==playerToMove){
								if(count>0){
									flag=true;
									
									break;
								}
								break;
							}
						}
						if(flag==true){
							moved=true;
							temp=new Board(b);
							//count--;
							for(;count>0;count--){
								temp.board[i-count][j-count]=playerToMove;
							}
							
							retval.add(temp);
						}
						
						
						
						
						//direction 3
						flag=false;
						count=0;
						for(int k=1;i-k>=1&&j+k<=8;k++){
							if(b.board[i-k][j+k]==0)
								break;
							if(b.board[i-k][j+k]==-playerToMove){
								count++;
							} 
							if(b.board[i-k][j+k]==playerToMove){
								if(count>0){
									flag=true;
									moved=true;
									break;
								}
								break;
							}
						}
						if(flag==true){
							moved=true;
							if(temp==null)
								temp= new Board(b);
							//count--;
							for(;count>0;count--){
								temp.board[i-count][j+count]=playerToMove;
							}
						
							
						}
						
						
						//Direction 5
						
						
						flag=false;
						count=0;
						for(int k=1;i+k<=8&&j+k<=8;k++){
							if(b.board[i+k][j+k]==0)
								break;
							if(b.board[i+k][j+k]==-playerToMove){
								count++;
							} 
							if(b.board[i+k][j+k]==playerToMove){
								if(count>0){
									flag=true;
									moved=true;
									break;
								}
								break;
							}
						}
						if(flag==true){
							moved=true;
							if(temp==null)
								temp= new Board(b);
							//count--;
							for(;count>0;count--){
								temp.board[i+count][j+count]=playerToMove;
							}
						
							
						}
						
						
						//Direction 7
						flag=false;
						count=0;
						for(int k=1;i+k<=8&&j-k>=1;k++){
							if(b.board[i+k][j-k]==0)
								break;
							if(b.board[i+k][j-k]==-playerToMove){
								count++;
							} 
							if(b.board[i+k][j-k]==playerToMove){
								if(count>0){
									flag=true;
									moved=true;
									break;
								}
								break;
							}
						}
						if(flag==true){
							moved=true;
							if(temp==null)
								temp= new Board(b);
							//count--;
							for(;count>0;count--){
								temp.board[i+count][j-count]=playerToMove;
							}
						
							
						}
						
						
						
						
						//Direction 2
						flag=false;
						count=0;
						for(int k=1;i-k>=1;k++){
							if(b.board[i-k][j]==0)
								break;
							if(b.board[i-k][j]==-playerToMove){
								count++;
							} 
							if(b.board[i-k][j]==playerToMove){
								if(count>0){
									flag=true;
									moved=true;
									break;
								}
								break;
							}
						}
						if(flag==true){
							moved=true;
							if(temp==null)
								temp= new Board(b);
							//count--;
							for(;count>0;count--){
								temp.board[i-count][j]=playerToMove;
							}
						
							
						}
						
						
						//Direction 4
						flag=false;
						count=0;
						for(int k=1;j+k<=8;k++){
							if(b.board[i][j+k]==0)
								break;
							if(b.board[i][j+k]==-playerToMove){
								count++;
							} 
							if(b.board[i][j+k]==playerToMove){
								if(count>0){
									flag=true;
									moved=true;
									break;
								}
								break;
							}
						}
						if(flag==true){
							moved=true;
							if(temp==null)
								temp= new Board(b);
							//count--;
							for(;count>0;count--){
								temp.board[i][j+count]=playerToMove;
							}
						
							
						}
						
						
						//Direction 8
						flag=false;
						count=0;
						for(int k=1;j-k>=1;k++){
							if(b.board[i][j-k]==0)
								break;
							if(b.board[i][j-k]==-playerToMove){
								count++;
							} 
							if(b.board[i][j-k]==playerToMove){
								if(count>0){
									flag=true;
									moved=true;
									break;
								}
								break;
							}
						}
						if(flag==true){
							moved=true;
							if(temp==null)
								temp= new Board(b);
							//count--;
							for(;count>0;count--){
								temp.board[i][j-count]=playerToMove;
							}
						
							
						}
						
						
						//Direction 6
						
						flag=false;
						count=0;
						for(int k=1;i+k<=8;k++){
							if(b.board[i+k][j]==0)
								break;
							if(b.board[i+k][j]==-playerToMove){
								count++;
							} 
							if(b.board[i+k][j]==playerToMove){
								if(count>0){
									flag=true;
									moved=true;
									break;
								}
								break;
							}
						}
						if(flag==true){
							moved=true;
							if(temp==null)
								temp= new Board(b);
							//count--;
							for(;count>0;count--){
								temp.board[i+count][j]=playerToMove;
							}
						
							
						}
						
						
						if(moved==true){
							//filled++;
							//whiteCount++;
							temp.board[i][j]=playerToMove;
							retval.add(temp);
						}
						
						
						
						
						
					
					
					
					
					
					
					
				}
			}
		}
		return retval;
	}
	public static Board makeMove(Board b,int i,int j, int playerToMove){
		Board temp=new Board(b);
		boolean moved=false;
		
			if(b.board[i][j]==0){
				boolean flag=false;
				int count=0;
				
				//direction1
				for(int k=1;i-k>=1&&j-k>=1;k++){
					if(b.board[i-k][j-k]==0)
						break;
					if(b.board[i-k][j-k]==-playerToMove){
						count++;
					} 
					if(b.board[i-k][j-k]==playerToMove){
						if(count>0){
							flag=true;
							
							break;
						}
						break;
					}
				}
				if(flag==true){
					moved=true;
					temp=new Board(b);
					//count--;
					for(;count>0;count--){
						temp.board[i-count][j-count]=playerToMove;
					}
					
				}
				
				
				
				
				//direction 3
				flag=false;
				count=0;
				for(int k=1;i-k>=1&&j+k<=8;k++){
					if(b.board[i-k][j+k]==0)
						break;
					if(b.board[i-k][j+k]==-playerToMove){
						count++;
					} 
					if(b.board[i-k][j+k]==playerToMove){
						if(count>0){
							flag=true;
							moved=true;
							break;
						}
						break;
					}
				}
				if(flag==true){
					moved=true;
					if(temp==null)
						temp= new Board(b);
					//count--;
					for(;count>0;count--){
						temp.board[i-count][j+count]=playerToMove;
					}
				
					
				}
				
				
				//Direction 5
				
				
				flag=false;
				count=0;
				for(int k=1;i+k<=8&&j+k<=8;k++){
					if(b.board[i+k][j+k]==0)
						break;
					if(b.board[i+k][j+k]==-playerToMove){
						count++;
					} 
					if(b.board[i+k][j+k]==playerToMove){
						if(count>0){
							flag=true;
							moved=true;
							break;
						}
						break;
					}
				}
				if(flag==true){
					moved=true;
					if(temp==null)
						temp= new Board(b);
					//count--;
					for(;count>0;count--){
						temp.board[i+count][j+count]=playerToMove;
					}
				
					
				}
				
				
				//Direction 7
				flag=false;
				count=0;
				for(int k=1;i+k<=8&&j-k>=1;k++){
					if(b.board[i+k][j-k]==0)
						break;
					if(b.board[i+k][j-k]==-playerToMove){
						count++;
					} 
					if(b.board[i+k][j-k]==playerToMove){
						if(count>0){
							flag=true;
							moved=true;
							break;
						}
						break;
					}
				}
				if(flag==true){
					moved=true;
					if(temp==null)
						temp= new Board(b);
					//count--;
					for(;count>0;count--){
						temp.board[i+count][j-count]=playerToMove;
					}
				
					
				}
				
				
				
				
				//Direction 2
				flag=false;
				count=0;
				for(int k=1;i-k>=1;k++){
					if(b.board[i-k][j]==0)
						break;
					if(b.board[i-k][j]==-playerToMove){
						count++;
					} 
					if(b.board[i-k][j]==playerToMove){
						if(count>0){
							flag=true;
							moved=true;
							break;
						}
						break;
					}
				}
				if(flag==true){
					moved=true;
					if(temp==null)
						temp= new Board(b);
					//count--;
					for(;count>0;count--){
						temp.board[i-count][j]=playerToMove;
					}
				
					
				}
				
				
				//Direction 4
				flag=false;
				count=0;
				for(int k=1;j+k<=8;k++){
					if(b.board[i][j+k]==0)
						break;
					if(b.board[i][j+k]==-playerToMove){
						count++;
					} 
					if(b.board[i][j+k]==playerToMove){
						if(count>0){
							flag=true;
							moved=true;
							break;
						}
						break;
					}
				}
				if(flag==true){
					moved=true;
					if(temp==null)
						temp= new Board(b);
					//count--;
					for(;count>0;count--){
						temp.board[i][j+count]=playerToMove;
					}
				
					
				}
				
				
				//Direction 8
				flag=false;
				count=0;
				for(int k=1;j-k>=1;k++){
					if(b.board[i][j-k]==0)
						break;
					if(b.board[i][j-k]==-playerToMove){
						count++;
					} 
					if(b.board[i][j-k]==playerToMove){
						if(count>0){
							flag=true;
							moved=true;
							break;
						}
						break;
					}
				}
				if(flag==true){
					moved=true;
					if(temp==null)
						temp= new Board(b);
					//count--;
					for(;count>0;count--){
						temp.board[i][j-count]=playerToMove;
					}
				
					
				}
				
				
				//Direction 6
				
				flag=false;
				count=0;
				for(int k=1;i+k<=8;k++){
					if(b.board[i+k][j]==0)
						break;
					if(b.board[i+k][j]==-playerToMove){
						count++;
					} 
					if(b.board[i+k][j]==playerToMove){
						if(count>0){
							flag=true;
							moved=true;
							break;
						}
						break;
					}
				}
				if(flag==true){
					moved=true;
					if(temp==null)
						temp= new Board(b);
					//count--;
					for(;count>0;count--){
						temp.board[i+count][j]=playerToMove;
					}
				
					
				}
				
				
				if(moved==true){
				//	System.out.println("aaaaaaaaaaaS");
					temp.board[i][j]=playerToMove;
				} else {
					return null;
				}
				
				
				
				
				
			
			
			
			
			
			
			
		
				return temp;
			}
			return null;
	}
	
	public static void printt(Board b){
		for(int i=1;i<=8;i++){
			for(int j=1;j<=8;j++){
				if(b.board[i][j]==0)
					System.out.print("_ ");
				else if(b.board[i][j]==1)
					System.out.print("W ");
				else
					System.out.print("B ");
			}
			System.out.println("");
		}
	}
	public static Board gameBoard;
	public static int search(Board b, int ply,int playertoMove,int flag,int numfilled,int alpha,int beta){
		//System.out.println("a");
	//	printt(b);
		//System.out.println("==================");
		int count=0;
		ctt++;
		if(ply==0||numfilled==64){
		//	printt(b);
			//System.out.println("--------------------------");
			return eval(b);
		} 
		List <Board> l= getAllMoves(b, playertoMove);
		if(l==null||l.size()==0){
			if(flag==0){
				
				//System.out.println("abcd");
				return search(b,ply,-playertoMove,1,numfilled,alpha,beta);
			}
			else{ 
				
				return eval(b);
			}
		} else {
			int max=-10000000;
			int min=10000000;
			if(playertoMove==1){
				
				for(int i=0;i<l.size();i++){
					
					int temp=search(l.get(i),ply-1,-playertoMove,0,numfilled+1,alpha,beta);
					if(temp>max){
						max=temp;
						if(ply==8)
							gameBoard=l.get(i);
					}
					if(temp>alpha)
						alpha=temp;
					if(beta<=alpha)
						break;
				}
				return max;
				
			}
			else {
				
				for(int i=0;i<l.size();i++){
					
					int temp=search(l.get(i),ply-1,-playertoMove,0,numfilled+1,alpha,beta);
					if(temp<min){
						min=temp;
						if(ply==8)
							gameBoard=l.get(i);
					}
					if(temp<beta)
						beta=temp;
					if(beta<=alpha){
					//	System.out.println("min node"+beta+" "+alpha);
						break;
					}
				}
				return min;
				
			}
			
			
		}
		
	}
	public static int ctt=0;
	public static int [][] refboard=new int[][]  {{0,0,0,0,0,0,0,0,0},
			{0, 30, -25, 10, 5, 5, 10, -25,  30,},
			   {0,-25, -25,  1, 1, 1,  1, -25, -25,},
			   {0, 10,   1,  5, 2, 2,  5,   1,  10,},
			   {0,  5,   1,  2, 1, 1,  2,   1,   5,},
			   {0,  5,   1,  2, 1, 1,  2,   1,   5,},
			   {0, 10,   1,  5, 2, 2,  5,   1,  10,},
			   {0,-25, -25,  1, 1, 1,  1, -25, -25,},
			   {0, 30, -25, 10, 5, 5, 10, -25,  30,}}; 
	public static int eval(Board b){
		int white=0,totalcount=0,score=0;
		for(int i=1;i<9;i++){
			for(int j=1;j<=8;j++){
				if(b.board[i][j]==1)
					white++;
				if(b.board[i][j]!=0)
					totalcount++;
				if(b.board[i][j]==1)
					score+=b.board[i][j]*refboard[i][j];
				
			}
		}
		int retval=0;
		if(totalcount<=40){
			retval+=-2*white+totalcount;
		} else {
			retval+=2*(2*white-totalcount);
		}
		return 3*score+retval;
	}
	public static int filled=4;
	public static int whiteCount=2;
	public static int blackCOunt=2;
	//public static int bfilled=2,wfilled=2;
	public static void main(String args[]){
		Board b= new Board();
		gameBoard= new Board();
		
	//	search(gameBoard, 13, 1, 0, filled,-100,100);
		System.out.println(ctt);
		int f=0;
		while(filled<64){
			
			int possiblemoves=0;
			for(int i=1;i<=8;i++){
				for(int j=1;j<=8;j++){
					if(makeMove(gameBoard, i, j, 1)!=null){
						possiblemoves++;
						break;
					}
				}
			}
			if(possiblemoves!=0){
				f=0;
				filled++;
				whiteCount++;
				System.out.println("Eval is:" +search(gameBoard, 8, 1, 0, filled,-1000000,1000000));
				System.out.println("-----------------");
				printt(gameBoard);
				System.out.println("-----------------");
				//gameBoard;
			} else {
				f++;
				if(f==2)
					break;
			}
			possiblemoves=0;
			for(int i=1;i<=8;i++){
				for(int j=1;j<=8;j++){
					if(makeMove(gameBoard, i, j, -1)!=null){
						possiblemoves++;
						break;
					}
				}
			}
			
			if(possiblemoves!=0){
				f=0;
				System.out.println("Enter the coordinates of your move");
				Scanner in= new Scanner(System.in);
				int x=in.nextInt();
				int y= in.nextInt();
				Board temp2=makeMove(gameBoard, x, y, -1);
				while(temp2==null){
					System.out.println("Invalid move. Enter again");
					x=in.nextInt();
					y= in.nextInt();
					temp2=makeMove(gameBoard, x, y, -1);
				}
				gameBoard=temp2;
				System.out.println("-----------------");
				printt(gameBoard);
				System.out.println("-----------------");
				//b=gameBoard;
				filled++;
				blackCOunt++;
			} else {
				f++;
				if(f==2)
					break;
				
			}
		}
		System.out.println("Game Over:");
		System.out.println("-------------------");
		printt(gameBoard);
		System.out.println("-------------------");
		if(whiteCount>blackCOunt)
			System.out.println("I won. The score is:"+whiteCount+":"+blackCOunt);
		else if(blackCOunt>whiteCount)
			System.out.println("You won. The score is:"+whiteCount+":"+blackCOunt);
		else
			System.out.println("Its a draw! The score is:"+whiteCount+":"+blackCOunt);
	}
}*/