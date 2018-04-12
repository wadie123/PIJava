/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Zanimaux.IService;


import java.sql.SQLException;
import java.util.List;
import pidev.Zanimaux.entities.PetSitter;

/**
 *
 * @author I eat ass
 */
public interface IPetSitter {
    
    public void AjouterPetSitter(PetSitter p) throws SQLException;
    public List<PetSitter> RetournerPetSitters() throws SQLException;
    public void ModifierPetSitter(PetSitter p, PetSitter m) throws SQLException;
    public void SupprimerPetSitter(PetSitter p) throws SQLException;
    public PetSitter getPSById(int p)throws SQLException;
    
}
