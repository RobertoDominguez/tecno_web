<?php 
include('env.php');
session_start();
if ($_SESSION['nivel'] == 0) { // Es el Propietario
   require '/usr/share/php/Smarty/Smarty.class.php';
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
   $smarty->assign("usuario",$_SESSION['usuario']);
   $smarty->assign("contenido","<h1>Bienvenido Propietario</h1>");
   $smarty->display("pc_menu.html");

}else{ // Es el Amigo
   if ($_SESSION['nivel'] == 1) {
       require '/usr/share/php/Smarty/Smarty.class.php';
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
       $smarty->assign("usuario",$_SESSION['usuario']);
       $smarty->assign("contenido","<h1>Bienvenido Amigo</h1>");
       $smarty->display("pc_menu.html");
   }  
}
?>