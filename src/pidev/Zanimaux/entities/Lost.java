/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Zanimaux.entities;

/**
 *
 * @author I eat ass
 */
public class Lost {
    private int id;
    private String noml;
    private String typel;
    private String numl;
    private String ownerl;
    private String maill;
    private String urlimagelost;

    public Lost() {
    }

    public Lost(String noml, String typel, String numl, String ownerl, String maill, String urlimagelost) {
        this.noml = noml;
        this.typel = typel;
        this.numl = numl;
        this.ownerl = ownerl;
        this.maill = maill;
        this.urlimagelost = urlimagelost;
    }

    public Lost(int id, String noml, String typel, String numl, String ownerl, String maill, String urlimagelost) {
        this.id = id;
        this.noml = noml;
        this.typel = typel;
        this.numl = numl;
        this.ownerl = ownerl;
        this.maill = maill;
        this.urlimagelost = urlimagelost;
    }

    public int getId() {
        return id;
    }

    public String getNoml() {
        return noml;
    }

    public String getTypel() {
        return typel;
    }

    public String getNuml() {
        return numl;
    }

    public String getOwnerl() {
        return ownerl;
    }

    public String getMaill() {
        return maill;
    }

    public String getUrlimagelost() {
        return urlimagelost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNoml(String noml) {
        this.noml = noml;
    }

    public void setTypel(String typel) {
        this.typel = typel;
    }

    public void setNuml(String numl) {
        this.numl = numl;
    }

    public void setOwnerl(String ownerl) {
        this.ownerl = ownerl;
    }

    public void setMaill(String maill) {
        this.maill = maill;
    }

    public void setUrlimagelost(String urlimagelost) {
        this.urlimagelost = urlimagelost;
    }
     
}
