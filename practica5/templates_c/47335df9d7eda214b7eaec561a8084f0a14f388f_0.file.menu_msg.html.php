<?php
/* Smarty version 3.1.33, created on 2021-07-25 15:11:13
  from '/home/grupo12sa/practica5/templates/menu_msg.html' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_60fdb751a080f3_62185840',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    '47335df9d7eda214b7eaec561a8084f0a14f388f' => 
    array (
      0 => '/home/grupo12sa/practica5/templates/menu_msg.html',
      1 => 1627228791,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_60fdb751a080f3_62185840 (Smarty_Internal_Template $_smarty_tpl) {
?><div class="row ">
    <div class="col s12">
      <div class="card blue-grey darken-1">
        <div class="card-content white-text center-align">
          <span class="card-title center-align"><?php echo $_smarty_tpl->tpl_vars['titlemessages']->value;?>
</span>
          <p><?php echo $_smarty_tpl->tpl_vars['messages']->value;?>
</p>
        </div>
        <div class="card-action center-align">
          <a href="<?php echo $_smarty_tpl->tpl_vars['linkbacks']->value;?>
">Volver</a>
        </div>
      </div>
    </div>
  </div><?php }
}
