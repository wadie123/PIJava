/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Zanimaux.IService;


import java.sql.SQLException;
import java.util.List;
import pidev.Zanimaux.entities.Lost;

/**
 *
 * @author I eat ass
 */
public interface ILost {
     public void AjouterPetSitter(Lost l) throws SQLException;
    public List<Lost> RetournerLosts() throws SQLException;
    public Lost getLostById(Lost l)throws SQLException;
    public void ModifierLost(Lost l, Lost m) throws SQLException;
    public void SupprimerLost(Lost l) throws SQLException;
}
