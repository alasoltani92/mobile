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
       // setLayout(BoxLayout.y());

           add(new Label("Choose an option"));
        Button btnAddregime = new Button("Add regime");
        Button btnListregime = new Button("List regime");
        Button uppdate = new Button("Update");
        Button map = new Button("maps");
        btnAddregime.addActionListener(e -> new AddregimeForm(current).show());
        btnListregime.addActionListener(e -> new ListregimeForm(current).show());
        uppdate.addActionListener(e -> new rechercheformregime(current).show());
        addAll(btnAddregime, btnListregime,uppdate);

         map.addActionListener(e -> new maps(current).show());
        addAll(map);

       getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());

    
}
}