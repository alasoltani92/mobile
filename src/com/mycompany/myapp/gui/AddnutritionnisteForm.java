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

/**
 *
 * @author bhk
 */
public class AddnutritionnisteForm extends Form{

    public AddnutritionnisteForm(Form previous) {
        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddTask, on peut y revenir
        en utilisant le bouton back
        */
        setTitle("Add a new nutritionniste");
        setLayout(BoxLayout.y());
        
        TextField tfnom = new TextField("","nom");
        TextField tfprenom= new TextField("", "prenom");
        TextField tfmail= new TextField("", "mail");
        TextField tfaddr = new TextField("","adresse");
        TextField tfnum = new TextField("","telephone");
        TextField tfimage = new TextField("","image");




        Button btnValider = new Button("Add nutritionniste");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfnom.getText().length()==0)||(tfprenom.getText().length()==0)||(tfmail.getText().length()==0)
                     ||(tfaddr.getText().length()==0)||(tfnum.getText().length()==0)||(tfimage.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        nutritionniste t = new nutritionniste(tfnom.getText(), tfprenom.getText(),tfmail.getText()
                        ,tfaddr.getText(),tfnum.getText(),tfimage.getText());
                        if( servicenutritionniste.getInstance().ajoutnutritionniste(t)){
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                            tfnom.clear();
                            tfprenom.clear();
                            tfmail.clear();
                            tfnum.clear();
                            tfaddr.clear();
                            tfimage.clear();
                                   
                        }
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfnom,tfprenom,tfimage,tfaddr,tfnum,tfmail,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> previous.showBack()); // Revenir vers l'interface précédente
                
    }
    
    
}
