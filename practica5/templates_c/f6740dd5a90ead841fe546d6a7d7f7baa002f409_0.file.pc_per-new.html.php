<?php
/* Smarty version 3.1.33, created on 2021-07-25 15:20:13
  from '/home/grupo12sa/practica5/templates/pc_per-new.html' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_60fdb96d121b81_80746605',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    'f6740dd5a90ead841fe546d6a7d7f7baa002f409' => 
    array (
      0 => '/home/grupo12sa/practica5/templates/pc_per-new.html',
      1 => 1627228791,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_60fdb96d121b81_80746605 (Smarty_Internal_Template $_smarty_tpl) {
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

	        <div class="input-field col s12">
	          <input class="white-text" name="pass" id="pass" type="password" class="validate" required>
	          <label class="white-text" for="pass">Contraseña</label>
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
	          <input class="white-text" name="prof" id="prof" type="text" class="validate" required>
	          <label class="white-text" for="prof">Profesion</label>
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
	        
	        <div class="input-field col s12 ">
	          <input class="white-text" name="dir" id="dir" type="text" class="validate" required>
	          <label class="white-text" for="dir">Direccion</label>
	        </div>
	        
	        <div class="input-field col s12 ">
	          <input class="white-text" name="fnac" id="fnac" type="date" class="validate" required>
	          <label class="white-text" for="fnac">Fecha Nac.</label>
	        </div>
	        
	        <div class="input-field col s12 ">
	          <input class="white-text" name="lnac" id="lnac" type="text" class="validate" required>
	          <label class="white-text" for="lnac">Lugar Nac.</label>
	        </div>
	        
	        <!-- 
	        <div class="input-field col s12 ">
	          <input class="white-text" name="foto" id="foto" type="file" accept="image/*"  class="validate" required>
	          <label class="white-text" for="foto">Foto.</label>
	        </div>
	        -->
	      </div>
	      <button class='btn blue darken-4' type='submit'>Registrar</button>
	</div>
    </form>
</div><?php }
}
