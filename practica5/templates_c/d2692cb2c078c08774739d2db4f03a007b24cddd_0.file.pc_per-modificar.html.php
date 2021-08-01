<?php
/* Smarty version 3.1.33, created on 2021-07-21 23:47:24
  from '/home/grupo01sa/Practica5/Taborga_Farel_Dennar/templates/pc_per-modificar.html' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_60f8ea4cdf68a5_83630706',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    'd2692cb2c078c08774739d2db4f03a007b24cddd' => 
    array (
      0 => '/home/grupo01sa/Practica5/Taborga_Farel_Dennar/templates/pc_per-modificar.html',
      1 => 1626925433,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_60f8ea4cdf68a5_83630706 (Smarty_Internal_Template $_smarty_tpl) {
?><div class="row ">
    <form class="col s12 center " action="<?php echo $_smarty_tpl->tpl_vars['ps']->value;?>
" method="post" enctype="multipart/form-data">
    <div class="row card-panel blue-grey darken-1 white-text">
	      <h4><?php echo $_smarty_tpl->tpl_vars['titulo']->value;?>
</h4>
	      <input type="hidden" name="opcion" value="<?php echo $_smarty_tpl->tpl_vars['opcion']->value;?>
"> 
	      
	      <div class="row center"> 
	       
	       <div class="input-field col s12 ">
	          <input class="white-text" name="cod" id="cod" type="text" class="validate" required>
	          <label class="white-text" for="cod">C.I.</label>
	        </div>  
	         
	        <div class="input-field col s12 ">
	          <input class="white-text" name="nom" id="nom" type="text" class="validate" required>
	          <label class="white-text" for="nom">Nombres</label>
	        </div> 
	        
	        <div class="input-field col s12 ">
	          <input class="white-text" name="appm" id="appm" type="text" class="validate" required>
	          <label class="white-text" for="appm">Apellidos</label>
	        </div> 
	       
	        
	        <div class="input-field col s12 ">
	          <input class="white-text" name="telf" id="telf" type="text" class="validate" required>
	          <label class="white-text" for="telf">Telefono</label>
	        </div>
	        
	        <div class="input-field col s12 ">
	          <input class="white-text" name="cel" id="cel" type="text" class="validate" required>
	          <label class="white-text" for="cel">Celular</label>
	        </div>
	        
	        <div class="input-field col s12 ">
	          <input class="white-text" name="email" id="email" type="email" class="validate" required>
	          <label class="white-text" for="email">Email</label>
	        </div>
	        
	      
	     <!--
	         <div class="input-field col s12 ">
	          <input class="white-text" name="foto" id="foto" type="file" accept="image/*"  class="validate" required>
	          <label class="white-text" for="foto">Foto.</label>
	        </div>
	     
	     -->
	</div>
	      <button class='btn blue darken-4' type='submit'>Modificar</button>
	</div>
    </form>
</div><?php }
}
