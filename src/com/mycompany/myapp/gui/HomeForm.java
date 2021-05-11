/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author bhk
 */
public class HomeForm extends Form {

    Form current;
    /*Garder traçe de la Form en cours pour la passer en paramètres 
    aux interfaces suivantes pour pouvoir y revenir plus tard en utilisant
    la méthode showBack*/
    
    public HomeForm() {
        current = this; //Récupération de l'interface(Form) en cours
        setTitle("Home");
        setLayout(BoxLayout.y());

        add(new Label("Choose an option"));
        Button btnAddregime = new Button("Add regime");
        Button btnListregime = new Button("List regime");
        Button btnAddnutritionniste = new Button("Add nutritionniste");
        Button btnListnutritionniste = new Button("List nutritionniste");
Button uppdate = new Button("Update");
Button map = new Button("maps");
        btnAddregime.addActionListener(e -> new AddregimeForm(current).show());
        btnListregime.addActionListener(e -> new ListregimeForm(current).show());
        addAll(btnAddregime, btnListregime);
        
        btnAddnutritionniste.addActionListener(e -> new AddnutritionnisteForm(current).show());
        btnListnutritionniste.addActionListener(e -> new listenutritionnisteform(current).show());
         uppdate.addActionListener(e -> new rechercheformregime(current).show());
        addAll(btnAddnutritionniste, btnListnutritionniste,uppdate);
        
          map.addActionListener(e -> new maps(current).show());
        addAll(map);


    }

}
