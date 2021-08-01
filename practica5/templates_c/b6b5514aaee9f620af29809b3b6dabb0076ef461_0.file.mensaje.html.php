<?php
/* Smarty version 3.1.33, created on 2021-07-21 18:24:43
  from '/home/grupo01sa/Practica5/Taborga_Farel_Dennar/templates/mensaje.html' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_60f89eab518385_97950732',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    'b6b5514aaee9f620af29809b3b6dabb0076ef461' => 
    array (
      0 => '/home/grupo01sa/Practica5/Taborga_Farel_Dennar/templates/mensaje.html',
      1 => 1626737963,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_60f89eab518385_97950732 (Smarty_Internal_Template $_smarty_tpl) {
$_smarty_tpl->_loadInheritance();
$_smarty_tpl->inheritance->init($_smarty_tpl, true);
?>


<?php 
$_smarty_tpl->inheritance->instanceBlock($_smarty_tpl, 'Block_159795879460f89eab5098b9_56890864', "cuerpo");
$_smarty_tpl->inheritance->endChild($_smarty_tpl, "layout.html");
}
/* {block "cuerpo"} */
class Block_159795879460f89eab5098b9_56890864 extends Smarty_Internal_Block
{
public $subBlocks = array (
  'cuerpo' => 
  array (
    0 => 'Block_159795879460f89eab5098b9_56890864',
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
