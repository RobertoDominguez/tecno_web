<?php
/* Smarty version 3.1.33, created on 2021-07-21 18:24:46
  from '/home/grupo01sa/Practica5/Taborga_Farel_Dennar/templates/pc_login.html' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_60f89eae6821b1_92661561',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    'a82181a1ad1a1ea465afa483bbaf2d9b7725cdb4' => 
    array (
      0 => '/home/grupo01sa/Practica5/Taborga_Farel_Dennar/templates/pc_login.html',
      1 => 1626737964,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_60f89eae6821b1_92661561 (Smarty_Internal_Template $_smarty_tpl) {
$_smarty_tpl->_loadInheritance();
$_smarty_tpl->inheritance->init($_smarty_tpl, true);
?>


<?php 
$_smarty_tpl->inheritance->instanceBlock($_smarty_tpl, 'Block_180494963860f89eae675058_74901548', "cuerpo");
$_smarty_tpl->inheritance->endChild($_smarty_tpl, "layout.html");
}
/* {block "cuerpo"} */
class Block_180494963860f89eae675058_74901548 extends Smarty_Internal_Block
{
public $subBlocks = array (
  'cuerpo' => 
  array (
    0 => 'Block_180494963860f89eae675058_74901548',
  ),
);
public function callBlock(Smarty_Internal_Template $_smarty_tpl) {
?>


<div class="row ">
    <form class="col s12 center " action="<?php echo $_smarty_tpl->tpl_vars['ps']->value;?>
" method="GET">
    <div class="row card-panel blue-grey darken-1 white-text">
	      <h4>Ingreso</h4>
	      <div class="row center">
	        <div class="input-field col s12 ">
	          <input class="white-text" name="user" id="user" type="text" class="validate" required>
	          <label class="white-text" for="user">Usuario</label>
	        </div>       

	        <div class="input-field col s12">
	          <input class="white-text" name="pass" id="pass" type="password" class="validate" required>
	          <label class="white-text" for="pass">Password</label>
	        </div>
	      </div>
	      <button class='btn blue darken-4' type="submit">Ingresar</button>
	</div>
    </form>
</div>

<?php
}
}
/* {/block "cuerpo"} */
}
