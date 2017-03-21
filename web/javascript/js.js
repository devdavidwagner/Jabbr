/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = function() {
    
    
 
    
 
    $('.hideTheseReply').hide();
       
   
   $('button').on('click', function (event) { 
       
       
       var targ = $(event.target).attr("id");
       
       targ = targ.substring(0,3);
       
      
   
        
        if( targ == "sub")
        {
        
            var realTarg = $(event.target).attr("id");
            realTarg = realTarg.substring(3);
            
            
              for(var i =0; i < $('.hideTheseReply').length + realTarg; i++)
              {       


                         if( i == realTarg)
                         {

                                  $('#r'+ i).show();
                                  $('#sub'+ i).hide();

                                    break;
                           }


              }
        }
        else
        {
            
                for(var i =0; i < $('.hideTheseReply').length + $(event.target).attr("id"); i++)
                {       


                    if( i == $(event.target).attr("id"))
                    {

                             $('#t'+ i).show();
                             $('#'+ i).hide();

                               break;
                      }


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