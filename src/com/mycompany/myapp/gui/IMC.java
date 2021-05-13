/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.maps.MapComponent;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import com.mycompany.myapp.entities.regime;
import com.mycompany.myapp.services.Serviceregime;
import com.mycompany.myapp.services.servicenutritionniste;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author soltani med ala
 */
public class IMC extends Form{
     float i,j;
     
    private Resources theme;
     public IMC(Form previous) {

                TextField poidsId= new TextField("", "Poids");
     TextField tailleId= new TextField("", "Taille");
    Label prenom = new Label("resultat                                                                                         \n");
       Button btnValider = new Button("Calculer IMC");
         addAll(poidsId,tailleId,btnValider,prenom);
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                 i=Float.parseFloat(poidsId.getText());
      j=Float.parseFloat(tailleId.getText());
              prenom.setText(""+  Serviceregime.getInstance().IMC(i,j));
                System.out.println(""+Serviceregime.getInstance().IMC(i,j));
          
            }
        });
     
         
    getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());

    
     
     }
    
}
