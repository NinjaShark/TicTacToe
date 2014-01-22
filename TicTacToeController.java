import java.util.Scanner;

/**
 * TicTacToe Controller, handles logic for the game
 * @author Eileen Balci
 */
public class TicTacToeController{
	
	private static final int ROW = 3;
	private static final int COL = 3;
	private static final int X = 1; //X's
	private static final int O = 2; //O's

	private Scanner scan;
	private int[][] grid;
	private int winner, counter;

	/** constructor to initialize values and start game */
	public TicTacToeController(){
		scan = new Scanner(System.in);
		grid = new int[ROW][COL];
		winner = 0;
		counter = 0;
	}	

	public void playGame(){
		System.out.println("Would you like to play TicTacToe? (y/n)");
		String command = scan.next(); //get the next command from user
		while(!command.equalsIgnoreCase("n")){
			boolean hasWon = false;
			grid = reset(); //make sure the board is set to all 0's for a new game
			while(!hasWon){
				//time to play the game
				displayBoard(); //show the board
				askInput(counter); //as for user's move
				hasWon = isWinner();
				counter++; //turn is over, increase the counter for next turn
			}

			//display the final board
			displayBoard();
			
			if(winner == 1){
				System.out.println("X's Win!");
			}else if(winner == 2){
				System.out.println("O's Win!");
			}else{
				System.out.println("Tied Game!");
			}
			
			System.out.println("Would you like to play another game of TicTacToe? (y/n)");
			command = scan.next(); //get a y or n
		}
	}

	/** resets the board to init state */
	public int[][] reset(){
		counter = 0; //reset game counter
		winner = 0; //reset winner
		return new int[ROW][COL];
	}

	/** print out the board so the players can see what it looks like */
	public void displayBoard(){
		for(int i = 0; i < ROW; i++){
			for(int j = 0; j < COL; j++){
				if((i == 0 || i == 1 || i == 2) && j != 2){ //fill in horizontal values
					if(grid[i][j] == 1){
						System.out.print("X|");
					}else if(grid[i][j] == 2){
						System.out.print("O|");
					}else{
						System.out.print(" |");
					}
				}else if(j == 2){ //end of line, go to next line
					if(grid[i][j] == 1){
						System.out.println("X");
					}else if(grid[i][j] == 2){
						System.out.println("O");
					}else{
						System.out.println(" ");
					}
					if(i != 2){
						System.out.println("-+-+-");
					}
				}else{
					System.out.println("error");
				}						
			}
		}
	}

	/** Ask the user for token placement input */
	public void askInput(int turn){
		System.out.println("Enter a row: ");
		int row = scan.nextInt();
		System.out.println("Enter a col: ");
		int col = scan.nextInt();
		
		//using the counter, check who's turn it is
		//even turns are X, odd turns are O
		if(turn % 2 == 0){
			grid[row][col] = X;
		}else{
			grid[row][col] = O;
		}
	}	

	/**
	 * Win Senarios
	 *
	 * HORIZONTAL: 
 	 * 	[0][0], [0][1], [0][2]
	 *	[1][0], [1][1], [1][2]
	 *      [2][0], [2][1], [2][2]
	 * VERTICAL:
	 *	[0][0], [1][0], [2][0]
	 *	[0][1], [1][1], [2][1]
	 *	[0][2], [1][2], [2][2]
	 * DIAGONAL 
	 *	[0][0], [1][1], [2][2]
	 *	[0][2], [1][1], [2][0]
	 *
	 * Check if there is 3 in a row for these scenarios 
	 */
	public boolean isWinner(){
		if(grid[0][0] == 1 && grid[0][1] == 1 && grid[0][2] == 1){
			winner = 1;
			return true;
		}else if(grid[1][0] == 1 && grid[1][1] == 1 && grid[1][2] == 1){
			winner = 1;
			return true;
		}else if(grid[2][0] == 1 && grid[2][1] == 1 && grid[2][2] == 1){
                        winner = 1;
                        return true;
                }else if(grid[0][0] == 1 && grid[1][0] == 1 && grid[2][0] == 1){
                        winner = 1;
                        return true;
                }else if(grid[0][1] == 1 && grid[1][1] == 1 && grid[2][1] == 1){
                        winner = 1;
                        return true;
                }else if(grid[0][2] == 1 && grid[1][2] == 1 && grid[2][2] == 1){
                        winner = 1;
                        return true;
                }else if(grid[0][0] == 1 && grid[1][1] == 1 && grid[2][2] == 1){
                        winner = 1;
                        return true;
                }else if(grid[0][2] == 1 && grid[1][1] == 1 && grid[2][0] == 1){
                        winner = 1;
                        return true;
                }else if(grid[0][0] == 2 && grid[0][1] == 2 && grid[0][2] == 2){
                        winner = 2;
                        return true;
                }else if(grid[1][0] == 2 && grid[1][1] == 2 && grid[1][2] == 2){
                        winner = 2;
                        return true;
                }else if(grid[2][0] == 2 && grid[2][1] == 2 && grid[2][2] == 2){
                        winner = 2;
                        return true;
                }else if(grid[0][0] == 2 && grid[1][0] == 2 && grid[2][0] == 2){
                        winner = 2;
                        return true;
                }else if(grid[0][1] == 2 && grid[1][1] == 2 && grid[2][1] == 2){
                        winner = 2;
                        return true;
                }else if(grid[0][2] == 2 && grid[1][2] == 2 && grid[2][2] == 2){
                        winner = 2;
                        return true;
                }else if(grid[0][0] == 2 && grid[1][1] == 2 && grid[2][2] == 2){
                        winner = 2;
                        return true;
                }else if(grid[0][2] == 2 && grid[1][1] == 2 && grid[2][0] == 2){
                        winner = 2;
                        return true;
                }else{
			if(counter == 8){
				winner = 0; //no winner
				return true; //ends the game, but winner = 0 so the game is tied
			}else{
				//game isn't over yet
				winner = 0;
				return false;
			}	
		}
	}
} 
