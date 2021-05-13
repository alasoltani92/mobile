/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.regime;
import com.mycompany.myapp.services.Serviceregime;

/**
 *
 * @author bhk
 */
public class AddregimeForm extends Form{

    public AddregimeForm(Form previous) {
        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddTask, on peut y revenir
        en utilisant le bouton back
        */
        setTitle("Add a new regime");
        setLayout(BoxLayout.y());
        
        ComboBox type=new ComboBox();
            
            type.addItem("prise de masse");
            type.addItem("minceur");
         
       // TextField tftype = new TextField("","type regime");
        TextField tfdescription= new TextField("", "description");
                TextField tfimage= new TextField("", "image");

        Button btnValider = new Button("Add regime");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfdescription.getText().length()==0)||(tfimage.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        regime t = new regime(type.getSelectedItem().toString(), tfdescription.getText(),tfimage.getText());
                        if( Serviceregime.getInstance().ajoutRegime(t))
                        {
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                            tfdescription.clear();
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
        
        addAll(type,tfdescription,tfimage,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> previous.showBack()); // Revenir vers l'interface précédente
          ;
    }
    
    
}
