/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = function() {
    
    
 
    
 
    $('.hideTheseReply').hide();
       
   
   $('button').click( function(){
       
  
       //i< MUST BE BIGGER THAN IS CURRENTLY
       //THREAD ID IS LARGER THAN LENGTH ONLY 2 loops
        for(var i =0; i < $('.hideTheseReply').length + $(event.target).attr("id"); i++)
        {       
          
                
                   if( i == $(event.target).attr("id"))
                   {
                    
                            $('#t'+ i).show();
                            $('#'+ i).hide();
                           
                              break;
                     }
              
                   
        }
                
     });
};


function checkPass()
    {
        var password = document.getElementById('pass').value;
        var passwordComf = document.getElementById('passComf').value;
        
        if (password != passwordComf)
        {
            return false;
        }
    
    }