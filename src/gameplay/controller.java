/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameplay;
import strategies.productStrategy;

/**
kanonika auta uphrxan sthn main alla diaxwristhkan logw SOLID.
 */
public class controller {
    private view view;
    private board board;
    private contextAI ai;
    private char currentPlayer;
    private boolean gameOver;
    
    public controller(view view, board board, contextAI ai){
        this.view=view;
        this.board=board;
        this.ai=ai;
        this.currentPlayer='X'; // X gia Xrhsths ksekinaei prwtos
        this.gameOver= false;
    }
    
    public void run(){
        while (!gameOver){
            view.displayBoard(board);
            if (currentPlayer=='X'){
                handleHuman();
            } else{
                handleAI();
            }
        }
    }
    
    private void handleHuman(){
        boolean valid = false;
        while (!valid){
            int moveIndex = view.getHumanMove();
            int row = moveIndex/3;
            int col = moveIndex%3;
            if (board.playMove(row, col, 'X')){
                valid = true;
            } else {
                view.showMessage("invalid");
            }
        }
        checkStatus('X');
    }
    
    private void handleAI(){
        int moveIndex = ai.getMove(board);
        int row = moveIndex/3;
        int col = moveIndex%3;
        board.playMove(row, col, 'O');
        checkStatus('O');
    }
    
    private void checkStatus(char player){
        if (board.isWin(player)){
            view.displayBoard(board);
            view.showWinner(player);
            gameOver=true;
        } else if (board.isBoardFull()){
            view.displayBoard(board);
            view.showWinner('/');
            gameOver = true;
        }
        else {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }
}
