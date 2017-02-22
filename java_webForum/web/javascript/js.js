/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = function() {
    
    
 
    
 
    $('.hideTheseReply').hide();
        
  

                $('#reply').click(function(){

                     var id = document.getElementById('asd').textContent;
                 
                    $('#'+ id).show();
                   $('#reply').hide();
                 
                 
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