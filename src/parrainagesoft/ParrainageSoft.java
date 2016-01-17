/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parrainagesoft;

import gestdonnee.pckg.MyDBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Neiba Aristide
 */
public class ParrainageSoft {
    
    private Boolean etatConnection=false;
    
    
    

    /** 
     *  @param args the command line arguments
     **/
    public static void main(String[] args) {
        
        // TODO code application logic here
        
        String url = "jdbc:mysql://localhost/bs_grid"; // 
        String user = "root"; // nom d'utilisateur a la bdd
        String mdp = ""; // mot de passe a la bdd
        String driver ="com.mysql.jdbc.Driver";
        //Main m = new Main();
        
        MyDBConnection bConnection = new MyDBConnection(driver, url, user, mdp);
        
        ResultSet resultSet = bConnection.setQuery("SELECT * FROM bs_grid.etudiants");
        
        try {
            for (int i = 0; i < resultSet.getFetchSize(); i++) {
                System.out.print("Try");
            }
            
            System.out.print(resultSet.getRow());
            //m.show(Boolean.TRUE);
        } catch (SQLException ex) {
            Logger.getLogger(ParrainageSoft.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
