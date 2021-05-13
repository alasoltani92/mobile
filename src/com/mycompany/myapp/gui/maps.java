/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.maps.MapComponent;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import com.mycompany.myapp.services.servicenutritionniste;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author soltani med ala
 */
public class maps extends Form{
   
    private Resources theme;
     public maps(Form previous) {
    
  try {
                Image imgPays = Image.createImage("/BRA.png");
                ImageViewer ivPays = new ImageViewer(imgPays);
                add(ivPays);
  }
 catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

         
         
    getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());

       
     
     }
    
}
