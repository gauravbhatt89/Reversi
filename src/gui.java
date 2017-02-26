import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class gui extends JFrame{
	MyPanel[][] panel= new MyPanel[9][9];
	JPanel panel2= new JPanel();
	JPanel panel3= new JPanel();
	public gui(){
		super("Reversi");
		//this.setLayout(new GridBagLayout());
		
		setSize(500,500);
		
		Handler h= new Handler();
		
		panel3.setLayout(new GridLayout(8,8));
		for(int i=1;i<9;i++){
			for(int j=1;j<=8;j++){
				panel[i][j]= new MyPanel();
				panel[i][j].setSize(100,100);
				panel[i][j].setBackground(Color.BLUE);
				panel[i][j].setBorder(new LineBorder(Color.BLACK));
				panel[i][j].addMouseListener(h);
				panel[i][j].x=i;
				panel[i][j].y=j;
				
				panel3.add(panel[i][j]);
				panel[i][j].paint(Color.BLACK);
			}
		}
		add(panel3);
	}
	
	public class MyPanel extends JPanel{
		int x,y;
		DrawingClass dc = new DrawingClass();
		Graphics2D g2d;
		@Override
		protected void paintComponent(Graphics grphcs) {
            super.paintComponent(grphcs);
            g2d = (Graphics2D) grphcs;
           
    //        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            dc.draw(g2d);

        }
		protected void paint(Color c){
		//	dc.draw(g2d);
		}
		MyPanel(){

			super();
			 
			//this.x=x;
			//this.y=y;
		}
		
	}
	private class Handler implements MouseListener{
		public void mouseClicked(MouseEvent e){
			MyPanel p= (MyPanel) e.getSource();
			//p.dc.c=Color.GREEN;
			//p.repaint();
			//JOptionPane.showMessageDialog(null,"Message Content"+((MyPanel) e.getSource()).x+((MyPanel) e.getSource()).y);
			
			if(isPlayersMove==true)
			{
				int x=p.x;
				int y= p.y;
				Board temp2=makeMove(gameBoard, x, y, -1);
				while(temp2==null){
					System.out.println("Invalid move. Enter again");
					return;
				}
				gameBoard=temp2;
				hasMoved=true;
			}
		}
		
		public void mouseExited(MouseEvent es){
			MyPanel p= (MyPanel) es.getSource();
			int i=p.x;
			int j= p.y;
			if(gameBoard.board[i][j]==0)
				panel[i][j].dc.c=Color.blue;
			else if(gameBoard.board[i][j]==1)
				panel[i][j].dc.c=Color.white;
			else
				panel[i][j].dc.c=Color.black;
			panel[i][j].repaint();
			
		}
		
		public void mouseEntered(MouseEvent es){
			MyPanel p= (MyPanel) es.getSource();
			if(isPlayersMove==true){
				int x=p.x;
				int y= p.y;
				Board temp2=makeMove(gameBoard, x, y, -1);
				if(temp2!=null){
					p.dc.c=Color.DARK_GRAY;
				}
				p.repaint();
			}
		}
		public void mousePressed(MouseEvent es){
			
		}
		public void mouseReleased(MouseEvent es){
			
		}
		
	}
	
	class DrawingClass {
		Color c;
	    public void draw(Graphics2D g2d) {
	        g2d.setColor(c);
	        g2d.fillOval(4, 4, 50, 50);
	    }
	}
	
	

	public static List<Board> getAllMoves(Board b,int playerToMove){
		List<Board> retval= new ArrayList<>();
		for(int i=1;i<=8;i++){
			for(int j=1;j<=8;j++){
				boolean moved=false;
				if(b.board[i][j]==0){
						boolean flag=false;
						int count=0;
						Board temp=null;
						
						//direction1 : North West
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
						//	retval.add(temp);
						}

						//direction 3 : North East
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
						
						//Direction 5	: South East				
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
						
						//Direction 7  : South West
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
						
						//Direction 2 : North
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
						
						//Direction 4 : East
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
						
						//Direction 8 : West
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
						
						
						//Direction 6 : South
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
		int white=0,totalcount=0,score=0,nummoves;
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
			if(totalcount==64){
					System.out.println("o");
					retval+=100*(2*white-totalcount);
				}
			else
				retval+=2*(2*white-totalcount);
			
		}
		return 3*score+retval;
	}
	
	public static int filled=4;
	public static int whiteCount=2;
	public static int blackCOunt=2;
	//public static int bfilled=2,wfilled=2;
	
	
	
	
	
	
	
	
	
	
	
	
	
	boolean isPlayersMove=false;
	boolean hasMoved=false;
	
	public static void main(String args[]){
		gui g= new gui();
		g.setDefaultCloseOperation(EXIT_ON_CLOSE);
		g.setVisible(true);
		Board b= new Board();
		gameBoard= new Board();
		
	//	search(gameBoard, 13, 1, 0, filled,-100,100);
		System.out.println(ctt);
		int f=0;
		while(filled<=64){		
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
				g.isPlayersMove=false;
				f=0;
				filled++;
				whiteCount++;
				System.out.println("Eval is:" +search(gameBoard, 8, 1, 0, filled,-1000000,1000000));
				System.out.println("-----------------");
				printt(gameBoard);
				for(int i=1;i<=8;i++){
					for(int j=1;j<=8;j++){
						if(gameBoard.board[i][j]==0)
							g.panel[i][j].dc.c=Color.blue;
						else if(gameBoard.board[i][j]==1)
							g.panel[i][j].dc.c=Color.white;
						else
							g.panel[i][j].dc.c=Color.black;
						g.panel[i][j].repaint();
					}
				}
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
				g.isPlayersMove=true;
				f=0;
				g.hasMoved=false;
				System.out.println("Enter the coordinates of your move");
				//Scanner in= new Scanner(System.in);
				while(g.hasMoved==false){
					System.out.print(" ");
				}
				for(int i=1;i<=8;i++){
					for(int j=1;j<=8;j++){
						if(gameBoard.board[i][j]==0)
							g.panel[i][j].dc.c=Color.blue;
						else if(gameBoard.board[i][j]==1)
							g.panel[i][j].dc.c=Color.white;
						else
							g.panel[i][j].dc.c=Color.black;
						g.panel[i][j].repaint();
					}
				}
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
		whiteCount=0;blackCOunt=0;
		for(int i=1;i<=8;i++){
			for(int j=1;j<=8;j++){
				if(gameBoard.board[i][j]==1)
					whiteCount++;
				else if(gameBoard.board[i][j]==-1)
					blackCOunt++;
			}
		}
		if(whiteCount>blackCOunt)
			System.out.println("I won. The score is:"+whiteCount+":"+blackCOunt);
		else if(blackCOunt>whiteCount)
			System.out.println("You won. The score is:"+whiteCount+":"+blackCOunt);
		else
			System.out.println("Its a draw! The score is:"+whiteCount+":"+blackCOunt);
	}
	
}