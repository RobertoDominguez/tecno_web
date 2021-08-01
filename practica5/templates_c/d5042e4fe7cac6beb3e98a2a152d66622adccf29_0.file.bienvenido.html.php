<?php
/* Smarty version 3.1.33, created on 2021-07-21 22:48:17
  from '/home/grupo01sa/Practica5/Taborga_Farel_Dennar/templates/bienvenido.html' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_60f8dc71743d59_84908517',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    'd5042e4fe7cac6beb3e98a2a152d66622adccf29' => 
    array (
      0 => '/home/grupo01sa/Practica5/Taborga_Farel_Dennar/templates/bienvenido.html',
      1 => 1626737959,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_60f8dc71743d59_84908517 (Smarty_Internal_Template $_smarty_tpl) {
$_smarty_tpl->_loadInheritance();
$_smarty_tpl->inheritance->init($_smarty_tpl, true);
?>


<?php 
$_smarty_tpl->inheritance->instanceBlock($_smarty_tpl, 'Block_64565927660f8dc7173bb24_75191257', "cuerpo");
$_smarty_tpl->inheritance->endChild($_smarty_tpl, "layout.html");
}
/* {block "cuerpo"} */
class Block_64565927660f8dc7173bb24_75191257 extends Smarty_Internal_Block
{
public $subBlocks = array (
  'cuerpo' => 
  array (
    0 => 'Block_64565927660f8dc7173bb24_75191257',
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
