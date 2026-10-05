/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameplay;

/*
pretty much to model arxeio. 
periexei ena 3x3 board, playMove,
isWin, isBoardFull, isCellEmpty, getCell, getEmptyCells

relationships:
dhmiourgeitai apo client
xrhsimopoieitai apo view, contextAI
 */
public class board {
    private char[][] cells;
    //ftiaxnw keno board.
    public board(){
        cells = new char[3][3];
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                cells[i][j]=' ';
        }
    }
    
    public boolean playMove(int row, int col, char symbol){
        if (row < 0 || row > 2 || col < 0 || col > 2)
            return false; // an einai ektos orion, xese mas
        if (cells[row][col]!=' '){
            return false; //an empty, pali xese mas
        }
        cells[row][col]= symbol;
        return true; //ok edw mphke sumvolo
    }
    
    public boolean isWin(char symbol){
        for (int i=0; i<3; i++){
            //row
            if (cells[i][0]==symbol && cells[i][1]==symbol && cells [i][2]==symbol){
                return true;
            }
            // column
            if (cells[0][i]==symbol && cells[1][i]==symbol && cells [2][i]==symbol){
                return true;
            }
        }
            //diagwnios
        if (cells[0][0]==symbol && cells[1][1]==symbol && cells [2][2]==symbol){
            return true;
        } else if (cells[0][2]==symbol && cells[1][1]==symbol && cells [2][0]==symbol){
            return true;
        }
        return false;
    }
    
    
    //psaxnei ama einai gematos o pinakas, default true gt ksekinaei to paixnidi
    public boolean isBoardFull(){
        for (int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if (cells[i][j]==' '){
                    return false;
                }
            }
        }
        return true;
    }
    
    //an einai adeio
    public boolean isCellEmpty(int row, int col){
        // elegxos oriwn ksana gia autodunamia methodou
        if (row<0 || row > 2 || col<0 || col >2){
            return false;
        }
        return cells[row][col]==' '; 
        //epistrefei true an einai ontws ' ', alliws false
    }
    
    
    //epistrefei to symbolo
    public char getCell(int row, int col){
        if (row<0 || row > 2 || col<0 || col >2){
            return ' ';
        }
        return cells[row][col];
    }
    
    
    // se proswrino pinaka -> an keli adeio -> temp(count adeiwn) = i*3+j
    public int[] getEmptyCells(){
        int[] temp = new int[9];
        int count = 0;
        for(int i = 0; i<3; i++){
            for (int j=0; j<3; j++){
                if (cells[i][j] == ' '){
                    temp[count++]=i*3+j;
                }
            }
        }
        // o logos pou orizetai h result kai temp einai epeidh spane oi strathgikes.
        // auto epeidh oi strathgikes perimenoun pinaka me akrives megethos, pou periexei mono tis adeies theseis
        
        int[] result = new int[count];
        System.arraycopy(temp, 0, result, 0, count);
        return result;
    }
    
    
    //bonus: set cell se symbolo gia tis strathgikes, oxi gia paikth.
    // thn prosthesa gia logous enthulakwshs, kathws xwris auto apokalupte thn eswterikh anaparastash stis strathgikes
    // to pedio cells prepei na parameinei private kai pernaei apo thn setcell
    public void setCell(int row, int col, char symbol){
        if (row>=0 && row<3 && col>=0 && col<3){
            cells[row][col]=symbol;
        }
    }
    
    // kerdizw? - gia algorithmous
    public boolean willWin(int row, int col, char symbol){
        if (!isCellEmpty(row,col)){
            return false;
        }
        cells[row][col]=symbol;
        boolean wins = isWin(symbol);
        cells [row][col]= ' ';
        return wins;
    }
    
    public boolean isCenter(int row, int col){
        return row ==1 && col == 1;
    }
    
    public boolean isCorner(int row, int col){
        return (row == 0 || row == 2) && (col == 0 || col == 2);
    }
}
