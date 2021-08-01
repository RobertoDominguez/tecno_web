<?php
/* Smarty version 3.1.33, created on 2021-07-25 15:00:19
  from '/home/grupo12sa/practica5/templates/mensaje.html' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_60fdb4c3cf8af2_70291035',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    '1c762caceb358d9bdb47473056eafabe267c05e9' => 
    array (
      0 => '/home/grupo12sa/practica5/templates/mensaje.html',
      1 => 1627228790,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_60fdb4c3cf8af2_70291035 (Smarty_Internal_Template $_smarty_tpl) {
$_smarty_tpl->_loadInheritance();
$_smarty_tpl->inheritance->init($_smarty_tpl, true);
?>


<?php 
$_smarty_tpl->inheritance->instanceBlock($_smarty_tpl, 'Block_139557432860fdb4c3ce7878_46675066', "cuerpo");
$_smarty_tpl->inheritance->endChild($_smarty_tpl, "layout.html");
}
/* {block "cuerpo"} */
class Block_139557432860fdb4c3ce7878_46675066 extends Smarty_Internal_Block
{
public $subBlocks = array (
  'cuerpo' => 
  array (
    0 => 'Block_139557432860fdb4c3ce7878_46675066',
  ),
);
public function callBlock(Smarty_Internal_Template $_smarty_tpl) {
?>


  <div class="row">
    <div class="col s12 center">
      <div class="card blue-grey darken-1">
        <div class="card-content white-text center-align">
          <span class="card-title center-align"><?php echo $_smarty_tpl->tpl_vars['titlemessages']->value;?>
</span>
          <p><?php echo $_smarty_tpl->tpl_vars['messages']->value;?>
</p>
        </div>
        <div class="card-action center-align">
          <a href="<?php echo $_smarty_tpl->tpl_vars['linkback']->value;?>
">Volver</a>
        </div>
      </div>
    </div>
  </div>

<?php
}
}
/* {/block "cuerpo"} */
}
