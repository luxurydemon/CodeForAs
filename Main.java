/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stage;

import data.Menu;

/**
 *
 * @author truonghxse616
 */
public class DogMangager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] mnl = new String[10];
        Menu m = new Menu(mnl);
        m.addMenu();
        m.printMn();
        m.choice();
    }
}
