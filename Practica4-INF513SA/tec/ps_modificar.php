<?php 
session_start();
if ($_SESSION['nivel'] == 2) {

include("conexion.php");

$ci=$_GET['ci'];
$nom=$_GET['nom'];
$app=$_GET['app'];
$tel=$_GET['tel'];
$cel=$_GET['cel'];
$dir=$_GET['dir'];
$fnac=$_GET['fnac'];

$link=Conectarse();

$sql = "UPDATE amigo SET amig_ci='$ci', amig_nombre='$nom', amig_appm='$app', amig_telf='$tel', amig_cel='$cel', amig_dir='$dir', amig_fnac='$fnac' WHERE amig_ci='$ci'";

echo $sql;
//****$result = mysql_query($sql);
$result = pg_query($sql);
?>
<html>
<head>
<title>PHP / MySQL</title>
</head>
<body>
<div align="center"> <strong>Datos ingresados!</strong>  <br>
  <br>
    
  <a href="pc_menu.php">Regresar al men&uacute;</a></div>
</body>
</html>

<?php

}else{
	header ("Location: index.php?error=No tiene acceso al sistema!!");
}
?>