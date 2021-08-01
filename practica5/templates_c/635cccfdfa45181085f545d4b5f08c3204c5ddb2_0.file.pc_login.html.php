<?php
/* Smarty version 3.1.33, created on 2021-07-25 12:01:41
  from '/home/grupo12sa/practica5/templates/pc_login.html' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_60fd8ae589d3c5_62997019',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    '635cccfdfa45181085f545d4b5f08c3204c5ddb2' => 
    array (
      0 => '/home/grupo12sa/practica5/templates/pc_login.html',
      1 => 1627228794,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_60fd8ae589d3c5_62997019 (Smarty_Internal_Template $_smarty_tpl) {
$_smarty_tpl->_loadInheritance();
$_smarty_tpl->inheritance->init($_smarty_tpl, true);
?>


<?php 
$_smarty_tpl->inheritance->instanceBlock($_smarty_tpl, 'Block_118534122160fd8ae58935c2_83483835', "cuerpo");
$_smarty_tpl->inheritance->endChild($_smarty_tpl, "layout.html");
}
/* {block "cuerpo"} */
class Block_118534122160fd8ae58935c2_83483835 extends Smarty_Internal_Block
{
public $subBlocks = array (
  'cuerpo' => 
  array (
    0 => 'Block_118534122160fd8ae58935c2_83483835',
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
