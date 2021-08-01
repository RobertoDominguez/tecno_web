<?php 
session_start();
if ($_SESSION['nivel'] == 2) {

include("conexion.php");

$ci=$_GET['ci'];
$link=Conectarse();

$sql = "DELETE FROM amigo WHERE amig_ci = '$ci' ";

echo $sql;
//****$result = mysql_query($sql);
$result = pg_query($sql);
?>
<html>
<head>
<title>PHP / MySQL</title>
</head>
<body>
<div align="center"> <strong>Datos Eliminados!</strong>  <br>
  <br>
    
  <a href="pc_menu.php">Regresar al men&uacute;</a></div>
</body>
</html>

<?php

}else{
	header ("Location: index.php?error=No tiene acceso al sistema!!");
}
?>