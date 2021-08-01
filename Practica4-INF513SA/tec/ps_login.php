<?php 
  include('/usr/share/php/adodb/adodb.inc.php');
  include('env.php');
  $user=$_GET['user'];
  $password=$_GET['password'];
  
  //***AHORA UTILIZAMOS ADODB PARA CONECTAR A LA BASE DE DATOS Y LOGRAR INDEPENDENCIA DE LA DB Y LA LG
  $db = ADONewConnection($dbdriver); 
  $db->debug = false; 
  $db->Connect($dbserver, $dbuser, $dbpassword, $dbname); 
  $rs = $db->Execute("SELECT * FROM permiso WHERE per_cod='$user' AND perm_pass='$password';"); 
  $db->Close();
  $user=$rs->GetArray(); 
  
  if (!$rs){
      print $db->ErrorMsg();
  }
  else
  {
      if (count($user)!=0)
      {          
           session_start();
           $_SESSION['nivel'] =$user[0]['per_type'];
           $_SESSION['ci'] = $user[0]['per_cod'];
           $_SESSION['usuario'] = $user[0]['per_nom'].' '.$user[0]['per_appm'];
           header ("Location: pc_menu.php"); 
      }
      else
      {
              require '/usr/share/php/Smarty/Smarty.class.php';
              $smarty = new Smarty;
              $smarty->compile_check = true;
              $smarty->debugging = false;
              $smarty->assign("titulo","Agenda Personal (tres capas)");
              //Menu
              $menu=array(
                          array('name'=>'Ingreso','url'=>'/pc_login.php'));
              $smarty->assign("menu",$menu);
              $smarty->assign("path",$path);
              //Contenido
              $smarty->assign("contenido","<h1>No tiene Acceso al Sistema</h1>");
              $smarty->display('bienvenido.html'); 
      }
  }     
    
?>