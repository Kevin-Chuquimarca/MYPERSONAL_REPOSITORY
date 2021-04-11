/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.esu.espe.designpatterns.abstractfactory;

/**
 *
 * @author Kevin Chuquimarca ESPE-DCCO
 */
public class WinFactory extends GUIFactory{
    
    @Override
    public Button createButton(){
        Button button = new WinButton();
        return (button);
    }
    
    @Override
    public Menu createMenu(){
        return (new WinMenu());
    }
}
