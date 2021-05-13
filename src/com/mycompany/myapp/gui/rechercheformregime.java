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
     public rechercheformregime(Form previous) {
        setLayout(BoxLayout.y());
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
                 
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> previous.showBack()); // Revenir vers l'interface précédente
                         
}
}