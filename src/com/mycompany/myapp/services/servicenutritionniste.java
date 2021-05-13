/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.components.ImageViewer;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.nutritionniste;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author bhk
 */
public class servicenutritionniste {

    //singleton 
    public static servicenutritionniste instance = null ;
    
    public static boolean resultOk = true;

    //initilisation connection request 
    private ConnectionRequest req;
    
    
    public static servicenutritionniste getInstance() {
        if(instance == null )
            instance = new servicenutritionniste();
        return instance ;
    }
    
    
    
    public servicenutritionniste() {
        req = new ConnectionRequest();
        
    }
    
    
    //ajout 
    public Boolean ajoutnutritionniste(nutritionniste nutritionniste) {
        
        String url =Statics.BASE_URL+"/addnutritionniste?no="+nutritionniste.getNom()+"&prenom="+nutritionniste.getPrenom()+"&addr="+nutritionniste.getAddr()+"&num="+nutritionniste.getNum()+"&mail="+nutritionniste.getMail()+"&image="+nutritionniste.getImage();
        
        req.setUrl(url);
        req.addResponseListener((e) -> {
            
            String str = new String(req.getResponseData());
            System.out.println("data == "+str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
        return true;
    }
    //mail
        public boolean mail () {
        String url = Statics.BASE_URL +"/e-mail";
        
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                    
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return  resultOk;
    }
    
    
    //affichage
    
    public ArrayList<nutritionniste>affichagenutritionniste() {
        ArrayList<nutritionniste> result = new ArrayList<>();
        
        String url = Statics.BASE_URL+"/nutritionniste";
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp ;
                jsonp = new JSONParser();
                
                try {
                    Map<String,Object>mapnutritionniste = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    
                    List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) mapnutritionniste.get("root");
                    
                    for(Map<String, Object> obj : listOfMaps) {
                        nutritionniste re = new nutritionniste();
                        
                        //dima id fi codename one float 5outhouha
                        float id = Float.parseFloat(obj.get("id").toString());
                        
                        String nom = obj.get("no").toString();
                        String prenom = obj.get("prenom").toString();
                        String addr = obj.get("addr").toString();
                        float num= Float.parseFloat(obj.get("num").toString());

                        String mail = obj.get("mail").toString();
                        String image = obj.get("image").toString();
                          
                        
                        re.setId((int)id);
                        re.setNom(nom);
                         re.setPrenom(prenom);
                        re.setAddr(addr);
                        re.setId((int)num);
                        re.setMail(mail);
                        re.setImage(image);
                        
                        //Date 
                       /* String DateConverter =  obj.get("date").toString().substring(obj.get("date").toString().indexOf("timestamp") + 10 , obj.get("date").toString().lastIndexOf("}"));
                        
                        Date currentTime = new Date(Double.valueOf(DateConverter).longValue() * 1000);
                        
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        String dateString = formatter.format(currentTime);
                        re.setDate(dateString);*/
                        
                        //insert data into ArrayList result
                        result.add(re);
                       
                    
                    }
                    
                }catch(Exception ex) {
                    
                    ex.printStackTrace();
                }
            
            }
        });
        
      NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

        return result;
        
        
    }
    
    
    
    //Detail nutritionniste bensba l detail n5alihoa lel5r ba3d delete+update
    
  public ArrayList<nutritionniste> Detailnutritionniste  ( int id) {
        ArrayList<nutritionniste> result = new ArrayList<>();
        String url = Statics.BASE_URL+"/detailnut?id="+id;
    
            req.setUrl(url);
      
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp ;
                jsonp = new JSONParser();
            
                
                try {
                 
                    Map<String,Object>mapnutritionniste = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                       
                        
                        nutritionniste re = new nutritionniste();
                       
                        //dima id fi codename one float 5outhouha
                      // float id = Float.parseFloat(mapnutritionniste.get("id").toString());
                        
                        String nom = mapnutritionniste.get("no").toString();                                                
                        String prenom = mapnutritionniste.get("prenom").toString();
                        String addr = mapnutritionniste.get("addr").toString();
                     //  float num = Float.parseFloat(mapnutritionniste.get("num").toString());
                      String num = mapnutritionniste.get("num").toString();
                        String image = mapnutritionniste.get("image").toString();
                       String mail = mapnutritionniste.get("mail").toString();
                        re.setId((int)id);
                        re.setNom(nom);
                        re.setPrenom(prenom);
                        re.setMail(mail);
                        re.setAddr(addr);
                        re.setNum(num);
                        re.setImage(image);
                       
                        //Date 
                       /* String DateConverter =  obj.get("date").toString().substring(obj.get("date").toString().indexOf("timestamp") + 10 , obj.get("date").toString().lastIndexOf("}"));
                        
                        Date currentTime = new Date(Double.valueOf(DateConverter).longValue() * 1000);
                        
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        String dateString = formatter.format(currentTime);
                        re.setDate(dateString);*/
                        
                        //insert data into ArrayList result
                       result.add(re);
                    
                    
                }catch(Exception ex) {
                    
                    ex.printStackTrace();
                }
            
            }
        });
        
      NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

        return result;
        
        
    }    
    
    //Delete 
    public boolean deletenutritionniste (int id ) {
        String url = Statics.BASE_URL +"/delnutritionniste?id="+id;
        
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                    
                    req.removeResponseCodeListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return  resultOk;
    }
    
    
    
    //Update 
    public boolean modifiernutritionniste(nutritionniste nutritionniste) {
        String url =Statics.BASE_URL+"/upnutritionniste?id="+nutritionniste.getId()+"&no="+nutritionniste.getNom()+"&prenom="+nutritionniste.getPrenom()+"&addr="+nutritionniste.getAddr()+"&num="+nutritionniste.getNum()+"&mail="+nutritionniste.getMail()+"&image="+nutritionniste.getImage();
        req.setUrl(url);
        System.out.println("urrlllll"+url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOk = req.getResponseCode() == 200 ;  // Code response Http 200 ok
                req.removeResponseListener(this);
            }
        });
        
    NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
    return resultOk;
        
    }
    

    
}