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
    public String parentReplyID;
    public String childReplyID;
    public String genericReplyID;
    
      public Reply() {
        username = "";
        threadID = "";
        content = "";
        time = null;
        parentReplyID = "";
        childReplyID = "";
        genericReplyID = "";
    }
      
      //reply to thread post
    public Reply(String username, String content, LocalDate time, String threadID) {
        this.username = username;
        this.content = content;
        this.time = time;
        this.threadID = threadID;
    }
    //reply with only a parent or only a child reply
    public Reply(String username, String content, LocalDate time, String threadID, String replyID) {
        this.username = username;
        this.content = content;
        this.time = time;
        this.threadID = threadID;
        this.genericReplyID = replyID;
    }
    //reply with parent and child reply
       public Reply(String username, String content, LocalDate time, String threadID,  String childReplyID, String parentReplyID) {
        this.username = username;
        this.content = content;
        this.time = time;
        this.threadID = threadID;
        this.childReplyID = childReplyID;
        this.parentReplyID = parentReplyID;
    }
       
    public String getChildReplyID(){
        
        return childReplyID;
    }
    
    public void setChildReplyID(String childReplyID){
        this.childReplyID = childReplyID;
    }
    
      public String getParentReplyID(){
        
        return parentReplyID;
    }
    
    public void setParentReplyID(String parentReplyID){
        this.parentReplyID = parentReplyID;
    }
    
      public String getGenericID(){
        
        return genericReplyID;
    }
    
    public void setGenericID(String replyID){
        this.genericReplyID = replyID;
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
