/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.services.Serviceregime;
import com.mycompany.myapp.entities.regime;
import java.util.ArrayList;

/**
 *
 * @author bhk
 */
public class ListregimeForm extends Form{

    public ListregimeForm(Form previous) {
        setTitle("List regime");
            setLayout(BoxLayout.y());
       
        Serviceregime ServiceregimeInstance=new Serviceregime();
       //sp.setText( Serviceregime.getInstance().affichageregime().toString());
        ArrayList<regime> res= ServiceregimeInstance.affichageregime();
        for(int i=0; i<res.size();i++)
        {
            Form h1=new Form(BoxLayout.y());
             Label description = new Label("des : "+res.get(i).getDescription().toString());
        
             Label type = new Label(" type : "+res.get(i).getType().toString());
          
         add(description);
        
         add(type);
        
        
        }
        
       
       getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
    
    
}
