<?php
/* Smarty version 3.1.33, created on 2021-02-15 01:01:27
  from '/home/grupo12sa/Ronald_Saavedra/PRACTICO4_INF513/templates/bienvenido.html' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_6029c7e7432098_14267733',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    '632772a1d1713cd6c504cc3b98dc8268413d39c3' => 
    array (
      0 => '/home/grupo12sa/Ronald_Saavedra/PRACTICO4_INF513/templates/bienvenido.html',
      1 => 1613349253,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_6029c7e7432098_14267733 (Smarty_Internal_Template $_smarty_tpl) {
$_smarty_tpl->_loadInheritance();
$_smarty_tpl->inheritance->init($_smarty_tpl, true);
?>


<?php 
$_smarty_tpl->inheritance->instanceBlock($_smarty_tpl, 'Block_14751209036029c7e742cde5_23229686', 'contenido');
$_smarty_tpl->inheritance->endChild($_smarty_tpl, "layout.html");
}
/* {block 'contenido'} */
class Block_14751209036029c7e742cde5_23229686 extends Smarty_Internal_Block
{
public $subBlocks = array (
  'contenido' => 
  array (
    0 => 'Block_14751209036029c7e742cde5_23229686',
  ),
);
public function callBlock(Smarty_Internal_Template $_smarty_tpl) {
?>


<?php echo $_smarty_tpl->tpl_vars['contenido']->value;?>


<?php
}
}
/* {/block 'contenido'} */
}
