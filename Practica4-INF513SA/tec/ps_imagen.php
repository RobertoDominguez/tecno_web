<?php
include('/usr/share/php/adodb/adodb-errorpear.inc.php');
include('/usr/share/php/adodb/tohtml.inc.php');

include('env.php');

require '/usr/share/php/Smarty/Smarty.class.php';
include("/usr/share/php/adodb/adodb.inc.php");

                session_start();
                if ($_SESSION['nivel'] == 0) { // Es el Propietario
                   
                    $db = ADONewConnection($dbdriver);
                    $db->debug = false;
                    $db->Connect($dbserver, $dbuser, $dbpassword, $dbname);
                    $result = $db->Execute("select per_nom, per_appm, per_foto from persona where per_foto is not null;");
                    $amigosFoto=$result->GetArray(); //foto
                                      
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
                    $smarty->assign("amigosFoto",$amigosFoto);
                    #Visualizar la informacion en el TEMPLATE
                    $smarty->display('personas-foto.html');
                   
                }else{ // Es el Amigo
                    $db = ADONewConnection($dbdriver);
                    $db->debug = false;
                    $db->Connect($dbserver, $dbuser, $dbpassword, $dbname);
                    $result = $db->Execute("SELECT per_nom, per_appm, per_foto FROM persona WHERE per_foto is not null and per_cod='".$_SESSION['ci']."';");
                    $amigosFoto=$result->GetArray(); //foto
             
                    
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
                    $smarty->assign("amigosFoto",$amigosFoto); //foto
                    
                    #Visualizar la informacion en el TEMPLATE
                    $smarty->display('personas-foto.html');
                }
                            
            
        
?>
