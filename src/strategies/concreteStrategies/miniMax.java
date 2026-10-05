/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategies.concreteStrategies;

import strategies.productStrategy;
import gameplay.board;


/*
kanei recursive evaluation me oles tis pithanes kinhseis kai epilegei thn kaluterh dunath, ypothetwntas oti o paikths einai teleios.
score:
-ai:+10
-human:-10
-tie: 0
epistrefei thn kinhsh me to veltisto score.
*/
public class miniMax implements productStrategy {

    
    private char ai;
    private char human;
    
    
    //dokimazei kathe adeia thesh kai proswmoiwnei kinhsh tou AI kalwntas minmax() gia evaluation. epistrefei max score
    @Override
    public int getBestMove(board board, char symbol) {
        this.ai=symbol;
        this.human=(symbol == 'X') ? 'O' : 'X';
        int maxScore= Integer.MIN_VALUE;
        int maxMove=-1;
        //dokimazei ola ta adeia cells
        int[] empty = board.getEmptyCells();
        for (int i=0; i<empty.length; i++){
            int pos = empty[i];
            int row = pos/3;
            int col = pos%3;
            
            //kane kinhsh
            board.setCell(row, col, ai);
            int score = miniMax(board,0,false);
            //undo
            board.setCell(row, col, ' ');
            
            if (score>maxScore){
                maxScore=score;
                maxMove=pos;
            }
        }
        return maxMove;
    }
    
    //anadromikh methodos. epilegei thn megisth vathmologia an paizei to ai, alliws epilegei thn elaxisth an paizei xrhsths.
    //human(-10), tie(0), ai(10). 
    
    private int miniMax(board board, int depth, boolean isMaxmizing){
        if (board.isWin(ai)){
            return 10 - depth;
        } else if (board.isWin(human)){
            return depth - 10;
        } else if(board.isBoardFull()){
            return 0;
        }
        
        int[] empty = board.getEmptyCells();
        if (isMaxmizing){
            //ai
            int maxScore= Integer.MIN_VALUE;
            for (int i=0; i<empty.length; i++){
                int pos = empty[i];
                int row = pos/3;
                int col = pos%3;
                board.setCell(row, col, ai); //dokimazei
                // kalei anadromika thn minimax gia thn epomenh katastash pinaka
                int score = miniMax(board,depth+1,false); // false = seira human, depth+1=protimhsh grhgoroterwn nikwn
                board.setCell(row,col,' '); // paei pisw. theloume na afhsoume ton pinaka opws prin gia na dokimasei tis alles katastaseis.
                maxScore= Math.max(score, maxScore); //sugkrinei ta score.
            }
            return maxScore;
        } else{
            //human
            int minScore= Integer.MAX_VALUE;
            for (int i=0; i<empty.length; i++){
                int pos=empty[i];
                int row = pos/3;
                int col = pos%3;
                board.setCell(row, col, human);
                int score = miniMax(board,depth+1,true);
                board.setCell(row,col,' ');
                minScore= Math.min(score, minScore);
            }
            return minScore;
        }
    }
}