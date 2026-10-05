/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameplay;

import java.util.Scanner;

/**
ulopoiei ta input-outputs ths efarmoghs.
o diaxwrismos ginetai edw kai oxi sthn main gia na sevastoume to (S)OLID.
* dhladh h main hdh kanei ta panta, to IO einai ligo too much -> S
 */
public class inputOutput implements view{
    private Scanner scanner;
    public inputOutput(){
        scanner = new Scanner(System.in);
    }
    
    @Override
    public void displayBoard(board board) {
        System.out.println("\n~~~~~~~~~~~\n");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board.getCell(i, j));
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
        System.out.println("\n~~~~~~~~~~~\n");
        System.out.println();
    }
    
    @Override
    public int getHumanMove(){
        System.out.println("Enter move: 0-8: ");
        int move = scanner.nextInt();
        return move;
    }
    
    @Override
    public void showMessage(String msg){
        System.out.println(msg);
    }
    
    @Override
    public void showWinner(char winner){
        if (winner == 'X'){
            System.out.println("X won");
        } else if (winner == 'O'){
            System.out.println("O won");
        } else{
            System.out.println("It's a tie");
        }
    }

    @Override
    public int getStrategyChoice(){
        System.out.println("\nAvailable Strategies:");
        System.out.println("1. Rule Based");
        System.out.println("2. Minimax");
        System.out.println("3. Heuristic");
        System.out.println("Enter choice (1-3):");
        int choice = scanner.nextInt();
        return choice;
    }
}
