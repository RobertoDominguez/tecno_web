<?php  
   
   include('env.php');
   require '/usr/share/php/Smarty/Smarty.class.php';
   $smarty = new Smarty;
   $smarty->compile_check = true;
   $smarty->debugging = false;
   $smarty->error_reporting = E_ALL & ~E_NOTICE;
   $smarty->assign("titulo","Agenda Personal Grupo 12 SA(Menu Dinamico)");  
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
   $smarty->assign("body","<center><h1>Agenda Personal<BR>INF513-SA</h1></center>");
   $smarty->assign("message","Bienvenido a la Agenda Personal INF513-SA");
   $smarty->display('bienvenido.html');
?>