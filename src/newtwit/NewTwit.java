/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newtwit;

import javax.swing.JOptionPane;
import twitter4j.TwitterException;

/**
 *@version 1.2
 * @author Serg Bena
 */
public class NewTwit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws TwitterException {
        int op;
        MetoTwit obx=new MetoTwit();
        
        do{
        op=Integer.parseInt(JOptionPane.showInputDialog("Escoja la opcion deseada\n"+
                                       ("1-->Mandar Twit\n")+
                                        ("2-->Buscar Twit\n")+
                                        ("3-->Mirar ultimos twits\n")+
                                        ("4-->enviar mensaje")));
        switch(op=0){
            case 1:obx.post();
                break;
            case 2:obx.buscaJastak();
                break;
            case 3:obx.GettinTimeline();
                break;
            case 4:obx.mensajePrivado();
                break;
            case 5:System.exit(0);
        }
        }while(op==5);
    }
    
}
