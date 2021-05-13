/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;

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
        Button map = new Button("maps");
        Button btnhomeregime = new Button("home regime");
        Button btnhomenut = new Button("home Nutritionniste");

        btnhomeregime.addActionListener(e -> new homeregime(current).show());
         btnhomenut.addActionListener(e -> new homenutritionniste(current).show());

          addAll(btnhomeregime,btnhomenut);
        
          map.addActionListener(e -> new maps(current).show());
        addAll(map);
         

        

    }

}
