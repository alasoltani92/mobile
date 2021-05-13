/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author soltani med ala
 */
public class homenutritionniste extends Form{
      Form current;

public homenutritionniste(Form previous){
   current = this; //Récupération de l'interface(Form) en cours
        setTitle("Home Nutritionniste");
        setLayout(BoxLayout.y());

        Button btnListnutritionniste = new Button("List nutritionniste");
        Button btnAddnutritionniste = new Button("Add nutritionniste");

        Button btnmail = new Button("Prendre rendez-vous");
        Button uppdate = new Button("Update");
        btnAddnutritionniste.addActionListener(e -> new AddnutritionnisteForm(current).show());
        btnListnutritionniste.addActionListener(e -> new listenutritionnisteform(current).show());
        btnmail.addActionListener(e -> new maillingform(current).show());
        uppdate.addActionListener(e -> new recherchenutritionniste(current).show());


        addAll(btnListnutritionniste,btnmail,btnAddnutritionniste,uppdate );

       getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());

    
}
    
}
