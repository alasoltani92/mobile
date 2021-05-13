/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.services.Serviceregime;
import com.mycompany.myapp.entities.regime;
import java.io.IOException;
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
            Form h1=new Form(BoxLayout.y());
        for(int i=0; i<res.size();i++)
        {
        
                             Label pass = new Label("------------------------------------------------");

             Label description = new Label("description : "+res.get(i).getDescription().toString());
        
             Label type = new Label(" type : "+res.get(i).getType().toString());
              try {
                Image imgPays = Image.createImage(""+res.get(i).getImage().toString());
                ImageViewer ivPays = new ImageViewer(imgPays);
                   add(ivPays);
                   
  }
 catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

            /* Image imgPays = Image.createImage("/" + res.get(i).getImage());
                            ImageViewer ivPays = new ImageViewer(imgPays);
                        ImageViewer iv2 = new ImageViewer(ivPays.getImage());*/

         add(description);
        //   add(iv2);
           add(type);
          add(pass);
        
        
        }
        
       
       getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
    
    
}
