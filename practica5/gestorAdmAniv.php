<?php 
   include('ps_login.php');
   
   class CAdmAniv
   {          
		function showMensaje($titulo,$msg,$hiper)
		{
			$smarty_msg = new Smarty;
			$smarty_msg->compile_check = true;
			$smarty_msg->debugging = false;
			$smarty_msg->assign("titlemessages",$titulo);
			$smarty_msg->assign("messages",$msg);
			$smarty_msg->assign("linkbacks",$hiper);
			#Visualizar la informacion en el TEMPLATE
			return $smarty_msg->fetch('menu_msg.html');
		}   	
       
       function ejecutar($op)
       {   
       		//echo "Opcion =".$op."<br>";
   			switch($op) 
   			{
    			case 1301:{ //Registrar
    	        	 	    return $this->showMensaje("Registrar Aniversario","Aqui puedo colocar el codigo suficiente para <BR> REGISTRAR ANIVERSARIO<BR>Puedes Registrar","");
    				  }
		               	  break;
		        case 1302:{ //Modificar 					    
		                     return $this->showMensaje("Modificar Aniversario","Aqui puedo colocar el codigo suficiente para <BR> MODIFICAR ANIVERSARIO<BR> Puedes Modificar","");
    				  }
		               	  break;
		        case 1303:{ //Eliminiar
		                      return $this->showMensaje("Eliminar Aniversario","Aqui puedo colocar el codigo suficiente para <BR> ELIMINAR ANIVERSARIO<BR> Puedes Eliminar","");	        	 		
    			          }
		               	  break;       	  
		        case 1304:{ //Listar    	        	 	   
		                     return $this->showMensaje("Listar Aniversario","Aqui puedo colocar el codigo suficiente para <BR> LISTAR ANIVERSARIO<BR> Puedes Listar","");								        	 		
    				  }
		               	  break;       	  						  
    			default:{
    						print "<pre>"; 
					    	print_r($GLOBALS['_REQUEST']);					    	
							print "</pre>";
					        $msg= "Fallo en la peticion  ...".$op;
					        return $msg;
				
               			}                       
   			}
       }
   };
   
   /*	print "<pre>"; 
	print_r($GLOBALS['_REQUEST']);					    	
	print_r($GLOBALS['_SESSION']);	
	print "</pre>";*/
			
   $Aniv = new CAdmAniv();
   $html_out=$Aniv->ejecutar($_REQUEST[opcion]);
	
   $Login = new CLogin();
   $Login->setOutputBody($html_out);      
   $Login->ejecutar();
?>