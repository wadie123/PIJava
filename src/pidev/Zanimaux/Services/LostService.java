/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Zanimaux.Services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import pidev.Zanimaux.IService.ILost;
import pidev.Zanimaux.entities.Lost;
import pidev.Zanimaux.utils.Myconnexion;

/**
 *
 * @author I eat ass
 */
public class LostService implements ILost{
    
      private Connection con = Myconnexion.getInstance().getConnection();
    private Statement ste;
    
    public LostService(){
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(LostService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void AjouterPetSitter(Lost l) throws SQLException {
        
        String req = "INSERT INTO lost (noml, typel, numl, ownerl, maill, urlimagelost) VALUES (?,?,?,?,?,?)";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setString(1, l.getNoml());
        pre.setString(2, l.getTypel());
        pre.setString(3, l.getNuml());
        pre.setString(4, l.getOwnerl());
        pre.setString(5, l.getMaill());
        pre.setString(6, l.getUrlimagelost());
        pre.executeUpdate();
    }

    @Override
    public List<Lost> RetournerLosts() throws SQLException {
       String req = "SELECT * FROM lost";
        ResultSet rs = ste.executeQuery(req);
        List<Lost> losts = new ArrayList<>();
        while (rs.next()){
            losts.add(new Lost(rs.getInt("id"), rs.getString("noml"), rs.getString("typel"), rs.getString("numl"), rs.getString("ownerl"), rs.getString("maill"), rs.getString("urlimagelost")));
        }
        return losts;
    }

    @Override
    public Lost getLostById(Lost l) throws SQLException {
         String req = "SELECT * FROM lost where id=?";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setInt(1, l.getId());
    
        //pre.executeQuery();
        ResultSet rs= pre.executeQuery();
        Lost x= new Lost();
         while (rs.next()){
            
            x.setId(rs.getInt("id"));
            x.setNoml(rs.getString("noml"));
            x.setTypel(rs.getString("typel"));
            x.setNuml(rs.getString("numl"));
            x.setOwnerl(rs.getString("ownerl"));
            x.setMaill( rs.getString("maill"));
            x.setUrlimagelost(rs.getString("urlimagelost"));
        }
        return x;
    }

    @Override
    public void ModifierLost(Lost l, Lost m) throws SQLException {
           String req = "UPDATE lost SET noml = ?, typel = ?, numl = ?, ownerl = ?, maill = ?, urlimagelost = ? WHERE id = ?";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setString(1, m.getNoml());
        pre.setString(2, m.getTypel());
        pre.setString(3, m.getNuml());
        pre.setString(4, m.getOwnerl());
        pre.setString(5, m.getMaill());
        pre.setString(6, m.getUrlimagelost());
        pre.setInt(7, l.getId());
        pre.executeUpdate();
        pre.close();
    }

    @Override
    public void SupprimerLost(Lost l) throws SQLException {
            String req = "DELETE FROM lost WHERE id = ?";
        PreparedStatement pre = con.prepareStatement(req);        
        pre.setInt(1,l.getId());
        pre.executeUpdate();  
    }
    
}
