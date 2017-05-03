/* PROJECT-6
 * TIC TAC TOE GAME
 * NAME: RIYA TALWAR
 * ID:201501154
*/
import java.util.*;
public class Main {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the mode in which you want to play");
		System.out.println("1. HUMAN vs HUMAN");	//player1=human(X) and player2=human(O)
		System.out.println();
		System.out.println("   COMPUTER VS HUMAN");
		System.out.println("2. player1:computer and player2:human");	//player1=computer(O) and player2=human(X)
		System.out.println("3. player1:human and player2:computer");	//player1=human(X) and player2=computer(O)
		int choice=sc.nextInt();
		sc.nextLine();
		GameBoard game=new GameBoard();	//creating object called 'game' of class GameBoard
		int move=0;//move is counter for total moves made
		int human_placeMarkAtRow=0;
		int human_placeMarkAtColumn=0;
		switch(choice)	//game played in the mode chosen by user
		{
			//human vs human mode
			case 1:	while(game.getAnyWinner()==0)	
					{
						move=move+1;
						char mark;
						String placeMarkAt[]=sc.nextLine().split(" ");
						int placeMarkAtRow=Integer.parseInt(placeMarkAt[0])-1;
						int placeMarkAtColumn=Integer.parseInt(placeMarkAt[1])-1;
						//if that place on game board is already occupied
						while((game.getBoard(placeMarkAtRow, placeMarkAtColumn))=='X'||(game.getBoard(placeMarkAtRow, placeMarkAtColumn))=='O')
						{
							System.out.println("that place on game board is already occupied");
							System.out.println("enter another input");
						    String _placeMarkAt[]=sc.nextLine().split(" ");
							placeMarkAtRow=Integer.parseInt(_placeMarkAt[0])-1;
							placeMarkAtColumn=Integer.parseInt(_placeMarkAt[1])-1;
						}
						if(move%2==1)	//player1's turn
							mark='X';
						else		//player2's turn
							mark='O';
						game.setBoardMark(placeMarkAtRow, placeMarkAtColumn, mark);
						if(game.getAnyWinner()==1)
							break;
						if(move==9)	//if all places on the game board are occupied by marks so game is over(draw)
							break;
					}
					if(game.getAnyWinner()==0)	//as there is no winner
						System.out.println("Game Draw");
					break;
			//player1=computer and player2=human
			case 2:	game.setComputer(1);
					while(game.getAnyWinner()==0)
					{
						char mark;
						//player1's turn (computer's turn)
						mark='O';
						move=move+1;
						int comp_placeMarkAtRow=0;
						int comp_placeMarkAtColumn=0;
						if(move==1)
						{
							comp_placeMarkAtRow=1;
							comp_placeMarkAtColumn=1;
							System.out.println("computer's input "+(comp_placeMarkAtRow+1)+" "+(comp_placeMarkAtColumn+1));
							game.setBoardMark(comp_placeMarkAtRow, comp_placeMarkAtColumn, mark);
						}
						else if(move==3)
						{
							if((human_placeMarkAtRow==0&&human_placeMarkAtColumn==1)||(human_placeMarkAtRow==1&&human_placeMarkAtColumn==0))
							{
								comp_placeMarkAtRow=2;
								comp_placeMarkAtColumn=2;
								System.out.println("computer's input "+(comp_placeMarkAtRow+1)+" "+(comp_placeMarkAtColumn+1));
								game.setBoardMark(comp_placeMarkAtRow, comp_placeMarkAtColumn, mark);
							}
							else if((human_placeMarkAtRow==1&&human_placeMarkAtColumn==2)||(human_placeMarkAtRow==2&&human_placeMarkAtColumn==1))
							{
								comp_placeMarkAtRow=0;
								comp_placeMarkAtColumn=0;
								System.out.println("computer's input "+(comp_placeMarkAtRow+1)+" "+(comp_placeMarkAtColumn+1));
								game.setBoardMark(comp_placeMarkAtRow, comp_placeMarkAtColumn, mark);
							}
							else if((human_placeMarkAtRow==0&&human_placeMarkAtColumn==0)||(human_placeMarkAtRow==0&&human_placeMarkAtColumn==2)||(human_placeMarkAtRow==2&&human_placeMarkAtColumn==0)||(human_placeMarkAtRow==2&&human_placeMarkAtColumn==2))
							{
								game.placeRandom();
							}
						}
						else if(move==5||move==7||move==9)
						{
							int found;
							found=game.tryWin();
							if(found==0)
								found=game.block();
							if(found==0)
								game.placeRandom();
						}
						if(game.getAnyWinner()==1)
							break;
						if(move==9)	//if all places on the game board are occupied by marks so game is over(draw)
							break;
						//player2's turn (human's turn)
						String placeMarkAt[]=sc.nextLine().split(" ");
						human_placeMarkAtRow=Integer.parseInt(placeMarkAt[0])-1;
						human_placeMarkAtColumn=Integer.parseInt(placeMarkAt[1])-1;
						
						while((game.getBoard(human_placeMarkAtRow, human_placeMarkAtColumn))=='X'||(game.getBoard(human_placeMarkAtRow, human_placeMarkAtColumn))=='O')
						{
							System.out.println("that place on game board is already occupied");
							System.out.println("enter another input");
							String _placeMarkAt[]=sc.nextLine().split(" ");
							human_placeMarkAtRow=Integer.parseInt(_placeMarkAt[0])-1;
							human_placeMarkAtColumn=Integer.parseInt(_placeMarkAt[1])-1;
						}
						mark='X';
						move=move+1;
						game.setBoardMark(human_placeMarkAtRow, human_placeMarkAtColumn, mark);
						if(game.getAnyWinner()==1)
							break;

					
						
					}	
					if(game.getAnyWinner()==0)	//as there is no winner
						System.out.println("Game Draw");
					break;
					
			//player1=human and player2=computer
			case 3:	game.setComputer(1);
					while(game.getAnyWinner()==0)
					{
						char mark;
						//player1's turn (human's turn)
						String placeMarkAt[]=sc.nextLine().split(" ");
						human_placeMarkAtRow=Integer.parseInt(placeMarkAt[0])-1;
						human_placeMarkAtColumn=Integer.parseInt(placeMarkAt[1])-1;
						while((game.getBoard(human_placeMarkAtRow, human_placeMarkAtColumn))=='X'||(game.getBoard(human_placeMarkAtRow, human_placeMarkAtColumn))=='O')
						{
							System.out.println("that place on game board is already occupied");
							System.out.println("enter another input");
							String _placeMarkAt[]=sc.nextLine().split(" ");
							human_placeMarkAtRow=Integer.parseInt(_placeMarkAt[0])-1;
							human_placeMarkAtColumn=Integer.parseInt(_placeMarkAt[1])-1;
						}
						mark='X';
						move=move+1;
						game.setBoardMark(human_placeMarkAtRow, human_placeMarkAtColumn, mark);
						if(game.getAnyWinner()==1)
							break;
						if(move==9)	//if all places on the game board are occupied by marks so game is over(draw)
							break;
						//player2's turn (computer's turn)
						mark='O';
						move=move+1;
						int comp_placeMarkAtRow=0;
						int comp_placeMarkAtColumn=0;
						if(move==2)
						{
							if(game.getBoard(1,1)=='-')
							{
								comp_placeMarkAtRow=1;
								comp_placeMarkAtColumn=1;
								game.setBoardMark(comp_placeMarkAtRow, comp_placeMarkAtColumn, mark);
								System.out.println("computer's input "+(comp_placeMarkAtRow+1)+" "+(comp_placeMarkAtColumn+1));
							}
							else
								game.placeRandom();
						}
						else if(move==4||move==6||move==8)
						{
							int found=0;
							found=game.tryWin();
							if(found==0)
								found=game.block();
							if(found==0)
								game.placeRandom();
						}
						if(game.getAnyWinner()==1)
							break;
					}	
					if(game.getAnyWinner()==0)	//as there is no winner
						System.out.println("Game Draw");
					break;
		}
			
		sc.close();
	}

}
