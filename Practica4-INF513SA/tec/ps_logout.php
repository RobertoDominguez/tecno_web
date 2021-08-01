<?php
   session_start();
   if(($_SESSION['nivel'] == 1)or($_SESSION['nivel'] == 2))
   {
     session_unset();
     session_destroy();
     session_destroy();     
   }
   header ("Location: index.php");
?>