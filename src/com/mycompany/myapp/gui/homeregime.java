/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import static com.codename1.push.PushContent.setTitle;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author soltani med ala
 */
public class homeregime extends Form {
     Form current;

public homeregime(Form previous){
   current = this; //Récupération de l'interface(Form) en cours
        setTitle("Home Regime");
        setLayout(BoxLayout.y());
        
      
     
           add(new Label("Choose an option"));

        Button btnAddregime = new Button("ajouter regime");
        Button btnListregime = new Button("List regime");
        Button uppdate = new Button("Gérer regime");
        Button IMC = new Button("IMC");
        btnAddregime.addActionListener(e -> new AddregimeForm(current).show());
        btnListregime.addActionListener(e -> new ListregimeForm(current).show());
        uppdate.addActionListener(e -> new rechercheformregime(current).show());
        addAll(btnListregime,IMC,btnAddregime, uppdate);
          IMC.addActionListener(e -> new IMC(current).show());
           
         
          getToolbar().addCommandToLeftSideMenu("List regime", null, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
        new ListregimeForm(current).show();
              

          }    
           } );
           getToolbar().addCommandToLeftSideMenu("ICM", null, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
              new IMC(current).show();                        
         }    
           } );
           getToolbar().addCommandToLeftSideMenu("ajouter regime", null, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
            new AddregimeForm(current).show();
            }    
           } );
           
           getToolbar().addCommandToLeftSideMenu("Gérer regime", null, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
              new rechercheformregime(current).show();
                        
         }    
           } );
             getToolbar().addCommandToLeftSideMenu("nutritionniste", null, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
        new homenutritionniste(current).show();
              

          }    
           } );
          
       getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
   FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);
        
       
       
    
}
}