/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.itunesapi;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mycompany.gui.ApiGui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author albus
 */
public class iTunesApi {

    public iTunesApi() {
        
    }
    
    
    public JsonObject getJson(String link){
        String response = "";
        try {
            URL url = new URL(link);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setRequestMethod("GET");
            int responseCode = httpCon.getResponseCode();

            System.out.println("RESPONSE CODE: " + responseCode);
            
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(httpCon.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response += inputLine;
            }
            in.close();

        } catch (MalformedURLException ex) {
            Logger.getLogger(ApiGui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(ApiGui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ApiGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();
        
        System.out.println("JSON: " + jsonObject.toString());
        
        return jsonObject;
        
    }
    
    
    
    
    
    
    
    
}
