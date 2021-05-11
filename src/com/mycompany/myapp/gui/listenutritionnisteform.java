/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import static com.codename1.push.PushContent.setTitle;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.mycompany.myapp.services.servicenutritionniste;
 

/**
 *
 * @author soltani med ala
 */
public class listenutritionnisteform extends Form{
      public listenutritionnisteform(Form previous) {
      
       setTitle("List nutritionniste");
     
        SpanLabel sp = new SpanLabel();
        servicenutritionniste ServicenutritionnisteInstance=new servicenutritionniste();
       sp.setText( servicenutritionniste.getInstance().affichagenutritionniste().toString());
        sp.setText(ServicenutritionnisteInstance
                .affichagenutritionniste().toString());
       add(sp);
       
       getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
    
    
}
