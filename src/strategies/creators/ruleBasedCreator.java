/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategies.creators;
import strategies.productStrategy;
import strategies.concreteStrategies.ruleBased;
import strategies.creator;

/**
 *
 * @author johns
 */
public class ruleBasedCreator extends creator{
    @Override
    public productStrategy createStrategy(){
        return new ruleBased();
    }
}
