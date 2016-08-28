/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_tyrannosphere;

/**
 *
 * @author Gareth
 */
abstract class EVEObject {
    
    
    
    public EVEObject(){
        
    }
    
    
    abstract void update_position();
    abstract void update_dps();
    abstract void update_health();
    
}
