/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author soltani med ala
 */
public class nutritionniste {
 int id,num;
 String nom,prenom,addr,mail,image;

    @Override
    public String toString() {
        return "nutritionniste{" + "id=" + id + ", num=" + num + ", no=" + nom + ", prenom=" + prenom + ", addr=" + addr + ", mail=" + mail + ", image=" + image + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public nutritionniste() {
    }

    public nutritionniste( String no, String prenom, String addr, String mail,int num, String image) {
        this.num = num;
        this.nom = no;
        this.prenom = prenom;
        this.addr = addr;
                this.num = num;

        this.mail = mail;
        this.image = image;
    }

    public nutritionniste(int id, String nom, String prenom, String addr, String mail, String image) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.addr = addr;
        this.mail = mail;
        this.image = image;
    }

    public nutritionniste(int id, int num, String no, String prenom, String addr, String mail, String image) {
        this.id = id;
        this.num = num;
        this.nom = no;
        this.prenom = prenom;
        this.addr = addr;
        this.mail = mail;
        this.image = image;
    }
    
}
