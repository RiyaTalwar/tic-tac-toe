/* PROJECT-6
 * TIC TAC TOE GAME
 * NAME: RIYA TALWAR
 * ID:201501154
*/
import java.util.*;
public class GameBoard {
	private char board[][];	 //I have taken order as row and column as board[row][column]
	private int anyWinner=0;
	private int computer=0;		//whether we have computer as one of the players or not
	public int getComputer() {
		return computer;
	}
	public void setComputer(int computer) {
		this.computer = computer;
	}
	public GameBoard()		//constructor of class GameBoard
	{
		board=new char[3][3];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
				board[i][j]='-';
		}
	}
	public int getAnyWinner() {
		return anyWinner;
	}

	public void setAnyWinner(int anyWinner) {
		this.anyWinner = anyWinner;
	}
	public char getBoard(int row,int column) {
		return board[row][column];
	}
	public void setBoardMark(int row,int column,char mark)		//method to set the mark on the board based on the location input given by user
	{
		board[row][column]=mark;	//mark is placed on board
		checkWin(mark);				//calling method to check whether the player's move has made him win the game
		if(getAnyWinner()==1)		//if player has won then  
			winner(mark);			//calling method to print the winner
	}
	public void checkWin(char mark)	//to check whether the player's move has made him win the game
	{
		if(checkRow(mark)||checkColumn(mark)||checkDiagonal(mark))	
			setAnyWinner(1);
	}
	public boolean checkRow(char mark)	//if any row has all same marks 'X' or 'O' then method returns true otherwise false
	{
		for(int i=0;i<3;i++)
		{
			if(mark==board[i][0]&&mark==board[i][1]&&mark==board[i][2])
				return true;
		}
		return false;
	}
	public boolean checkColumn(char mark)	//if any column has all same marks 'X' or 'O' then method returns true otherwise false
	{
		for(int j=0;j<3;j++)
		{
			if(mark==board[0][j]&&mark==board[1][j]&&mark==board[2][j])
				return true;
		}
		return false;
	}
	public boolean checkDiagonal(char mark)	//if any diagonal has all same marks 'X' or 'O' then method returns true otherwise false
	{
		if(mark==board[0][0]&&mark==board[1][1]&&mark==board[2][2])
			return true;
		else if(mark==board[0][2]&&mark==board[1][1]&&mark==board[2][0])
			return true;
		else
			return false;
	}
	public void winner(char mark)	//print the winner
	{
		if(mark=='X')
		{
			if(computer==0)
				System.out.println("Player 1 wins");
			else
				System.out.println("human wins");
		}
		else if(mark=='O')
		{
			if(computer==0)
				System.out.println("Player 2 wins");
			else
				System.out.println("computer wins");
		}
	}
	//computer tries to win by checking its possibilities across all rows,columns and diagonals
	public int tryWin()
	{
		int comp_placeMarkAtRow=0;
		int comp_placeMarkAtColumn=0;
		int found=0;
		//check the rows
		for(int i=0;i<3;i++)
		{
			if(board[i][0]==board[i][1]&&board[i][0]=='O')
			{
				if(board[i][2]=='-')
				{
					comp_placeMarkAtRow=i;
					comp_placeMarkAtColumn=2;
					found=1;
					break;
				}
			}
			else if(board[i][0]==board[i][2]&&board[i][0]=='O')
			{
				if(board[i][1]=='-')
				{
					comp_placeMarkAtRow=i;
					comp_placeMarkAtColumn=1;
					found=1;
					break;
				}
			}
			else if(board[i][1]==board[i][2]&&board[i][1]=='O')	
			{
				if(board[i][0]=='-')
				{
					comp_placeMarkAtRow=i;
					comp_placeMarkAtColumn=0;
					found=1;
					break;
				}
			}
		}
		//check the columns
		if(found==0)
		{
			for(int j=0;j<3;j++)
			{
				if(board[0][j]==board[1][j]&&board[0][j]=='O')
				{
					if(board[2][j]=='-')
					{
						comp_placeMarkAtRow=2;
						comp_placeMarkAtColumn=j;
						found=1;
						break;
					}
				}
				else if(board[0][j]==board[2][j]&&board[0][j]=='O')
				{
					if(board[1][j]=='-')
					{
						comp_placeMarkAtRow=1;
						comp_placeMarkAtColumn=j;
						found=1;
						break;
					}
				}
				else if(board[1][j]==board[2][j]&&board[1][j]=='O')
				{
					if(board[0][j]=='-')
					{
						comp_placeMarkAtRow=0;
						comp_placeMarkAtColumn=j;
						found=1;
						break;
					}
				}	
			}
		}
	    //check the diagonals
		if(found==0)
		{
			if(board[0][0]==board[1][1]&&board[0][0]=='O')
			{
				if(board[2][2]=='-')
				{
					comp_placeMarkAtRow=2;
					comp_placeMarkAtColumn=2;
					found=1;
				}
			}
			else if(board[0][0]==board[2][2]&&board[0][0]=='O')
			{
				if(board[1][1]=='-')
				{
					comp_placeMarkAtRow=1;
					comp_placeMarkAtColumn=1;
					found=1;
				}
			}
			else if(board[1][1]==board[2][2]&&board[1][1]=='O')
			{
				if(board[0][0]=='-')
				{
					comp_placeMarkAtRow=0;
					comp_placeMarkAtColumn=0;
					found=1;
				}
			}	
		}
		if(found==0)
		{
			if(board[0][2]==board[1][1]&&board[1][1]=='O')
			{
				if(board[2][0]=='-')
				{
					comp_placeMarkAtRow=2;
					comp_placeMarkAtColumn=0;
					found=1;
				}
			}
			else if(board[0][2]==board[2][0]&&board[2][0]=='O')
			{
				if(board[1][1]=='-')
				{
					comp_placeMarkAtRow=1;
					comp_placeMarkAtColumn=1;
					found=1;
				}
			}
			else if(board[1][1]==board[2][0]&&board[2][0]=='O')
			{
				if(board[0][2]=='-')
				{
					comp_placeMarkAtRow=0;
					comp_placeMarkAtColumn=2;
					found=1;
				}
			}	
		}
		if(found==1)
		{
			System.out.println("computer's input "+(comp_placeMarkAtRow+1)+" "+(comp_placeMarkAtColumn+1));
			setBoardMark(comp_placeMarkAtRow, comp_placeMarkAtColumn,'O');
		}
		return found;
	}
	//computer tries to block opponents winning possibilities by checking all rows,columns and diagonals
	public int block()
	{
		int comp_placeMarkAtRow=0;
		int comp_placeMarkAtColumn=0;
		int found=0;
		//check the rows
		for(int i=0;i<3;i++)
		{
			if(board[i][0]==board[i][1]&&board[i][0]=='X')
			{
				if(board[i][2]=='-')
				{
					comp_placeMarkAtRow=i;
					comp_placeMarkAtColumn=2;
					found=1;
				}
			}
			else if(board[i][0]==board[i][2]&&board[i][0]=='X')
			{
				if(board[i][1]=='-')
				{
					comp_placeMarkAtRow=i;
					comp_placeMarkAtColumn=1;
					found=1;
				}
			}
			else if(board[i][1]==board[i][2]&&board[i][1]=='X')	
			{
				if(board[i][0]=='-')
				{
					comp_placeMarkAtRow=i;
					comp_placeMarkAtColumn=0;
					found=1;
				}
			}
		}
		//check the columns
		if(found==0)
		{
			for(int j=0;j<3;j++)
			{
				if(board[0][j]==board[1][j]&&board[0][j]=='X')
				{
					if(board[2][j]=='-')
					{
						comp_placeMarkAtRow=2;
						comp_placeMarkAtColumn=j;
						found=1;
					}
				}
				else if(board[0][j]==board[2][j]&&board[0][j]=='X')
				{
					if(board[1][j]=='-')
					{
						comp_placeMarkAtRow=1;
						comp_placeMarkAtColumn=j;
						found=1;
					}
				}
				else if(board[1][j]==board[2][j]&&board[1][j]=='X')
				{
					if(board[0][j]=='-')
					{
						comp_placeMarkAtRow=0;
						comp_placeMarkAtColumn=j;
						found=1;
					}
				}	
			}
		}
		//check the diagonals
				if(found==0)
				{
					if(board[0][0]==board[1][1]&&board[0][0]=='X')
					{
						if(board[2][2]=='-')
						{
							comp_placeMarkAtRow=2;
							comp_placeMarkAtColumn=2;
							found=1;
						}
					}
					else if(board[0][0]==board[2][2]&&board[0][0]=='X')
					{
						if(board[1][1]=='-')
						{
							comp_placeMarkAtRow=1;
							comp_placeMarkAtColumn=1;
							found=1;
						}
					}
					else if(board[1][1]==board[2][2]&&board[1][1]=='X')
					{
						if(board[0][0]=='-')
						{
							comp_placeMarkAtRow=0;
							comp_placeMarkAtColumn=0;
							found=1;
						}
					}	
				}
				if(found==0)
				{
					if(board[0][2]==board[1][1]&&board[1][1]=='X')
					{
						if(board[2][0]=='-')
						{
							comp_placeMarkAtRow=2;
							comp_placeMarkAtColumn=0;
							found=1;
						}
					}
					else if(board[0][2]==board[2][0]&&board[2][0]=='X')
					{
						if(board[1][1]=='-')
						{
							comp_placeMarkAtRow=1;
							comp_placeMarkAtColumn=1;
							found=1;
						}
					}
					else if(board[1][1]==board[2][0]&&board[2][0]=='X')
					{
						if(board[0][2]=='-')
						{
							comp_placeMarkAtRow=0;
							comp_placeMarkAtColumn=2;
							found=1;
						}
					}	
				}
		if(found==1)
		{
			System.out.println("computer's input "+(comp_placeMarkAtRow+1)+" "+(comp_placeMarkAtColumn+1));
			setBoardMark(comp_placeMarkAtRow, comp_placeMarkAtColumn,'O');
		}
		return found;
	}
	//computer generates random move in this method
	public void placeRandom()
	{
		Random random=new Random();
		int maxInt=3;
		int minInt=1;
		int comp_placeMarkAtRow=random.nextInt(maxInt-minInt+1)+minInt-1;
		int comp_placeMarkAtColumn=random.nextInt(maxInt-minInt+1)+minInt-1;
		/*this while loop will continue till the computer generates value of a row and column where there is '-'
		which means that the cell is empty and it doesnot have any mark('X' or 'O')*/
		while((getBoard(comp_placeMarkAtRow, comp_placeMarkAtColumn))=='X'||(getBoard(comp_placeMarkAtRow, comp_placeMarkAtColumn))=='O')
		{
			comp_placeMarkAtRow=random.nextInt(maxInt-minInt+1)+minInt-1;
			comp_placeMarkAtColumn=random.nextInt(maxInt-minInt+1)+minInt-1;
		}
		System.out.println("computer's input "+(comp_placeMarkAtRow+1)+" "+(comp_placeMarkAtColumn+1));
		setBoardMark(comp_placeMarkAtRow, comp_placeMarkAtColumn,'O');
	}

}
