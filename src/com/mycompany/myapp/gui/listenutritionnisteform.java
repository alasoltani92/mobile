/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import static com.codename1.push.PushContent.setTitle;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.nutritionniste;
import com.mycompany.myapp.services.Serviceregime;
import com.mycompany.myapp.services.servicenutritionniste;

import java.util.ArrayList;
 

/**
 *
 * @author soltani med ala
 */
public class listenutritionnisteform extends Form{
      public listenutritionnisteform(Form previous) {
      
       setTitle("List nutritionniste");
        setLayout(BoxLayout.y());

       /* SpanLabel sp = new SpanLabel();
        servicenutritionniste ServicenutritionnisteInstance=new servicenutritionniste();
        sp.setText( servicenutritionniste.getInstance().affichagenutritionniste().toString());
        sp.setText(ServicenutritionnisteInstance
                .affichagenutritionniste().toString());
       add(sp);
       */
               servicenutritionniste ServicenutritionnisteInstance=new servicenutritionniste();
          ArrayList<nutritionniste> res= ServicenutritionnisteInstance.affichagenutritionniste();
          String j;
        for(int i=0; i<res.size();i++)
        {
            Form h1=new Form(BoxLayout.y());
             Label nom = new Label("nom : "+res.get(i).getNom().toString());
       
             Label prenom = new Label(" prenom : "+res.get(i).getPrenom().toString());
             Label mail = new Label(" e-mail : "+res.get(i).getMail().toString());
             Label addr = new Label(" adresse : "+res.get(i).getAddr().toString());
           // Label num = new Label(" telephone : "+res.get(i).getNum().toString());
             Label image = new Label(" image : "+res.get(i).getImage().toString());
 Label pass = new Label("------------------------------------------------");
          
         add(nom);
        add(prenom);
         add(mail);
         add(addr);
      //   add(num);
         add(image);
         add(pass);
        
        
        }
       getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
    
    
}
