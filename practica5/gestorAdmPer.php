<?php
/*require '../smarty/libs/Smarty.class.php';
 include('gestorDB.php');*/
include('ps_login.php');

class CAdmPer
{
    function showMensaje($titulo,$msg,$hiper)
    {
        //echo "showMensaje($titulo,$msg,$hiper,$pie)<br>";
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
            case 1101:{ //aqui se debe realizar la tarea
                
               // return $this->showMensaje("Agregar Usuario","Aqui puedo colocar el codigo suficiente para <BR> ELIMINAR <BR> Puedes Eliminar","");
                
                $smarty = new Smarty;
                $smarty->compile_check = true;
                $smarty->debugging = true;
                $smarty->assign("titulo","Registrar Amigo");
                $smarty->assign("ps","gestorAdmPer.php");
                $smarty->assign("opcion","11011");
                
                #Visualizar la informacion en el TEMPLATE
                return $smarty->fetch('pc_per-new.html'); 
                
                
            
                
            }
            break;
            
            case 11011:{
                $cod=$_REQUEST['cod'];
                $nom=$_REQUEST['nom'];
                $appm=$_REQUEST['appm'];
                $prof=$_REQUEST['prof'];
                $tel=$_REQUEST['telf'];
                $cel=$_REQUEST['cel'];
                $email=$_REQUEST['email'];
                $dir=$_REQUEST['dir'];
                $fnac=$_REQUEST['fnac'];
                $lnac=$_REQUEST['lnac'];
                $tipo=$_REQUEST['tipo'];
                $pass=$_REQUEST['pass'];
                
                //ARCHIVO
                $foto=$_FILES['foto']['name'];
                $ruta=$_FILES['foto']['tmp_name'];
                
                
                $destino ="fotos/".$foto;
                copy($ruta,$destino);
                
                //***AHORA UTILIZAMOS ADODB PARA CONECTAR A LA BASE DE DATOS Y LOGRAR INDEPENDENCIA DE LA DB Y LA LG
                $db = ADONewConnection($GLOBALS[dbdriver]);
                $db->debug = false;
                $sqlper="INSERT INTO persona VALUES ('$cod', '$nom', '$appm','$prof', '$tel', '$cel', '$email', '$dir', '$fnac', '$lnac', true, now(), now(),'$destino' );";
                //echo $sqlper;
                $sqlperm="INSERT INTO permiso VALUES ('$cod',1,'$pass','".date("Y-m-d")."','".date("Y-m-d",strtotime(date("Y-m-d")."+ 365 days"))."', true, now(),now());";
                //echo $sqlperm;
                $db->Connect($GLOBALS[dbserver], $GLOBALS[dbuser], $GLOBALS[dbpassword], $GLOBALS[dbname]);
                $rs = $db->Execute($sqlper.'  '.$sqlperm);
                $content="<h1>La Operacion se realizo con Exito.</h1>";
                $db->Close();
                
                $usuario = $usuario.$_GET['nom']." ";
                $usuario = $usuario.$_GET['appm']." ";
                if ($rs === false){
                    return $this->showMensaje("Registrar Amigo","ERROR AL REGISTRAR","Ocurrio un Error al Registrar : ".$usuario."<BR>".$sql,"ERROR al Registrar...!!");
                }
                else {
                    return $this->showMensaje("Registrar Amigo","EXITO AL REGISTRAR","Se Registro Exitosamente los datos de : ".$usuario,"Amigo Registrado..!!!");
                }
            }
            break;
            
            case 1102:{ //Modificar
               // return $this->showMensaje("Modificar Usuario","Aqui puedo colocar el codigo suficiente para <BR> MODIFICAR <BR> Puedes Modificar","");
                session_start();
                $ci = $_GET['per_cod'];
                
                $smarty = new Smarty;
                $smarty->compile_check = true;
                $smarty->debugging = true;
                $smarty->assign("titulo","Modificar Amigos");
                $smarty->assign("ps","gestorAdmPer.php");
                $smarty->assign("opcion","11012");
                
                #Visualizar la informacion en el TEMPLATE
                return $smarty->fetch('pc_per-modificar.html');   
                
            }
            break;
            
            case 11012:{ 
                
                session_start();
                $ci=trim($_POST['cod']);
                $nom=$_POST['nom'];
                $app=$_POST['appm'];
                $tel=trim($_POST['telf']);
                $cel=trim($_POST['cel']);
                $correo=trim($_POST['email']);
                
                //ARCHIVO
                $foto=$_FILES['foto']['name'];
                $ruta=$_FILES['foto']['tmp_name'];                
                $destino ="fotos/".$foto;
                copy($ruta,$destino);
                
                if(isset($_POST["Submit"])) {
                    
                    $db = ADONewConnection($dbdriver);
                    $db->debug = true;
                    $db->Connect($dbserver, $dbuser, $dbpassword, $dbname);                   
                    
                    $sql = "UPDATE persona set per_nom = '$nom' ,per_appm = '$app' , per_telf='$tel', per_cel ='$cel', per_email= '$correo', per_foto = '$destino' WHERE per_cod='$ci'";
                    $rs = $db->Execute($sql);
                    $db->debug = false;
                    $db->Close();
                    if ($rs === false){
                        return $this->showMensaje("Modificar Amigo","ERROR AL MODIFICAR","El CI del usuario no está registrado : ".$usuario."<BR>".$sql,"ERROR al Modificar...!!");
                    }
                    else {
                        return $this->showMensaje("Modificar Amigo","EXITO AL REGISTRAR","Se Registro Exitosamente los datos de : ".$usuario,"Amigo Modificado..!!!");
                    } 
                }
            }
            break;
            
            case 1103:{ //Eliminar
                return $this->showMensaje("Eliminar Usuario","Aqui puedo colocar el codigo suficiente para <BR> ELIMINAR <BR> Puedes Eliminar","");
            }
            break;
            case 1104:{ //Listar
                //return $this->showMensaje("Listar Usuario","Aqui puedo colocar el codigo suficiente para <BR> LISTAR <BR> Puedes Listar","");
                $db = ADONewConnection($GLOBALS[dbdriver]);
                $db->debug = false;
                $db->Connect($GLOBALS[dbserver], $GLOBALS[dbuser], $GLOBALS[dbpassword], $GLOBALS[dbname]);
                $sql="SELECT * FROM persona;";
                $rs = $db->Execute($sql);
                $db->Close();
                $amigos=$rs->GetArray();
                /*echo "<pre>";
                 print_r($amigos);
                 echo "</pre>";*/
                
                if ($rs === false){
                    return $this->showMensaje("Listar Amigo","ERROR AL LISTAR","Ocurrio un Error al listar <BR>".$sql,"ERROR al Listar...!!");
                }else {
                    session_start();
                    $smarty = new Smarty;
                    $smarty->compile_check = true;
                    $smarty->debugging = true;
                    $smarty->assign("titulo","Listado de Amigos");
                    $smarty->assign("amigos",$amigos);
                    $smarty->assign("gestor","gestorAdmPer.php");
                    $smarty->assign("nuevo","1101");
                    $smarty->assign("mostrar","1105");
                    #Visualizar la informacion en el TEMPLATE
                    return $smarty->fetch('pc_per-listar.html');
                }
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

/*print "<pre>";
 print_r($GLOBALS['_REQUEST']);
 print_r($GLOBALS['_SESSION']);
 print "</pre>";*/

$User = new CAdmPer();
$html_out=$User->ejecutar($_REQUEST[opcion]);

$Login = new CLogin();
$Login->setOutputBody($html_out);
$Login->ejecutar();
?>
