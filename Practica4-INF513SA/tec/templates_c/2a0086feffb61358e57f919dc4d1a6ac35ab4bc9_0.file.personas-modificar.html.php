<?php
/* Smarty version 3.1.33, created on 2021-02-15 01:08:56
  from '/home/grupo12sa/Ronald_Saavedra/PRACTICO4_INF513/templates/personas-modificar.html' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_6029c9a88aaaa8_76141228',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    '2a0086feffb61358e57f919dc4d1a6ac35ab4bc9' => 
    array (
      0 => '/home/grupo12sa/Ronald_Saavedra/PRACTICO4_INF513/templates/personas-modificar.html',
      1 => 1613349256,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_6029c9a88aaaa8_76141228 (Smarty_Internal_Template $_smarty_tpl) {
$_smarty_tpl->_loadInheritance();
$_smarty_tpl->inheritance->init($_smarty_tpl, true);
?>


<?php 
$_smarty_tpl->inheritance->instanceBlock($_smarty_tpl, 'Block_5163810656029c9a889e911_39620911', 'contenido');
$_smarty_tpl->inheritance->endChild($_smarty_tpl, "layout.html");
}
/* {block 'contenido'} */
class Block_5163810656029c9a889e911_39620911 extends Smarty_Internal_Block
{
public $subBlocks = array (
  'contenido' => 
  array (
    0 => 'Block_5163810656029c9a889e911_39620911',
  ),
);
public function callBlock(Smarty_Internal_Template $_smarty_tpl) {
?>


<form  method="get" action="<?php echo $_smarty_tpl->tpl_vars['ps']->value;?>
">
    <input type="hidden" name="opcion" value="30"> 
    <h2><?php echo $_smarty_tpl->tpl_vars['titulo']->value;?>
<br></h2>
    
   <label for="foto" align="left">Foto</label>
    <input type="file" 	name="foto" id="foto" accept=".jpg,.png,.jpeg,.bmp" class="form-control" required>
    <br>
  
  <table >
    <tr>
      <td>Nombre :</td>
      <td><input type="text" name="nom"></td>
    </tr>
    <tr>
      <td>Apellidos :</td>
      <td><input type="text" name="appm"></td>
    </tr>
    <tr>
      <td>Telefono:</td>
      <td><input type="text" name="tel"></td>
    </tr>
    <tr>
      <td>Celular :</td>
      <td><input type="text" name="cel"></td>
    </tr>
    <tr>
      <td>E-Mail :</td>
      <td><input type="text" name="email"></td>
    </tr>
  
    <tr>
    <td>
          <input type="submit" name="Submit" value="Modificar">
    </td>
    </tr>
 </table>
    
</form>
<br>

<?php
}
}
/* {/block 'contenido'} */
}
