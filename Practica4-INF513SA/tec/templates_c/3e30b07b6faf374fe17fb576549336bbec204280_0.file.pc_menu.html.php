<?php
/* Smarty version 3.1.33, created on 2021-02-15 01:01:11
  from '/home/grupo12sa/Ronald_Saavedra/PRACTICO4_INF513/templates/pc_menu.html' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_6029c7d70762a0_16507028',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    '3e30b07b6faf374fe17fb576549336bbec204280' => 
    array (
      0 => '/home/grupo12sa/Ronald_Saavedra/PRACTICO4_INF513/templates/pc_menu.html',
      1 => 1613349254,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_6029c7d70762a0_16507028 (Smarty_Internal_Template $_smarty_tpl) {
$_smarty_tpl->_loadInheritance();
$_smarty_tpl->inheritance->init($_smarty_tpl, true);
?>


<?php 
$_smarty_tpl->inheritance->instanceBlock($_smarty_tpl, 'Block_6976527506029c7d706fb51_17634823', 'contenido');
$_smarty_tpl->inheritance->endChild($_smarty_tpl, "layout.html");
}
/* {block 'contenido'} */
class Block_6976527506029c7d706fb51_17634823 extends Smarty_Internal_Block
{
public $subBlocks = array (
  'contenido' => 
  array (
    0 => 'Block_6976527506029c7d706fb51_17634823',
  ),
);
public function callBlock(Smarty_Internal_Template $_smarty_tpl) {
?>

<h3><?php echo $_smarty_tpl->tpl_vars['usuario']->value;?>
</h3>
<?php echo $_smarty_tpl->tpl_vars['contenido']->value;?>


<?php
}
}
/* {/block 'contenido'} */
}
