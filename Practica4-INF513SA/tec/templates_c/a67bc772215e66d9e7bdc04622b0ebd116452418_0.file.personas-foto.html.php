<?php
/* Smarty version 3.1.33, created on 2021-03-26 15:56:24
  from '/home/grupo12sa/Ronald_Saavedra/PRACTICO4_INF513/templates/personas-foto.html' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_605e042876d023_62275123',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    'a67bc772215e66d9e7bdc04622b0ebd116452418' => 
    array (
      0 => '/home/grupo12sa/Ronald_Saavedra/PRACTICO4_INF513/templates/personas-foto.html',
      1 => 1613359116,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_605e042876d023_62275123 (Smarty_Internal_Template $_smarty_tpl) {
$_smarty_tpl->_loadInheritance();
$_smarty_tpl->inheritance->init($_smarty_tpl, true);
?>


<?php 
$_smarty_tpl->inheritance->instanceBlock($_smarty_tpl, 'Block_1595734911605e0428755443_05356799', 'contenido');
$_smarty_tpl->inheritance->endChild($_smarty_tpl, "layout.html");
}
/* {block 'contenido'} */
class Block_1595734911605e0428755443_05356799 extends Smarty_Internal_Block
{
public $subBlocks = array (
  'contenido' => 
  array (
    0 => 'Block_1595734911605e0428755443_05356799',
  ),
);
public function callBlock(Smarty_Internal_Template $_smarty_tpl) {
?>


<td> <p align="left">Listado de Amigos : <b><?php echo $_smarty_tpl->tpl_vars['titulo']->value;?>
</b> </td>
 <br>
 
 <table>
  <tr>
  
    <td ><b>Nombres Completo</b></td>
    
  </tr>
<?php
$__section_pos_0_loop = (is_array(@$_loop=$_smarty_tpl->tpl_vars['amigosFoto']->value) ? count($_loop) : max(0, (int) $_loop));
$__section_pos_0_total = $__section_pos_0_loop;
$_smarty_tpl->tpl_vars['__smarty_section_pos'] = new Smarty_Variable(array());
if ($__section_pos_0_total !== 0) {
for ($__section_pos_0_iteration = 1, $_smarty_tpl->tpl_vars['__smarty_section_pos']->value['index'] = 0; $__section_pos_0_iteration <= $__section_pos_0_total; $__section_pos_0_iteration++, $_smarty_tpl->tpl_vars['__smarty_section_pos']->value['index']++){
?>

 <tr>
    <td ><?php echo $_smarty_tpl->tpl_vars['amigosFoto']->value[(isset($_smarty_tpl->tpl_vars['__smarty_section_pos']->value['index']) ? $_smarty_tpl->tpl_vars['__smarty_section_pos']->value['index'] : null)]['per_appm'];?>
  <?php echo $_smarty_tpl->tpl_vars['amigosFoto']->value[(isset($_smarty_tpl->tpl_vars['__smarty_section_pos']->value['index']) ? $_smarty_tpl->tpl_vars['__smarty_section_pos']->value['index'] : null)]['per_nom'];?>
 <?php echo $_smarty_tpl->tpl_vars['amigosFoto']->value[(isset($_smarty_tpl->tpl_vars['__smarty_section_pos']->value['index']) ? $_smarty_tpl->tpl_vars['__smarty_section_pos']->value['index'] : null)]['per_foto'];?>
 </td>
	 <td> ------> </td> 
        <td>
           <img  src="imagen/foto1.jpg"  alt="foto1.jpg" width="30%" height="30%" >
        </td>

       
  </tr>
<?php
}
}
?>

</table><br>

<?php
}
}
/* {/block 'contenido'} */
}
