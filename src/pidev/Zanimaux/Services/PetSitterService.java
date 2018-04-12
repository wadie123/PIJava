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
import pidev.Zanimaux.IService.IPetSitter;
import pidev.Zanimaux.entities.PetSitter;
import pidev.Zanimaux.utils.Myconnexion;

/**
 *
 * @author I eat ass
 */
public class PetSitterService implements IPetSitter{
    private Connection con = Myconnexion.getInstance().getConnection();
    private Statement ste;
    
    public PetSitterService(){
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(PetSitterService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void AjouterPetSitter(PetSitter p) throws SQLException{
        String req = "INSERT INTO petsitter (nom_p, adress_p, ville_p, phone_p, mail_p, urlimagesitter) VALUES (?,?,?,?,?,?)";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setString(1, p.getNom_p());
        pre.setString(2, p.getAdress_p());
        pre.setString(3, p.getVille_p());
        pre.setString(4, p.getPhone_p());
        pre.setString(5, p.getMail_p());
        pre.setString(6, p.getUrlimagesitter());
        pre.executeUpdate();
    }
    
    @Override
    public List<PetSitter> RetournerPetSitters() throws SQLException{
        String req = "SELECT * FROM petsitter";
        ResultSet rs = ste.executeQuery(req);
        List<PetSitter> petsitters = new ArrayList<>();
        while (rs.next()){
            petsitters.add(new PetSitter(rs.getInt("id"), rs.getString("nom_p"), rs.getString("adress_p"), rs.getString("ville_p"), rs.getString("phone_p"), rs.getString("mail_p"), rs.getString("urlimagesitter")));
        }
        return petsitters;
    }

    @Override
    public void ModifierPetSitter(PetSitter p, PetSitter m) throws SQLException {
        String req = "UPDATE petsitter SET nom_p = ?, adress_p = ?, ville_p = ?, phone_p = ?, mail_p = ?, urlimagesitter = ? WHERE id = ?";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setString(1, m.getNom_p());
        pre.setString(2, m.getAdress_p());
        pre.setString(3, m.getVille_p());
        pre.setString(4, m.getPhone_p());
        pre.setString(5, m.getMail_p());
        pre.setString(6, m.getUrlimagesitter());
        pre.setInt(7, p.getId());
        pre.executeUpdate();
        pre.close();
    }

    @Override
    public void SupprimerPetSitter(PetSitter p) throws SQLException {
        String req = "DELETE FROM petsitter WHERE id = ?";
        PreparedStatement pre = con.prepareStatement(req);        
        pre.setInt(1,p.getId());
        pre.executeUpdate();        
    }

    @Override
    public PetSitter getPSById(int p) throws SQLException {
       String req = "SELECT * FROM PetSitter where id=?";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setInt(1, p);
    
        //pre.executeQuery();
        ResultSet rs= pre.executeQuery();
        PetSitter x= new PetSitter();
         while (rs.next()){
            
            x.setId(rs.getInt("id"));
            x.setNom_p(rs.getString("nom_p"));
            x.setAdress_p(rs.getString("adress_p"));
            x.setVille_p(rs.getString("ville_p"));
            x.setPhone_p(rs.getString("phone_p"));
            x.setMail_p(rs.getString("mail_p"));
            x.setUrlimagesitter(rs.getString("urlimagesitter"));
        }
        return x;
    }
}
