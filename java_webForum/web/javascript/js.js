/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = function() {
    
    
 
    
 
    $('.hideTheseReply').hide();
       
   
   $('button').click( function(){
       
  
        for(var i =0; i < $('.hideTheseReply').length + 1; i++)
        {
              
                   if( i == $(event.target).attr("id"))
                   {

                            $('#t'+ i).show();
                            $('#'+ i).hide();
                
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