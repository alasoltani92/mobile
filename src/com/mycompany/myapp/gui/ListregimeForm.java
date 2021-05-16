/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.table.DefaultTableModel;
import com.codename1.ui.table.Table;
import com.codename1.ui.table.TableModel;
import com.mycompany.myapp.services.Serviceregime;
import com.mycompany.myapp.entities.regime;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author bhk
 */
public class ListregimeForm extends Form{
Form current;
    public ListregimeForm(Form previous) {
        setTitle("List regime");
            setLayout(BoxLayout.y());

        Serviceregime ServiceregimeInstance=new Serviceregime();
        
       //sp.setText( Serviceregime.getInstance().affichageregime().toString());
        ArrayList<regime> res= ServiceregimeInstance.affichageregime();
//        String[][] rows = new String[res.size()][];
//for(int i=0; i< rows.length;i++)
//        { 
// rows[i] = new String[] {
//res.get(i).getType(),res.get(i).getDescription().toString(),res.get(i).getImage().toString()
// };
// }
//
//TableModel model = new DefaultTableModel(new String[]
//{"Type", "Description", "Image"},  rows);
//Table table = new Table(model);
//add(table);

            Form h1=new Form(BoxLayout.y());
        for(int i=0; i<res.size();i++)
        {
             Label pass = new Label("______________________________________________________________________________________________________________________________");
             Label evaluation =new Label("evaluation");
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
            Slider s=new Slider();
            s.setMinValue(1);
            s.setMaxValue(11);
            s.setEditable(true);
            s.addDataChangedListener(new DataChangedListener() {
                 @Override
                 public void dataChanged(int type, int index) {
                 evaluation.setText("Evaluation : "+s.getProgress());                 }
             });
           
            Button valider = new Button("Valider");
            valider.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent evt) {
                     Dialog.show("confirmation", "vous avez atribué l'levaluation de : "+s.getProgress()+
                            "regime", "ok","annuler") ;               
                 }
      
                 });
            /* Image imgPays = Image.createImage("/" + res.get(i).getImage());
                            ImageViewer ivPays = new ImageViewer(imgPays);
                        ImageViewer iv2 = new ImageViewer(ivPays.getImage());*/

          add(description);
          add(type);
          add(s);
          add(evaluation);
          add(valider);
          add(pass);
        
        
        
               show();
      getToolbar().addCommandToLeftSideMenu("List regime", null, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
        new ListregimeForm(current).show();
              

          }    
           } );
           getToolbar().addCommandToLeftSideMenu("ICM", null, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
              new IMC(current).show();                        
         }    
           } );
           getToolbar().addCommandToLeftSideMenu("ajouter regime", null, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
            new AddregimeForm(current).show();
            }    
           } );
           
           getToolbar().addCommandToLeftSideMenu("Gérer regime", null, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
              new rechercheformregime(current).show();
                        
         }    
           } );
             getToolbar().addCommandToLeftSideMenu("nutritionniste", null, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
        new homenutritionniste(current).show();
              

          } }
             );
       getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
    }}
    

