/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import static com.codename1.push.PushContent.setTitle;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.regime;
import com.mycompany.myapp.services.Serviceregime;
import java.util.ArrayList;

/**
 *
 * @author soltani med ala
 */
public class rechercheformregime extends Form{
    Form current;
     public rechercheformregime(Form previous) {
        setLayout(BoxLayout.y());
          Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
        add(menuButton);
      setTitle("recherche regime");
        
        TextField tfid = new TextField("","id regime");
        TextField type = new TextField("","type regime");
         TextField desc = new TextField("","desc regime");
          TextField image = new TextField("","image regime");
         Button btnValider = new Button("recherche");
          Button btnmodifier = new Button("modifier");
          Button btnsupp = new Button("supprimer");
         addAll(tfid,type,desc,image);
         addAll(btnValider,btnmodifier,btnsupp);
                 btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              
               
                   
                           
                         
      ArrayList<regime> res= Serviceregime.getInstance().Detailregime(Integer.parseInt(tfid.getText().toString()));
         System.out.println("hhhhhhhhh"+res);
      type.setText(res.get(0).getType());
      desc.setText(res.get(0).getDescription());
      image.setText(res.get(0).getImage()); 
           
             
            }
        });
          
                 
              btnmodifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              regime t = new regime(Integer.parseInt( tfid.getText()), type.getText(),desc.getText(),image.getText());
                      if( Serviceregime.getInstance().modifierregime(t))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
               
           
              
            }
        });
 
                 
              btnmodifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
             // regime t = new regime(Integer.parseInt( tfid.getText()), type.getText(),desc.getText(),image.getText());
           
                Serviceregime.getInstance().deleteregime(Integer.parseInt( tfid.getText().toString()));
                Dialog.show("Success","Connection accepted",new Command("OK"));
            }
        });         
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
           
           getToolbar().addCommandToLeftSideMenu("G??rer regime", null, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
              new rechercheformregime(current).show();
                        
         }    
           } );
             getToolbar().addCommandToLeftSideMenu("nutritionniste", null, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
        new homenutritionniste(current).show();
              

          } }
             );         
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> previous.showBack()); // Revenir vers l'interface pr??c??dente
                         
}
}