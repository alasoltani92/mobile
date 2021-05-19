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
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.table.DefaultTableModel;
import com.codename1.ui.table.Table;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.table.TableModel;
import com.mycompany.myapp.entities.nutritionniste;
import com.mycompany.myapp.services.Serviceregime;
import com.mycompany.myapp.services.servicenutritionniste;

import java.util.ArrayList;
 

/**
 *
 * @author soltani med ala
 */
public class listenutritionnisteform extends Form{
    Form current;
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

String[][] rows = new String[res.size()][];
for(int i=0; i< rows.length;i++)
        { 
 rows[i] = new String[] {
res.get(i).getNom(),res.get(i).getPrenom().toString(),res.get(i).getMail().toString(),res.get(i).getAddr().toString()
                      ,res.get(i).getNum().toString(),res.get(i).getImage().toString()
    };
 }

TableModel model = new DefaultTableModel(new String[]
{"nom", "prenom", "e-mail","adresse", "telephone", "image"},  rows);
Table table = new Table(model);
add(table);
//
//        for(int i=0; i<res.size();i++)
//        {
//           Form h1=new Form(BoxLayout.y());
//             Label nom = new Label("nom : "+res.get(i).getNom().toString());
//       
//             Label prenom = new Label(" prenom : "+res.get(i).getPrenom().toString());
//             Label mail = new Label(" e-mail : "+res.get(i).getMail().toString());
//             Label addr = new Label(" adresse : "+res.get(i).getAddr().toString());
//             Label num = new Label(" telephone : "+res.get(i).getNum().toString());
//             Label image = new Label(" image : "+res.get(i).getImage().toString());
//             Label pass = new Label("------------------------------------------------");
//         
//       add(nom);
//       add(prenom);
//       add(mail);
//       add(addr);
//       add(num);
//       add(image);
//       add(pass);
//       
//        }
 getToolbar().addCommandToLeftSideMenu("List nutritionniste", null, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
        new listenutritionnisteform(current).show();
              

          }    
           } );
           getToolbar().addCommandToLeftSideMenu("Rendez-vous", null, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
              new maillingform(current).show();                        
         }    
           } );
           getToolbar().addCommandToLeftSideMenu("ajouter nutritionniste", null, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
            new AddnutritionnisteForm(current).show();
            }    
           } );
           
           getToolbar().addCommandToLeftSideMenu("Gérer nutritionniste", null, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
              new recherchenutritionniste(current).show();
                        
         }    
           } );
             getToolbar().addCommandToLeftSideMenu("Home regime", null, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
        new homeregime(current).show();
              

          } }
             );
        show();
         getToolbar().addSearchCommand(e -> {
    String text = (String)e.getSource();
            });
       getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
    
    
}
