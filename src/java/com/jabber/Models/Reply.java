/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jabber.Models;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
/**
 *
 * @author David
 */
public class Reply implements Serializable {
    
    private String username;
    private String content;
    private LocalDate time;
    private String  threadID;
    
      public Reply() {
        username = "";
        threadID = "";
        content = "";
        time = null;
    }

    public Reply(String username, String content, LocalDate time, String threadID) {
        this.username = username;
        this.content = content;
        this.time = time;
        this.threadID = threadID;
    }
    
    public String getThreadID(){
        
        return threadID;
    }
    
    public void setThreadID(String threadID){
        this.threadID = threadID;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
   
   public void setContent(String content){
       this.content = content;
   }
   
   public String getContent(){
       return content;
       
   }
   public void setTime(LocalDate time){
       this.time = time;
   }
   
   public LocalDate getTime(){
       return time;
       
   }
    
}
