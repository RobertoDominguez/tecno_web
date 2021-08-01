<?php
/* Smarty version 3.1.33, created on 2021-07-21 21:33:15
  from '/home/grupo01sa/Practica5/Taborga_Farel_Dennar/templates/menu_msg.html' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_60f8cadb9846e3_40705488',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    '5a1219f3a96668d213835b48436d0739ce3a2745' => 
    array (
      0 => '/home/grupo01sa/Practica5/Taborga_Farel_Dennar/templates/menu_msg.html',
      1 => 1626737962,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_60f8cadb9846e3_40705488 (Smarty_Internal_Template $_smarty_tpl) {
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
