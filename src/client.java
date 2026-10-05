/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import gameplay.inputOutput;
import gameplay.view;
import gameplay.board;
import gameplay.contextAI;
import gameplay.controller;
import strategies.productStrategy;
import strategies.creator;
import strategies.creators.ruleBasedCreator;
import strategies.creators.miniMaxCreator;
import strategies.creators.heuristicCreator;

/**
 *
 * @author johns
 */
public class client {
    public static void main(String[] args) {
        view view = new inputOutput();
        
        // pare epilogh
        int choice;
        creator strategyCreator = null;
        
        while (strategyCreator == null){
            choice = view.getStrategyChoice();
            
            switch(choice){
                case 1 -> strategyCreator= new ruleBasedCreator();
                case 2 -> strategyCreator = new miniMaxCreator();
                case 3 -> strategyCreator = new heuristicCreator();
                default -> view.showMessage("Invalid. Choose again.");
            }
        }
       
        // ftiakse product (strategy) apo factory
        productStrategy strategy = strategyCreator.createStrategy();
        
        // strategy context (to ai mas)
        contextAI ai = new contextAI(strategy, 'O');
        
        // ftiakse board
        board board = new board();
        
        controller controller = new controller(view, board, ai);
        controller.run();
        
    }
    
}
