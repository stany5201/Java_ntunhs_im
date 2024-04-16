package hw6;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class TicTacToeGame {
    private char[][] board;
    private char currentPlayer;

    public TicTacToeGame() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        currentPlayer = 'X'; // X starts the game
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean makeMove(int row, int col) {
        if (isValidMove(row, col)) {
            board[row][col] = currentPlayer;
            return true;
        } else {
            return false;
        }
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    public boolean hasWinner() {
        return checkWinner(currentPlayer);
    }

    private boolean checkWinner(char currentPlayer) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) return true;
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) return true;
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) return true;
        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // 新增一個方法來讓電腦玩家做出移動
    public void computerMove() {
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!isValidMove(row, col));
        board[row][col] = currentPlayer;
    }

    public char[][] getGameBoard() {
        return board;
    }
}

public class HW6 {Y
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;
        boolean playWithComputer = false;

        // 詢問是否與電腦對戰
        System.out.println("Do you want to play with computer? (Y/N)");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("Y")) {
            playWithComputer = true;
        }

        while (!gameEnded) {
            printBoard(game.getGameBoard());
            if (playWithComputer && game.getCurrentPlayer() == 'O') {
                // 電腦動作
                game.computerMove();
            } else {
                boolean validInput = false;
                while (!validInput) {
                    System.out.println("Player " + game.getCurrentPlayer() + ", enter your move (row [0-2] and column [0-2]): ");
                    try {
                        int row = scanner.nextInt();
                        int col = scanner.nextInt();
                        if (game.makeMove(row, col)) {
                            validInput = true;
                        } else {
                            System.out.println("This move at (" + row + "," + col + ") is not valid. Try again.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter numbers only.");
                        scanner.nextLine();
                    }
                }
            }

            if (game.hasWinner()) {
                gameEnded = true;
                printBoard(game.getGameBoard());
                System.out.println("Player " + game.getCurrentPlayer() + " wins!");
            } else if (game.isBoardFull()) {
                printBoard(game.getGameBoard());
                System.out.println("It's a tie!");
                break;
            } else {
                game.switchPlayer();
            }
        }

        scanner.close();
    }

    private static void printBoard(char[][] board) {
        System.out.println("Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("-+-+-");
        }
    }
}
