/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.regime;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



/**
 *
 * @author bhk
 */
public class Serviceregime {

   //singleton 
    public static Serviceregime instance = null ;
    
    public static boolean resultOk = true;

    //initilisation connection request 
    private ConnectionRequest req;
    
    
    public static Serviceregime getInstance() {
        if(instance == null )
            instance = new Serviceregime();
        return instance ;
    }
    
    
    
    public Serviceregime() {
        req = new ConnectionRequest();
        
    }
    
    
    //ajout 
    public Boolean ajoutRegime(regime regime) {
        
        String url =Statics.BASE_URL+"/addRegime?type="+regime.getType()+"&description="+regime.getDescription()+"&image="+regime.getImage();
        
        req.setUrl(url);
        req.addResponseListener((e) -> {
            
            String str = new String(req.getResponseData());
            System.out.println("data == "+str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
        return true;
    }
    
    
    //affichage
    
    public ArrayList<regime>affichageregime() {
        ArrayList<regime> result = new ArrayList<>();
        
        String url = Statics.BASE_URL+"/regime";
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp ;
                jsonp = new JSONParser();
             
                
                try {
                    Map<String,Object>mapregime = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    
                    List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) mapregime.get("root");
                    
                    for(Map<String, Object> obj : listOfMaps) {
                        regime re = new regime();
                        
                        //dima id fi codename one float 5outhouha
                        float id = Float.parseFloat(obj.get("id").toString());
                        
                        String type = obj.get("type").toString();
                        
                       String description = obj.get("description").toString();
                        String image = obj.get("image").toString();
                        
                        re.setId((int)id);
                        re.setType(type);
                        re.setDescription(description);
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
    
    
    
    //Detail Reclamation bensba l detail n5alihoa lel5r ba3d delete+update
    
    public ArrayList<regime> Detailregime  ( int id) {
        ArrayList<regime> result = new ArrayList<>();
        String url = Statics.BASE_URL+"/detailregime?id="+id;
            req.setUrl(url);
      
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp ;
                jsonp = new JSONParser();
            
                
                try {
                    Map<String,Object>mapregime = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                
                  
                        regime re = new regime();
                       
                        //dima id fi codename one float 5outhouha
                       float id = Float.parseFloat(mapregime.get("id").toString());
                        
                        String type = mapregime.get("type").toString();
                        
                        String description = mapregime.get("description").toString();
                        String image = mapregime.get("image").toString();
                         
                        re.setId((int)id);
                        re.setType(type);
                        re.setDescription(description);
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
    public void deleteregime(int id ) {
        String url = Statics.BASE_URL +"/delregime?id="+id;
        
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                    
                    req.removeResponseCodeListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
       // return  resultOk;
    }
    
    
    
    //Update 
    public boolean modifierregime(regime regime) {
        String url = Statics.BASE_URL +"/upregime?id="+regime.getId()+"&type="+regime.getType()+"&description="+regime.getDescription()+"&image="+regime.getImage();
       
        req.setUrl(url);
        
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