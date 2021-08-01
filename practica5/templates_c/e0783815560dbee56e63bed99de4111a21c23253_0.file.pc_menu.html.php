<?php
/* Smarty version 3.1.33, created on 2021-07-21 18:24:49
  from '/home/grupo01sa/Practica5/Taborga_Farel_Dennar/templates/pc_menu.html' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_60f89eb10d5437_58906408',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    'e0783815560dbee56e63bed99de4111a21c23253' => 
    array (
      0 => '/home/grupo01sa/Practica5/Taborga_Farel_Dennar/templates/pc_menu.html',
      1 => 1626737965,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_60f89eb10d5437_58906408 (Smarty_Internal_Template $_smarty_tpl) {
$_smarty_tpl->_loadInheritance();
$_smarty_tpl->inheritance->init($_smarty_tpl, true);
?>


<?php 
$_smarty_tpl->inheritance->instanceBlock($_smarty_tpl, 'Block_18892314860f89eb10ceb01_43429571', "cuerpo");
$_smarty_tpl->inheritance->endChild($_smarty_tpl, "layout.html");
}
/* {block "cuerpo"} */
class Block_18892314860f89eb10ceb01_43429571 extends Smarty_Internal_Block
{
public $subBlocks = array (
  'cuerpo' => 
  array (
    0 => 'Block_18892314860f89eb10ceb01_43429571',
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
