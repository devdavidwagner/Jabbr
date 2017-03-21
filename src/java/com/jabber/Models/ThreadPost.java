package com.jabber.Models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
public class ThreadPost implements Serializable {

    private String username;
 
    private String title;
    private String content;
    private LocalDate time;
    
    
    
    public ThreadPost() {
        username = "";
      
        title = "";
        content = "";
        time = null;
    }

    public ThreadPost(String username, String title, String content, LocalDate time) {
        this.username = username;
     
        this.title = title;
        this.content = content;
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

 
 
   public String getTitle(){
       return title;
       
   }
   
     public void setTitle(String title){
       this.title = title;
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
