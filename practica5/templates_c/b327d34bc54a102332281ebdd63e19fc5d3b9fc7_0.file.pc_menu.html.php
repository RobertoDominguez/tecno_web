<?php
/* Smarty version 3.1.33, created on 2021-07-25 15:06:06
  from '/home/grupo12sa/practica5/templates/pc_menu.html' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_60fdb61e8662a6_53645526',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    'b327d34bc54a102332281ebdd63e19fc5d3b9fc7' => 
    array (
      0 => '/home/grupo12sa/practica5/templates/pc_menu.html',
      1 => 1627228793,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_60fdb61e8662a6_53645526 (Smarty_Internal_Template $_smarty_tpl) {
$_smarty_tpl->_loadInheritance();
$_smarty_tpl->inheritance->init($_smarty_tpl, true);
?>


<?php 
$_smarty_tpl->inheritance->instanceBlock($_smarty_tpl, 'Block_53970267160fdb61e861069_97917165', "cuerpo");
$_smarty_tpl->inheritance->endChild($_smarty_tpl, "layout.html");
}
/* {block "cuerpo"} */
class Block_53970267160fdb61e861069_97917165 extends Smarty_Internal_Block
{
public $subBlocks = array (
  'cuerpo' => 
  array (
    0 => 'Block_53970267160fdb61e861069_97917165',
  ),
);
public function callBlock(Smarty_Internal_Template $_smarty_tpl) {
?>


<?php echo $_smarty_tpl->tpl_vars['body']->value;?>


<?php
}
}
/* {/block "cuerpo"} */
}
