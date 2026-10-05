/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameplay;
import strategies.productStrategy;
/**
apotelei to Context tou Strategy.
douleia tou einai na krataei mia anafora sto interface (productStrategy)
den gnwrizei poia strathgikh xrhsimopoieitai
 */
public class contextAI {
    private productStrategy strategy;
    private char symbol;
    
    public contextAI(productStrategy strategy, char symbol){
        this.strategy = strategy;
        this.symbol = symbol;
    }
    
    public void setStrategy(productStrategy strategy){
        this.strategy = strategy;
    }
    
    public int getMove(board board){
        return strategy.getBestMove(board, symbol);
    }
}
