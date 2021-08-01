<?php
/* Smarty version 3.1.33, created on 2021-02-15 01:01:29
  from '/home/grupo12sa/Ronald_Saavedra/PRACTICO4_INF513/templates/pc_login.html' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_6029c7e954f895_34075174',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    '663e474163c1a4ec3311c05ab949ff43b862334d' => 
    array (
      0 => '/home/grupo12sa/Ronald_Saavedra/PRACTICO4_INF513/templates/pc_login.html',
      1 => 1613349254,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_6029c7e954f895_34075174 (Smarty_Internal_Template $_smarty_tpl) {
$_smarty_tpl->_loadInheritance();
$_smarty_tpl->inheritance->init($_smarty_tpl, true);
?>


<?php 
$_smarty_tpl->inheritance->instanceBlock($_smarty_tpl, 'Block_18208109296029c7e9546253_42739511', 'contenido');
$_smarty_tpl->inheritance->endChild($_smarty_tpl, "layout.html");
}
/* {block 'contenido'} */
class Block_18208109296029c7e9546253_42739511 extends Smarty_Internal_Block
{
public $subBlocks = array (
  'contenido' => 
  array (
    0 => 'Block_18208109296029c7e9546253_42739511',
  ),
);
public function callBlock(Smarty_Internal_Template $_smarty_tpl) {
?>


<form  method="get" action="<?php echo $_smarty_tpl->tpl_vars['pslogin']->value;?>
">
   
      <h2><?php echo $_smarty_tpl->tpl_vars['titulo']->value;?>
<br></h2>
 
    <table >
      <tr>
        <td width="89">Usuario:</td>
        <td width="145"><input name="user" type="text"></td>
      </tr>
      <tr>
        <td>Password:</td>
        <td><input name="password" type="password"></td>
      </tr>
      <tr>
        <td colspan="2"><div align="center">
            <input type="reset" name="Reset" value="Limpiar">
            <input type="submit" name="Submit" value="Ingresar">
        </div></td>
      </tr>
    </table>
</form>
<br>

<?php
}
}
/* {/block 'contenido'} */
}
