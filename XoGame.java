import java.util.*;

class StartGame {
    private String board[][] = new String[3][3];
    String player1;
    String player2;
    String let;
    Scanner sc = new Scanner(System.in);

    StartGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = " ";
            }
        }
    }

    public void newgame() {
        System.out.println("Enter player one name");
        player1 = sc.next();
        System.out.println("Enter player two name");
        player2 = sc.next();
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                System.out.println(player1 + ":");
            } else {
                System.out.println(player2 + ":");
            }

            System.out.println("Enter your row position");
            int row = sc.nextInt();
            --row;
            System.out.println("Enter your column position");
            int column = sc.nextInt();
            --column;
            try {
                if (isValidMove(row, column)) {
                    if (i % 2 == 0) {
                        board[row][column] = "x";
                    } else {
                        board[row][column] = "o";
                    }
                    
                    let = board[row][column];//its denote x or o
                } else {
                    System.out.println("-------------------");
                    System.out.println("!! Invalid position !!");
                    System.out.println("-------------------");
                    i--; // Repeat the same turn for the same player.
                }
                display();
                if (i >= 4) {//after the 5th move the condition will check
                    if (checkWin()) {
                        System.out.println(let + " won the game!");
                        return;
                    }
                    if (i == 8) {
                        System.out.println("It's a draw!");
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println("-------------------");
                System.out.println("!! Invalid position !!");
                System.out.println("-------------------");
                i--;
            }
        }
    }

    public void display() {
        //its calls when the input entered
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "_|");
            }
            System.out.println();
        }
    }

    public boolean isValidMove(int row, int column) {
        //checking the valid move the move is correct or not
        return row >= 0 && row < 3 && column >= 0 && column < 3 && board[row][column].equals(" ");
    }

    public boolean checkWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(let) && board[i][1].equals(let) && board[i][2].equals(let)) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(let) && board[1][i].equals(let) && board[2][i].equals(let)) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0].equals(let) && board[1][1].equals(let) && board[2][2].equals(let)) {
            return true;
        }
        if (board[0][2].equals(let) && board[1][1].equals(let) && board[2][0].equals(let)) {
            return true;
        }

        return false;
    }
}

public class XoGame {
    public static void main(String[] args) {
        String option;
        Scanner oo=new Scanner(System.in);
        StartGame ob = new StartGame();
        while(true)
        {
        
        System.out.println("do you want to continue the new game");
        System.out.println("YES or NO");
            option=oo.next();
        if(option.equals("yes"))
        {
            ob.newgame();
        }
        else{
            System.exit(0);
        }
        }
    }
}
