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
import com.mycompany.myapp.entities.regime;
import com.mycompany.myapp.services.Serviceregime;
import com.mycompany.myapp.services.servicenutritionniste;

/**
 *
 * @author soltani med ala
 */
public class maillingform extends Form{
    
      
     public maillingform(Form previous) {
         
          setTitle("Contacter nutritionniste");
          setLayout(BoxLayout.y());

            TextField tfmail = new TextField("","mail nutritionniste");
            TextField tfmail1 = new TextField("","mail adherent");
            TextField tfmsg = new TextField("","message");
            Button btnenvoyer = new Button("envoyer");
            addAll(tfmail,tfmail1,tfmsg,btnenvoyer);
            
            getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
            btnenvoyer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfmail.getText().length()==0)||(tfmail1.getText().length()==0)||(tfmsg.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        regime t = new regime(tfmail.getText(), tfmail1.getText(),tfmsg.getText());
                        if( servicenutritionniste.getInstance().mail()){
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                                                    tfmail.clear();
                                                    tfmail1.clear();
                                                    tfmsg.clear();

                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
            }
            
            

             });
        
                    }}