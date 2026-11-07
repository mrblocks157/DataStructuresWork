import java.util.Arrays;
import java.util.Scanner;
public class TicTacToe {
    char[][] board;
    boolean Xturn;
    public TicTacToe(){
        this.board = new char[3][3];
        for (char[] row : board) {
            Arrays.fill(row, '_');
        }
        this.Xturn = true;
    }

    public boolean move(int x, int y){
        if(((x>2 || x<0) || (y>2 || y<0))){
            return false;
        }
        if(board[x][y] != '_'){
            return false;
        }
        if(Xturn){
            board[x][y] = 'X';
            return true;
        }
        else{
            board[x][y] = 'O';
            return true;
        }
    }

    public boolean win(){
        char p = Xturn ? 'X' : 'O';
        if(board[0][0] == p && board[1][1] == p && board[2][2] == p){
            return true;
        }
        if(board[0][2] == p && board[1][1] == p && board[2][0] == p){
            return true;
        }
        for(int i = 0; i<3; i++){
            if(board[0][i] == p && board[1][i] == p && board[2][i] == p){
                return true;
            }
            if(board[i][0] == p && board[i][1] == p && board[i][2] == p){
                return true;
            }
        }
        return false;
    }

    public boolean isFull(){
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if (board[i][j] == '_') {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard(){
        for(int i=0; i<3; i++){
            for(int j = 0; j<3; j++){
                System.out.print("[" + board[i][j] + "]");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! Player X starts.");
        TicTacToe board = new TicTacToe();
        while(true){
            board.printBoard();
            System.out.println("Select your row (0, 1, 2)");
            int x = Integer.parseInt(scanner.nextLine());
            System.out.println("Select your column (0, 1, 2)");
            int y = Integer.parseInt(scanner.nextLine());
            if(!board.move(x,y)){
                System.out.println("Please select a valid row/column");
                continue;
            }
            if(board.win()){
                if(board.Xturn){
                    System.out.println("Player X wins!");
                }
                else{
                    System.out.println("Player O wins!");
                }
                break;
            }
            if(board.isFull()){
                System.out.println("It's a tie!");
                break;
            }
            board.Xturn = !board.Xturn;
        }
    }
}
