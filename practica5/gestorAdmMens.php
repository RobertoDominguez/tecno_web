<?php 
   include('ps_login.php');
   
   class CAdmMens
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
    			case 1201:{ //Registrar
    	        	 	     return $this->showMensaje("Registrar Mensaje","Aqui puedo colocar el codigo suficiente para <BR> REGISTRAR MENSAJES<BR>Puedes Registrar","");
    				  }
		               	  break;
		        case 1202:{ //Modificar 					    
		                      return $this->showMensaje("Modificar Mensaje","Aqui puedo colocar el codigo suficiente para <BR> MODIFICAR MENSAJES <BR> Puedes Modificar","");
    			          }
		               	  break;
		        case 1203:{ //Eliminiar
		                      return $this->showMensaje("Eliminar Mensaje","Aqui puedo colocar el codigo suficiente para <BR> ELIMINAR MENSAJES <BR> Puedes Eliminar","");	        	 		
    				  }
		               	  break;       	  
		        case 1204:{ //Listar    	        	 	   
		                      return $this->showMensaje("Listar Mensaje","Aqui puedo colocar el codigo suficiente para <BR> LISTAR MENSAJES <BR> Puedes Listar","");								        	 		
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
			
   $Mess = new CAdmMens();
   $html_out=$Mess->ejecutar($_REQUEST[opcion]);
	
   $Login = new CLogin();
   $Login->setOutputBody($html_out);      
   $Login->ejecutar();
?>
