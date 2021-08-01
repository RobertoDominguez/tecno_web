<?php
include('/usr/share/php/adodb/adodb-errorpear.inc.php');
include('/usr/share/php/adodb/tohtml.inc.php');

include('env.php');

require '/usr/share/php/Smarty/Smarty.class.php';
include("/usr/share/php/adodb/adodb.inc.php");
$id_=$_SESSION['ci'];
print($id_."1");
         if(isset($_GET['opcion'])){
             $op=$_GET['opcion'];
         }
         else{           
             $op=$_REQUEST['opcion'];
             $user=$_REQUEST['per_cod'];
         }
        switch($_REQUEST['opcion'])
        {
            case 1:{              
                session_start();
                if ($_SESSION['nivel'] == 0) { // Es el Propietario
                    
                    $smarty = new Smarty;
                    $smarty->compile_check = true;
                    $smarty->debugging = false;
                    $smarty->assign("titulo","Agenda Personal (tres capas)");
                    //Menu
                    $menu=array(
                        array('name'=>'Personas','url'=>'/personas.php'),
                        array('name'=>'Mensajes','url'=>'/mensajes.php'),
                        array('name'=>'Aniversarios','url'=>'/aniversarios.php'),
                        array('name'=>'Salir','url'=>'/ps_logout.php'));
                    $smarty->assign("menu",$menu);
                    $smarty->assign("path",$path);
                    $smarty->assign("ps","personas.php");
                    
                    #Visualizar la informacion en el TEMPLATE
                    $smarty->display('personas-nuevo.html');
                }
           
            }break;
            case 10:{
                $cod=$_GET['cod'];
                $nom=$_GET['nom'];
                $appm=$_GET['appm'];
                $prof=$_GET['prof'];
                $tel=$_GET['tel'];
                $cel=$_GET['cel'];
                $email=$_GET['email'];
                $dir=$_GET['dir'];
                $fnac=$_GET['fnac'];
                $lnac=$_GET['lnac'];
                $tipo=$_GET['tipo'];
                $pass=$_GET['pass'];
                
                //***AHORA UTILIZAMOS ADODB PARA CONECTAR A LA BASE DE DATOS Y LOGRAR INDEPENDENCIA DE LA DB Y LA LG
                $db = ADONewConnection($dbdriver);
                $db->debug = false;
                $sql="INSERT INTO persona VALUES ('$cod','$nom', '$appm','$prof', '$tel', '$cel', '$email', '$dir', '$fnac', '$lnac', '$tipo', '$pass', now(), now() );";
                //echo $sql;
                $db->Connect($dbserver, $dbuser, $dbpassword, $dbname);
                $rs = $db->Execute($sql);
                $content="<h1>La Operacion se realizo con Exito.</h1>";
                $db->Close();
                
                if (!$rs){
                    //print $db->ErrorMsg();
                    //header ("Location: ps_mensaje.php?def=Detalle&error=No se pudo realzar el Registro");
                    $e = ADODB_Pear_Error();
                    //echo '<p>',$e->message,'</p>';
                    $p1=stripos($e->message, '[');
                    $p2=stripos($e->message, ']');
                    $msg_error=substr($e->message, $p1,$p2-$p1+1);
                    $content="<h1>No se pudo realizar la Operacion.</h1> <h4>".$msg_error."</h4>";
                }
                //echo $content;
                
                $smarty = new Smarty;
                $smarty->compile_check = true;
                $smarty->debugging = false;
                $smarty->assign("titulo","Agenda Personal (tres capas)");
                //Menu
                $menu=array(
                    array('name'=>'Personas','url'=>'/personas.php'),
                    array('name'=>'Mensajes','url'=>'/mensajes.php'),
                    array('name'=>'Aniversarios','url'=>'/aniversarios.php'),
                    array('name'=>'Salir','url'=>'/ps_logout.php'));
                $smarty->assign("menu",$menu);
                $smarty->assign("path",$path);
                //Contenido
                $smarty->assign("contenido",$content);
                $smarty->display('bienvenido.html');
            }
            break;
            
            case 2:{
                echo "Mostrar: <br> Cod:".$user;
            }
            break;
            
            case 3:{
                session_start();
                if ($_SESSION['nivel'] == 0) { // Es el Propietario
                    
                    $smarty = new Smarty;
                    $smarty->compile_check = true;
                    $smarty->debugging = false;
                    $smarty->assign("titulo","Agenda Personal (tres capas) Modificar");
                    //Menu
                    $menu=array(
                        array('name'=>'Personas','url'=>'/personas.php'),
                        array('name'=>'Mensajes','url'=>'/mensajes.php'),
                        array('name'=>'Aniversarios','url'=>'/aniversarios.php'),
                        array('name'=>'Salir','url'=>'/ps_logout.php'));
                       
                    $smarty->assign("menu",$menu);
                    $smarty->assign("path",$path);
                    $smarty->assign("ps","personas.php");
                    
                    #Visualizar la informacion en el TEMPLATE
                    $smarty->display('personas-modificar.html');
                }else {
                    
                    $smarty = new Smarty;
                    $smarty->compile_check = true;
                    $smarty->debugging = false;
                    $smarty->assign("titulo","Agenda Personal (tres capas) Modificar");
                    //Menu
                    $menu=array(
                        array('name'=>'Personas','url'=>'/personas.php'),
                        array('name'=>'Mensajes','url'=>'/mensajes.php'),
                        array('name'=>'Salir','url'=>'/ps_logout.php'));
                    
                    $smarty->assign("menu",$menu);
                    $smarty->assign("path",$path);
                    $smarty->assign("ps","personas.php");
                    
                    #Visualizar la informacion en el TEMPLATE
                    $smarty->display("personas-modificar.html");
                      }
                
            }
            break;
            case 30:{
                session_start();
                $nom=$_GET['nom'];
                $appm=$_GET['appm'];
                $tel=$_GET['tel'];
                $cel=$_GET['cel'];
                $email=$_GET['email'];
                $foto=$_GET['foto'];
                $id = $_SESSION['ci'];
                //***AHORA UTILIZAMOS ADODB PARA CONECTAR A LA BASE DE DATOS Y LOGRAR INDEPENDENCIA DE LA DB Y LA LG
                $db = ADONewConnection($dbdriver);
                $db->debug = false;
                $sql="UPDATE persona set per_nom='$nom', per_appm='$appm', per_telf='$tel', per_cel='$cel', per_email='$email', per_foto='$foto' where per_cod='$id';";
               //print($id_."hola");
                //echo $sql;
                $db->Connect($dbserver, $dbuser, $dbpassword, $dbname);
                $rs = $db->Execute($sql);
                $content="<h1>La Modificacion se realizo con Exito.</h1>";
                $db->Close();
                
                if (!$rs){
                    //print $db->ErrorMsg();
                    //header ("Location: ps_mensaje.php?def=Detalle&error=No se pudo realzar el Registro");
                    $e = ADODB_Pear_Error();
                    //echo '<p>',$e->message,'</p>';
                    $p1=stripos($e->message, '[');
                    $p2=stripos($e->message, ']');
                    $msg_error=substr($e->message, $p1,$p2-$p1+1);
                    $content="<h1>No se pudo realizar la Operacion.</h1> <h4>".$msg_error."</h4>";
                }
                //echo $content;
                //session_start();
                if ($_SESSION['nivel'] == 0) { // Es el Propietario
                $smarty = new Smarty;
                $smarty->compile_check = true;
                $smarty->debugging = false;
                $smarty->assign("titulo","Agenda Personal (tres capas)");
                //Menu
                $menu=array(
                    array('name'=>'Personas','url'=>'/personas.php'),
                    array('name'=>'Mensajes','url'=>'/mensajes.php'),
                    array('name'=>'Aniversarios','url'=>'/aniversarios.php'),
                    array('name'=>'Salir','url'=>'/ps_logout.php'));
                    
                $smarty->assign("menu",$menu);
                $smarty->assign("path",$path);
                //Contenido
                $smarty->assign("contenido",$content);
                $smarty->display('bienvenido.html');
                
                }else {
                    $smarty = new Smarty;
                    $smarty->compile_check = true;
                    $smarty->debugging = false;
                    $smarty->assign("titulo","Agenda Personal (tres capas)");
                    //Menu
                    $menu=array(
                        array('name'=>'Personas','url'=>'/personas.php'),
                        array('name'=>'Mensajes','url'=>'/mensajes.php'),
                        array('name'=>'Salir','url'=>'/ps_logout.php'));
                        
                    $smarty->assign("menu",$menu);
                    $smarty->assign("path",$path);
                    //Contenido
                    $smarty->assign("contenido",$content);
                    $smarty->display('bienvenido.html');    
                }
                
            }
            break;
            
            case 4:{
                echo "Eliminar <br> Cod:".$user;
            }
            break;
            
            
            
            default:{
                session_start();
                if ($_SESSION['nivel'] == 0) { // Es el Propietario
                   
                    $db = ADONewConnection($dbdriver);
                    $db->debug = false;
                    $db->Connect($dbserver, $dbuser, $dbpassword, $dbname);
                    $result = $db->Execute("SELECT * FROM persona;");
                    $amigos=$result->GetArray();
                   
                    $titulo2="Listado de Amigos..";
                   
                    $smarty = new Smarty;
                    $smarty->compile_check = true;
                    $smarty->debugging = false;
                    $smarty->assign("titulo","Agenda Personal (tres capas)");
                    //Menu
                    $menu=array(
                        array('name'=>'Personas','url'=>'/personas.php'),
                        array('name'=>'Mensajes','url'=>'/mensajes.php'),
                        array('name'=>'Aniversarios','url'=>'/aniversarios.php'),
                        array('name'=>'Salir','url'=>'/ps_logout.php')); 
                  
                    $smarty->assign("menu",$menu);
                    $smarty->assign("path",$path);
                    $smarty->assign("titulo2",$titulo2);
                    $smarty->assign("amigos",$amigos);
                    #Visualizar la informacion en el TEMPLATE
                    $smarty->display('personas-listar.html');
                   
                }else{ // Es el Amigo
                    $db = ADONewConnection($dbdriver);
                    $db->debug = false;
                    $db->Connect($dbserver, $dbuser, $dbpassword, $dbname);
                    $result = $db->Execute("SELECT * FROM persona WHERE per_cod='".$_SESSION['ci']."';");
                    $amigos=$result->GetArray();
                   
                    $titulo2="Listado de Amigos..";
                   
                    $smarty = new Smarty;
                    $smarty->compile_check = true;
                    $smarty->debugging = false;
                    $smarty->assign("titulo","Agenda Personal (tres capas)");
                    //Menu
                    $menu=array(
                        array('name'=>'Personas','url'=>'/personas.php'),
                        array('name'=>'Mensajes','url'=>'/mensajes.php'),
                        array('name'=>'Salir','url'=>'/ps_logout.php'));
                  
                    $smarty->assign("menu",$menu);
                    $smarty->assign("path",$path);
                    $smarty->assign("titulo2",$titulo2);
                    $smarty->assign("amigos",$amigos);
                    #Visualizar la informacion en el TEMPLATE
                    $smarty->display('personas-listar.html'); 
                }
                            
            }
        }   
?>
