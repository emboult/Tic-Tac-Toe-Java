/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gameplay;

/**
interface ths klashs inputOutput.
* periexei tis methodous displayBoard, getHumanMove, showMessage, showWinner, getStrategyChoice
 */
public interface view {
    void displayBoard(board board);
    int getHumanMove();
    void showMessage(String msg);
    void showWinner(char winner);
    //1=RB, 2=MM, 3= Heu
    int getStrategyChoice();
}
