<?php
   include('/usr/share/php/adodb/adodb.inc.php');
   require '/usr/share/php/Smarty/Smarty.class.php';   
   require 'env.php';    

   class CLogin
   {          
          var $db;         
          var $f_ini, $f_fin, $f_hoy;
          var $output_body="";       
          function setOutputBody($body)
          {
                 $this->output_body=$body;
          }
         
         /**
          * @return void
          * @param $titulo Cadena, Titulo a Visualizar(Codigo HTML)
          * @param $msg Cadena, Mensaje a Visualizar(Codigo HTML)
          * @param $hiper Cadena, Enlace a Visualizar(Codigo HTML)
          * @desc Genera un mensaje que el Usuario de DENEGACION del ingreso al sistema
 */
          function showMensaje($titulo,$msg,$hiper)
          {        
            $smarty = new Smarty;
            $smarty->compile_check = true;
            $smarty->debugging = true;
            $smarty->error_reporting = E_ALL & ~E_NOTICE;
            $smarty->assign("titulo",$titulo);
            //Menu
            $menu=array();
            $link=chop('ps_login.php'.'?'.'opcion=000','');
            $subMenu[0]=array('name'=>'Ingresar','param'=>'opcion=000','link'=>$link);
            $menu[0]=array('name'=>'Sistema','file'=>'ps_login.php','subMenu'=>$subMenu);
            /*echo "<pre>";
            print_r($menu);
            echo "</pre>";*/
           
            $smarty->assign("menu",$menu);
            $smarty->assign("path",$path);
            //Contenido
            $smarty->assign("titlemessages",$titulo);
            $smarty->assign("messages",$msg);
            $smarty->assign("linkbacks",$hiper);
            $smarty->display('mensaje.html');
          }         
          /**
          * @return Entero
          * @param $usuario Cadena
          * @param $contrasena Entero
          * @desc Verifica si los datos introducidos por el Usuario son validos y correctos, y tienen los permisos de acceso correctos
 */
          function verificarUser ($usuario, $contrasena)
       {     
          
            $db = ADONewConnection($GLOBALS['dbdriver']);
            $db->debug = true;
            $db->Connect($GLOBALS[dbserver], $GLOBALS[dbuser], $GLOBALS[dbpassword], $GLOBALS[dbname]);
            $sql="SELECT * FROM permiso WHERE per_cod='$usuario' AND perm_pass='$contrasena'";
            $rs = $db->Execute($sql);
            $db->Close();

           //echo 'User ='.$usuario.'   contrasena ='.$contrasena.'<br>';
           //echo 'SQL ='.$sql.'<br>';

           $perm = $rs->Getrows();
           /*print "<pre>";
           print_r($perm);
           print "</pre>";*/
           
           if(count($perm)>=1) // Es una persona de la agenda
           {   
               //echo "tu eres un usuario";
               /*print "<pre>";
                print_r($perm);
                print "</pre>";*/
               $this->f_ini=$perm[0][perm_fini];
               $this->f_fin=$perm[0][perm_ffin];
               switch ($perm[0][grup_cod])
               {
                   case 1:
                       {
                           return 1;//USUARIO AMIGO;
                       };
                       break;
                   case 2:
                       {
                           return 2;//USUARIO PROPIETARIO;
                       };
                       break;
                   default:
                       {
                           return -999;//OTRO TIPO ;
                       };
                       break;
               }       
             
           }
           else
           {
                  //echo "tu eres un usuario NO VALIDO";
                     return -1; //USUARIO NO VALIDO              
           }
       }         
      
 
       /**
       * @return void
       * @param $usuario Cadena, que contiene el codigo del usuario
       * @param $contrasena Entero, que contiene el password del user
       * @desc Genera la pantalla principal de la aplicacion en funcion a los parametros USUARIO y CONTRASE�A
 */
       function generarOpciones ($usuario, $contrasena)
       {                
              //echo 'User ='.$usuario.'   contrase�a='.$contrasena.'<br>';  
              $tipo=$this->verificarUser($usuario, $contrasena);             
              switch($tipo)
              {                                           
               case -1:{
                          $msg = "<center>";
                             $msg .= "SUS DATOS SON INCORRECTOS <br> Por favor verifique su informacion<br>caso contrario comuniquese con su Administrador de Agenda<br>" ; 
                             $msg .= "User :  $usuario <br>";
                          $msg .= "Password : $contrasena <br>";
                          $msg .= "</center>";
                          $titulo="Error al Ingresar la Agenda Personal";
                          $this->showMensaje($titulo,$msg,$hiper);
                          session_destroy();
                          exit;
                          }
                          break;
               default:{
                               $this->MostrarMenu($usuario, $contrasena);
                           }
                 }            
          }
          /**
          * @return void
          * @param $usuario Cadena, Login
          * @param $contrasena Entero, Password
          * @param $tipo Entero, el Tipo de usuario que es 0=super,1=bilbiotecario..5=Usuario
          * @desc Genera la pantalla principal de acuerdo a los permisos o grupos que tenga los usuarios en el sistema          
 */
          function MostrarMenu ($usuario, $contrasena)
          {
               /*$gestroDB = new CgestorDB();
               $gestroDB->conectar($db);*/
               $db = ADONewConnection($GLOBALS[dbdriver]);
               $db->debug = false;
               $db->Connect($GLOBALS[dbserver], $GLOBALS[dbuser], $GLOBALS[dbpassword], $GLOBALS[dbname]);
               /*Buscar Nombre Grupo de la Persona*/                
               $sql = 'SELECT p.grup_cod,g.grup_name FROM permiso AS p, grupo AS g WHERE per_cod=\''.$usuario.'\' AND perm_pass=\''.$contrasena.'\' AND p.grup_cod=g.grup_cod;';
               $rs  = $db->Execute($sql);
               $grup = $rs->Getrows();
               
               /*echo 'SQL ='.$sql.'<br>';
               print "<pre>";
               print_r($grup);
               print "</pre>";*/
               
               $codGrupo=$grup[0][grup_cod];
               $nomGrupo=$grup[0][grup_name];
               //AGREGANDO NIVEL
               session_start();
               $_SESSION[nivel]=$grup[0][grup_cod];
              
               /*Buscar Nombre de la Persona*/                           
               $sql = 'SELECT per_nom,per_appm,per_email FROM persona WHERE per_cod=\''.$usuario.'\';';              
               $rs  = $db->Execute($sql);
               $per = $rs->Getrows();
               /*echo 'SQL ='.$sql.'<br>';
               print "<pre>";
               print_r($per);
               print "</pre>";*/
               $nomUser=$per[0][per_appm].' '.$per[0][per_nom];              
               $emailUser=$per[0][per_email];
              
               /*Buscar Modulos Habilitados para el Usuario*/              
               $sql = 'SELECT mg.mod_cod,mod_name,mod_file FROM mod_grup AS mg,modulo AS m WHERE mg.grup_cod=\''.$codGrupo.'\' AND mg.mod_cod=m.mod_cod;';               
               $rs  = $db->Execute($sql);          
               $mod = $rs->Getrows();
               /*echo 'SQL ='.$sql.'<br>';
               print "<pre>";
               print_r($mod);
               print "</pre>";    */           
                
               $menu=array();
               for($i=0; $i<count($mod);$i++)
               {                 
                      /*Buscar Modulos Habilitados para el Usuario*/              
                      $codMod=$mod[$i][mod_cod];
                   $sql = 'SELECT acc_name,acc_param FROM accion AS a WHERE a.mod_cod=\''.$codMod.'\'';
                     $rs  = $db->Execute($sql);          
                   $acc = $rs->Getrows();                  
                   /*echo 'SQL ='.$sql.'<br>';
                   print "<pre>";
                   print_r($acc);
                   print "</pre>";*/
                  
                   $subMenu=array();
                   for($j=0; $j<count($acc);$j++)
                   {   
                         $link=chop(trim ($mod[$i][mod_file]).'?'.trim($acc[$j][acc_param]),'');
                        $subMenu[$j]=array('name'=>$acc[$j][acc_name],'param'=>$acc[$j][acc_param],'link'=>$link);
                   }
                   /*print "<pre>";
                   print_r($subMenu);
                   print "</pre>";*/
                      $menu[$i]=array('name'=>$mod[$i][mod_name],'file'=>$mod[$i][mod_file],'subMenu'=>$subMenu);   
               };
              
               $smarty = new Smarty;
               $smarty->compile_check = true;
               $smarty->debugging = false;
               $smarty->error_reporting = E_ALL & ~E_NOTICE;
               $smarty->assign("titulo","Agenda Personal (Menu Dinamico)");
               //Menu
               /*echo "<pre>";
               print_r($menu);
               echo "</pre>";*/
              
               $smarty->assign("menu",$menu);
               $smarty->assign("path",$path);              
               $smarty->assign("user",$nomUser." (".$nomGrupo.") ");
               $smarty->assign("email",$emailUser);
               //Contenido
               $smarty->assign("body",$this->output_body);
               $smarty->assign("message","Bienvenido a la Agenda Personal INF513");
               $smarty->display('pc_menu.html');
                      
        }
        /**
        * @return void
        * @desc Genera un cuadro de despedida del sistema elimando las variables de SESSION        
 */
        function Salir()
        {
           
            $msg = "<center>";
            $msg .= "AGRADECEMOS SU VISITA <br>" ;             
            $msg .= "</center>";
           
            /*$hiper .= "<center>";
            $hiper .= "SI DESEA REGRESAR A LA AGENDA <br>  de un click en el siguiente enlace <br>" ; 
            $hiper .= "<a class='rojo' href='http://mail.ficct.uagrm.edu.bo/inf513/grupo016sa'>";
            $hiper .=" <b>[Regresar a Ingreso AGENDA ]</b></a>";
            $hiper .= "</center>";*/
           
            $titulo=" su Agenda al servicio de ustedes ";
            $this->showMensaje($titulo,$msg,$hiper);
            session_unset();
            session_destroy();
        }
        function login()
        {   
            $smarty = new Smarty;
            $smarty->compile_check = true;
            $smarty->debugging = false;
            $smarty->error_reporting = E_ALL & ~E_NOTICE;
            $smarty->assign("titulo","Agenda Personal (Menu Dinamico)");
            //Menu
            $menu=array();
            $link=chop('ps_login.php'.'?'.'opcion=000','');
            $subMenu[0]=array('name'=>'Ingresar','param'=>'opcion=000','link'=>$link);
            $menu[0]=array('name'=>'Sistema','file'=>'ps_login.php','subMenu'=>$subMenu);
            /*echo "<pre>";
            print_r($menu);
            echo "</pre>";*/
            
            $smarty->assign("menu",$menu);
            $smarty->assign("path",$path);
            //Contenido
            $smarty->assign("ps","ps_login.php");
            $smarty->assign("body","<center><h1>Agenda Personal<BR>INF513-SA</h1></center>");
            $smarty->assign("message","Bienvenido a la Agenda Personal INF513-SA");
            $smarty->display('pc_login.html');            

        }
        function ejecutar()
        {
            session_start();
            //echo "server: $server - user $user - passwd $password  database $database <BR>";
             /*print "<pre>";
             print_r($_REQUEST);
             print_r($_SESSION);
             print "</pre>";*/
            if($_REQUEST['opcion']=='999'){                
                //echo "Eliminando variables registradas";
                $this->Salir();
            }
            elseif($_REQUEST['opcion']=='000'){               
                 $this->login();
            }
            elseif(!isset($_SESSION['usuario']))
            {                     
                //echo "variables NO registradas";
                $_SESSION[usuario]=$_REQUEST[user];
                $_SESSION[contrasena]=$_REQUEST[pass];
                $html_out="<h1>Bienvenido</h1>";
                
                $this->setOutputBody($html_out);   
                $this->generarOpciones($_SESSION[usuario],$_SESSION[contrasena]);                
            }
            else {
                //echo "variables Registradas";
                if($this->output_body<>"")
                      $this->generarOpciones($_SESSION[usuario],$_SESSION[contrasena]);
            }
                
        }
   }//eof class Login   

   $Login = new CLogin();
   $Login->ejecutar();
?>

