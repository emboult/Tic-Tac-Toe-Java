/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package strategies;
import gameplay.board;
/**
to interface tou strategy.
*einai KAI product tou factory KAI strategy interface (aaaaaaaaaaa)
* skopos toy einai na oeizei thn methodo pou prepei na ulopoiei
* upologizei thn kaluterh kinhsh gia ton paikth
* vres thn kaluterh kinhsh sto trexon board gia to ekshs sumvolo kai epestrepse thn thesh (0-8)
 */
public interface productStrategy {
    int getBestMove(board board, char symbol);
    
}
