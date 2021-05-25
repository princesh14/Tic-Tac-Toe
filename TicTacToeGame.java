import java.util.*;
public class TicTacToeGame
{
    static String[] board;
    static String turn;
    
    static String checkWinner()
    {
        if( (!board[0].equals("1")) && board[0].equals(board[1]) && board[1].equals(board[2]) )
        return turn;
        if( (!board[3].equals("4")) && board[3].equals(board[4]) && board[4].equals(board[5]) )
        return turn;
        if( (!board[6].equals("7")) && board[6].equals(board[7]) && board[7].equals(board[8]) )
        return turn;
        if( (!board[0].equals("1")) && board[0].equals(board[3]) && board[3].equals(board[6]) )
        return turn;
        if( (!board[1].equals("2")) && board[1].equals(board[4]) && board[4].equals(board[7]) )
        return turn;
        if( (!board[2].equals("3")) && board[2].equals(board[5]) && board[5].equals(board[8]) )
        return turn;
        if( (!board[0].equals("1")) && board[0].equals(board[4]) && board[4].equals(board[8]) )
        return turn;
        if( (!board[2].equals("3")) && board[2].equals(board[4]) && board[4].equals(board[6]) )
        return turn;
        for (int a = 0; a < 9; a++) 
        {
            if (Arrays.asList(board).contains(String.valueOf(a + 1))) 
                break; 
            else if (a == 8) 
                return "draw"; 
        }
        String v = "X";
        if(turn.equals("X"))
            v = "O";
        System.out.println(v + "'s turn; enter a slot number to place " + v + " in:"); 
        return null; 
    }
    
    static void printBoard() 
    {
        System.out.println("|---|---|---|"); 
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |"); 
        System.out.println("|-----------|"); 
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |"); 
        System.out.println("|-----------|"); 
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |"); 
        System.out.println("|---|---|---|"); 
    }
  
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in); 
        board = new String[9]; 
        turn = "X"; 
        String winner = null; 
  
        for (int a = 0; a < 9; a++)
            board[a] = String.valueOf(a + 1);
  
        System.out.println("Welcome to 3x3 Tic Tac Toe."); 
        printBoard(); 
        System.out.println("X will play first. Enter a slot number to place X in:"); 
  
        while (winner == null)
        { 
            int numInput;
            numInput = in.nextInt(); 
            if (!(numInput > 0 && numInput <= 9))
            {
                System.out.println("Invalid input; re-enter slot number:"); 
                continue; 
            }
            if (board[numInput - 1].equals(String.valueOf(numInput))) 
            {
                board[numInput - 1] = turn;
                winner = checkWinner(); 
                if (turn.equals("X"))
                    turn = "O"; 
                else
                    turn = "X"; 
                printBoard();
            }
            else
                System.out.println("Slot already taken; re-enter slot number:"); 
        }
        if (winner.equals("draw"))
            System.out.println("It's a draw! Thanks for playing."); 
        else
            System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing."); 
    }
}