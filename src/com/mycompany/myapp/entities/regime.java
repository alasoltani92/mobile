/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author bhk
 */
public class regime {

    private int id;
    private String type,description,image;

    public regime(String type, String description, String image) {
        this.type = type;
        this.description = description;
        this.image = image;
    }

    public regime() {
    }

    public regime(String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public regime(int id, String type, String description, String image) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.image = image;
    }

    @Override
    public String toString() {
        return "regime{" + "id=" + id + ", type=" + type + ", description=" + description + ", image=" + image + '}';
    }
    
  

    
    
}
