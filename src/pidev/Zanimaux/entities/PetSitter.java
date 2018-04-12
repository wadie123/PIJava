/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Zanimaux.entities;

import java.util.Objects;

/**
 *
 * @author Wadie
 */
public class PetSitter {
    private int id;
    private String nom_p;
    private String adress_p;
    private String ville_p;
    private String phone_p;
    private String mail_p;
    private String urlimagesitter;

    public PetSitter() {
    }

    public PetSitter(String nom_p, String adress_p, String ville_p, String phone_p, String mail_p, String urlimagesitter) {
        this.nom_p = nom_p;
        this.adress_p = adress_p;
        this.ville_p = ville_p;
        this.phone_p = phone_p;
        this.mail_p = mail_p;
        this.urlimagesitter = urlimagesitter;
    }
        public PetSitter(String nom_p, String adress_p, String ville_p, String phone_p, String mail_p) {
        this.nom_p = nom_p;
        this.adress_p = adress_p;
        this.ville_p = ville_p;
        this.phone_p = phone_p;
        this.mail_p = mail_p;
        
    }

    public PetSitter(int id, String nom_p, String adress_p, String ville_p, String phone_p, String mail_p, String urlimagesitter) {
        this.id = id;
        this.nom_p = nom_p;
        this.adress_p = adress_p;
        this.ville_p = ville_p;
        this.phone_p = phone_p;
        this.mail_p = mail_p;
        this.urlimagesitter = urlimagesitter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_p() {
        return nom_p;
    }

    public void setNom_p(String nom_p) {
        this.nom_p = nom_p;
    }

    public String getAdress_p() {
        return adress_p;
    }

    public void setAdress_p(String adress_p) {
        this.adress_p = adress_p;
    }

    public String getVille_p() {
        return ville_p;
    }

    public void setVille_p(String ville_p) {
        this.ville_p = ville_p;
    }

    public String getPhone_p() {
        return phone_p;
    }

    public void setPhone_p(String phone_p) {
        this.phone_p = phone_p;
    }

    public String getMail_p() {
        return mail_p;
    }

    public void setMail_p(String mail_p) {
        this.mail_p = mail_p;
    }

    public String getUrlimagesitter() {
        return urlimagesitter;
    }

    public void setUrlimagesitter(String urlimagesitter) {
        this.urlimagesitter = urlimagesitter;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.nom_p);
        hash = 47 * hash + Objects.hashCode(this.adress_p);
        hash = 47 * hash + Objects.hashCode(this.ville_p);
        hash = 47 * hash + Objects.hashCode(this.phone_p);
        hash = 47 * hash + Objects.hashCode(this.mail_p);
        hash = 47 * hash + Objects.hashCode(this.urlimagesitter);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PetSitter other = (PetSitter) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom_p, other.nom_p)) {
            return false;
        }
        if (!Objects.equals(this.adress_p, other.adress_p)) {
            return false;
        }
        if (!Objects.equals(this.ville_p, other.ville_p)) {
            return false;
        }
        if (!Objects.equals(this.phone_p, other.phone_p)) {
            return false;
        }
        if (!Objects.equals(this.mail_p, other.mail_p)) {
            return false;
        }
        if (!Objects.equals(this.urlimagesitter, other.urlimagesitter)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PetSitter{" + "id=" + id + ", nom_p=" + nom_p + ", adress_p=" + adress_p + ", ville_p=" + ville_p + ", phone_p=" + phone_p + ", mail_p=" + mail_p + ", urlimagesitter=" + urlimagesitter + '}';
    }
    
    
    
}
