<?php
/* Smarty version 3.1.33, created on 2021-07-25 12:01:37
  from '/home/grupo12sa/practica5/templates/bienvenido.html' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_60fd8ae16550c7_49001231',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    '7a999f122027ff2aaf2977feaa6691e822b8e9a3' => 
    array (
      0 => '/home/grupo12sa/practica5/templates/bienvenido.html',
      1 => 1627228793,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_60fd8ae16550c7_49001231 (Smarty_Internal_Template $_smarty_tpl) {
$_smarty_tpl->_loadInheritance();
$_smarty_tpl->inheritance->init($_smarty_tpl, true);
?>


<?php 
$_smarty_tpl->inheritance->instanceBlock($_smarty_tpl, 'Block_166282172060fd8ae164b031_27585357', "cuerpo");
$_smarty_tpl->inheritance->endChild($_smarty_tpl, "layout.html");
}
/* {block "cuerpo"} */
class Block_166282172060fd8ae164b031_27585357 extends Smarty_Internal_Block
{
public $subBlocks = array (
  'cuerpo' => 
  array (
    0 => 'Block_166282172060fd8ae164b031_27585357',
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
