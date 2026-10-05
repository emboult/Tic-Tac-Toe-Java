/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategies.concreteStrategies;

import strategies.productStrategy;
import gameplay.board;

/**

ousiastika vathmologei kathe pithanh kinhsh kai epilegei authn me thn upshloterh vathmologia.
epalithevei kathe pithanh kinhsh
oso megalutero to score, toso kaluterh h nikh
* score:
* - kerdizw?: +50
* - mplokarw? +30
* - duo sth seira? +10
* - kentro? +5
* - gwnia? +3
* - allo? +1
* 
* 
 */

public class heuristic implements productStrategy {

    @Override
    // epistrefei thn kaluterh kinhsh ustera apo evaluate
    public int getBestMove(board board, char symbol) {
        char human = (symbol == 'X')? 'O': 'X';
        int[] empty= board.getEmptyCells();
        int bestScore = Integer.MIN_VALUE;
        int bestMove= -1;
        
        for (int i = 0; i < empty.length; i++){
            int pos= empty[i];
            int score = evaluate(board, pos, symbol, human);
            if (score>bestScore){
                bestScore=score;
                bestMove = pos;
                
            }
        }
        return bestMove;
    }
    
    //epistrefei thn kaluterh kinhsh kantontas simulate kai epistrefei score.
    private int evaluate(board board, int pos, char symbol, char human){
        int row= pos/3;
        int col = pos%3;
        int score=0;
        
        //kerdizw?
        if (board.willWin(row, col, symbol)){
            score+=50;
        }
        
        //mplokarw?
        if (board.willWin(row, col, human)){
            score+=30;
        }
        
        //kentro?
        if (board.isCenter(row, col)){
            score+=5;
        }
        
       //gwnia?
       
        if (board.isCorner(row, col)){
            score+=3;
        }
       
       //allo?
       if (score==0){
           score+=1;
       }
       return score;
    }
}