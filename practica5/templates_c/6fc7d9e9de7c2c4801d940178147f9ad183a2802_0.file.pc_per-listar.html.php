<?php
/* Smarty version 3.1.33, created on 2021-07-24 00:01:57
  from '/home/grupo01sa/Practica5/Taborga_Farel_Dennar/templates/pc_per-listar.html' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_60fb90b5d6ab16_91880772',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    '6fc7d9e9de7c2c4801d940178147f9ad183a2802' => 
    array (
      0 => '/home/grupo01sa/Practica5/Taborga_Farel_Dennar/templates/pc_per-listar.html',
      1 => 1627099299,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_60fb90b5d6ab16_91880772 (Smarty_Internal_Template $_smarty_tpl) {
?> <p align="left"> <b><?php echo $_smarty_tpl->tpl_vars['titulo']->value;?>
</b></td></p>
 <br>
 
 <?php if ($_SESSION['nivel'] == 2) {?>
 <a href="<?php echo $_smarty_tpl->tpl_vars['gestor']->value;?>
?opcion=<?php echo $_smarty_tpl->tpl_vars['nuevo']->value;?>
"> Nuevo</a>
 <?php }?>
 
 <table>
  <tr>
  	<td ><b>Foto </b></td>
    <td ><b>C.I.</b></td>
    <td ><b>Nombres Completo</b></td>
    <td ><b>Opciones</b></td>

  </tr>
  <?php
$__section_pos_0_loop = (is_array(@$_loop=$_smarty_tpl->tpl_vars['amigos']->value) ? count($_loop) : max(0, (int) $_loop));
$__section_pos_0_total = $__section_pos_0_loop;
$_smarty_tpl->tpl_vars['__smarty_section_pos'] = new Smarty_Variable(array());
if ($__section_pos_0_total !== 0) {
for ($__section_pos_0_iteration = 1, $_smarty_tpl->tpl_vars['__smarty_section_pos']->value['index'] = 0; $__section_pos_0_iteration <= $__section_pos_0_total; $__section_pos_0_iteration++, $_smarty_tpl->tpl_vars['__smarty_section_pos']->value['index']++){
?>
  <tr>
  <td ><b> </b></td>
  <!--
  	<td><img src="<?php echo $_smarty_tpl->tpl_vars['amigos']->value[(isset($_smarty_tpl->tpl_vars['__smarty_section_pos']->value['index']) ? $_smarty_tpl->tpl_vars['__smarty_section_pos']->value['index'] : null)]['per_foto'];?>
" alt="foto" width="100" height="100"></td> 
  	-->
    <td ><?php echo $_smarty_tpl->tpl_vars['amigos']->value[(isset($_smarty_tpl->tpl_vars['__smarty_section_pos']->value['index']) ? $_smarty_tpl->tpl_vars['__smarty_section_pos']->value['index'] : null)]['per_cod'];?>
</td>
    <td ><?php echo $_smarty_tpl->tpl_vars['amigos']->value[(isset($_smarty_tpl->tpl_vars['__smarty_section_pos']->value['index']) ? $_smarty_tpl->tpl_vars['__smarty_section_pos']->value['index'] : null)]['per_appm'];?>
 <?php echo $_smarty_tpl->tpl_vars['amigos']->value[(isset($_smarty_tpl->tpl_vars['__smarty_section_pos']->value['index']) ? $_smarty_tpl->tpl_vars['__smarty_section_pos']->value['index'] : null)]['per_nom'];?>
</td>    
    <td ><a href="<?php echo $_smarty_tpl->tpl_vars['gestor']->value;?>
.php?opcion=<?php echo $_smarty_tpl->tpl_vars['mostrar']->value;?>
&per_cod=<?php echo $_smarty_tpl->tpl_vars['amigos']->value[(isset($_smarty_tpl->tpl_vars['__smarty_section_pos']->value['index']) ? $_smarty_tpl->tpl_vars['__smarty_section_pos']->value['index'] : null)]['per_cod'];?>
"> Detalles</a></td>    
  </tr>
  <?php
}
}
?>
</table><br>
<?php }
}
