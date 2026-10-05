/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategies.concreteStrategies;

import strategies.productStrategy;
import gameplay.board;

/*
pretty much akolouthiakh logikh. rwtaei ton eauto tou (filosofizetai)
- mporw na kerdisw?
- na mplokarw?
- kentro?
- gwnia?
- allo?
*/
public class ruleBased implements productStrategy {

    @Override
    public int getBestMove(board board, char symbol) {
        char human = (symbol == 'X')? 'O' : 'X';
        int[] empty = board.getEmptyCells();
        
        //mporw na kerdisw?
        for (int i =0; i<empty.length; i++){
            int pos = empty[i];
            if (board.willWin(pos/3, pos%3, symbol)){
                return pos;
            }
        }
        //mplokarw?
        for (int i =0; i<empty.length; i++){
            int pos = empty[i];
            if (board.willWin(pos/3, pos%3, human)){
                return pos;
            }
        }
        //kentro?
        if (board.isCellEmpty(1, 1)){
            return 4;
        }
        
        //gwnia?
        for (int i =0; i<empty.length; i++){
            int pos = empty[i];
            if (board.isCorner(pos/3, pos%3)){
                return pos;
            }
        }
        //allo? paikse thn prwth diathesimh adeia thesh
        if (empty.length>0){
            return empty[0];
        }
        return -1;
    }
}
    

