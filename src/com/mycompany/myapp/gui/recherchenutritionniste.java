/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.nutritionniste;
import com.mycompany.myapp.services.servicenutritionniste;
import java.util.ArrayList;

/**
 *
 * @author soltani med ala
 */
public class recherchenutritionniste extends Form {
    Form current;
     public recherchenutritionniste(Form previous) {
        setLayout(BoxLayout.y());
          Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
        add(menuButton);
      setTitle("recherche nutritionniste");
        
        TextField tfid = new TextField("","id nutritionniste");
        TextField nom = new TextField("","nom nutritionniste");
         TextField prenom = new TextField("","prenom nutritionniste");
          TextField mail = new TextField("","mail nutritionniste");
         TextField addr = new TextField("","adresse nutritionniste");
         TextField num = new TextField("","telephone nutritionniste");
         TextField image = new TextField("","photo nutritionniste");

         Button btnValider = new Button("recherche");
          Button btnmodifier = new Button("modifier");
          Button btnsupp = new Button("supprimer");
         addAll(tfid,nom,prenom,mail,addr,num,image);
         addAll(btnValider,btnmodifier,btnsupp);
                 btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              
               
                   
                           
                         
      ArrayList<nutritionniste> res= servicenutritionniste.getInstance().Detailnutritionniste(Integer.parseInt(tfid.getText().toString()));
               
      nom.setText(res.get(0).getNom());
      prenom.setText(res.get(0).getPrenom());
      image.setText(res.get(0).getImage()); 
      num.setText(res.get(0).getNum());
      addr.setText(res.get(0).getAddr());
      mail.setText(res.get(0).getMail());

           
             
            }
        });
          
                 
              btnmodifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              nutritionniste t = new nutritionniste(Integer.parseInt( tfid.getText()),nom.getText(),prenom.getText(),image.getText(),addr.getText(),mail.getText());
                      if( servicenutritionniste.getInstance().modifiernutritionniste(t))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
               
           
              
            }
        });
 
                 
              btnsupp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
             // regime t = new regime(Integer.parseInt( tfid.getText()), type.getText(),desc.getText(),image.getText());
           
                servicenutritionniste.getInstance().deletenutritionniste(Integer.parseInt( tfid.getText().toString()));
                Dialog.show("Success","Connection accepted",new Command("OK"));
            }
        });         
               getToolbar().addCommandToLeftSideMenu("List nutritionniste", null, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
        new listenutritionnisteform(current).show();
              

          }    
           } );
           getToolbar().addCommandToLeftSideMenu("Rendez-vous", null, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
              new maillingform(current).show();                        
         }    
           } );
           getToolbar().addCommandToLeftSideMenu("ajouter nutritionniste", null, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
            new AddnutritionnisteForm(current).show();
            }    
           } );
           
           getToolbar().addCommandToLeftSideMenu("Gérer nutritionniste", null, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
              new recherchenutritionniste(current).show();
                        
         }    
           } );
             getToolbar().addCommandToLeftSideMenu("Home regime", null, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
        new homeregime(current).show();
              

          } }
             );
                 
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> previous.showBack()); // Revenir vers l'interface précédente
                         
}
    
}
