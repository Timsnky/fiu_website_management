/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch3.sharedVariable;

/**
 *
 * @author adel
 */
public class Controller extends ch3.sharedVariable.error.Controller{
    
    @Override
    public void incrementSharedVariable(){
        synchronized(this){
            super.incrementSharedVariable();
        }
    }
}
