<?php
/* Smarty version 3.1.33, created on 2021-07-21 18:24:43
  from '/home/grupo01sa/Practica5/Taborga_Farel_Dennar/templates/layout.html' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_60f89eab5c3ce0_26757417',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    '645bb184b50cf4615efcec26f960c068505be231' => 
    array (
      0 => '/home/grupo01sa/Practica5/Taborga_Farel_Dennar/templates/layout.html',
      1 => 1626737960,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_60f89eab5c3ce0_26757417 (Smarty_Internal_Template $_smarty_tpl) {
$_smarty_tpl->_loadInheritance();
$_smarty_tpl->inheritance->init($_smarty_tpl, false);
?>
<html>
<head>
  <title><?php echo $_smarty_tpl->tpl_vars['titulo']->value;?>
</title>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
  <?php echo '<script'; ?>
 src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"><?php echo '</script'; ?>
>
 
  <?php echo '<script'; ?>
>
  
    $(function(){
        $(".dropdown-trigger").dropdown({
               hover: true,
               gutter: 0,
               coverTrigger: false
        });   
    });
    
  <?php echo '</script'; ?>
>
</head>
<body>


 <nav>
 
  <nav class="nav-extended">
 
    <div class="nav-wrapper blue darken-4">
     <div class="container">
      <a href="#" class="brand-logo"><?php echo $_smarty_tpl->tpl_vars['titulo']->value;?>
</a>
      
       
      <a href="#" data-target="menu-responsive" class="sidenav-trigger">
          <i class="material-icons">menu</i>
      </a>

      
      <ul class="right hide-on-med-and-down">
      <?php
$__section_op1_0_loop = (is_array(@$_loop=$_smarty_tpl->tpl_vars['menu']->value) ? count($_loop) : max(0, (int) $_loop));
$__section_op1_0_total = $__section_op1_0_loop;
$_smarty_tpl->tpl_vars['__smarty_section_op1'] = new Smarty_Variable(array());
if ($__section_op1_0_total !== 0) {
for ($__section_op1_0_iteration = 1, $_smarty_tpl->tpl_vars['__smarty_section_op1']->value['index'] = 0; $__section_op1_0_iteration <= $__section_op1_0_total; $__section_op1_0_iteration++, $_smarty_tpl->tpl_vars['__smarty_section_op1']->value['index']++){
?>
              <li><a class="dropdown-trigger" data-target="submenu-<?php echo $_smarty_tpl->tpl_vars['menu']->value[(isset($_smarty_tpl->tpl_vars['__smarty_section_op1']->value['index']) ? $_smarty_tpl->tpl_vars['__smarty_section_op1']->value['index'] : null)]['name'];?>
" href="#"><?php echo $_smarty_tpl->tpl_vars['menu']->value[(isset($_smarty_tpl->tpl_vars['__smarty_section_op1']->value['index']) ? $_smarty_tpl->tpl_vars['__smarty_section_op1']->value['index'] : null)]['name'];?>
</a></li>
               <!-- SubMenu dropdown-->
            <ul class="dropdown-content blue-text" id="submenu-<?php echo $_smarty_tpl->tpl_vars['menu']->value[(isset($_smarty_tpl->tpl_vars['__smarty_section_op1']->value['index']) ? $_smarty_tpl->tpl_vars['__smarty_section_op1']->value['index'] : null)]['name'];?>
">
            <?php
$__section_op2_1_loop = (is_array(@$_loop=$_smarty_tpl->tpl_vars['menu']->value[(isset($_smarty_tpl->tpl_vars['__smarty_section_op1']->value['index']) ? $_smarty_tpl->tpl_vars['__smarty_section_op1']->value['index'] : null)]['subMenu']) ? count($_loop) : max(0, (int) $_loop));
$__section_op2_1_total = $__section_op2_1_loop;
$_smarty_tpl->tpl_vars['__smarty_section_op2'] = new Smarty_Variable(array());
if ($__section_op2_1_total !== 0) {
for ($__section_op2_1_iteration = 1, $_smarty_tpl->tpl_vars['__smarty_section_op2']->value['index'] = 0; $__section_op2_1_iteration <= $__section_op2_1_total; $__section_op2_1_iteration++, $_smarty_tpl->tpl_vars['__smarty_section_op2']->value['index']++){
?>
                <li><a class="blue-text text-darken-4" href="<?php echo $_smarty_tpl->tpl_vars['menu']->value[(isset($_smarty_tpl->tpl_vars['__smarty_section_op1']->value['index']) ? $_smarty_tpl->tpl_vars['__smarty_section_op1']->value['index'] : null)]['subMenu'][(isset($_smarty_tpl->tpl_vars['__smarty_section_op2']->value['index']) ? $_smarty_tpl->tpl_vars['__smarty_section_op2']->value['index'] : null)]['link'];?>
"><?php echo $_smarty_tpl->tpl_vars['menu']->value[(isset($_smarty_tpl->tpl_vars['__smarty_section_op1']->value['index']) ? $_smarty_tpl->tpl_vars['__smarty_section_op1']->value['index'] : null)]['subMenu'][(isset($_smarty_tpl->tpl_vars['__smarty_section_op2']->value['index']) ? $_smarty_tpl->tpl_vars['__smarty_section_op2']->value['index'] : null)]['name'];?>
</a></li>
            <?php
}
}
?>
            </ul>
      <?php
}
}
?>
      </ul>
      </div>
    </div>
    
    <div class="nav-content hide-on-med-and-down">    
       <a href="#">
       <img src="images/<?php echo $_smarty_tpl->tpl_vars['foto']->value;?>
" alt="" class="circle responsive-img" width="2%" >
       </a>
       <a href="#">
         <span class="name white-text"><?php echo $_smarty_tpl->tpl_vars['user']->value;?>
</span>
       </a>
       <a href="#" >
        <img class="email white-text right" border="1" src="images/logo_bol.png" alt="" style="padding-right: 10px;padding-left: 10px;">
        <span class="email white-text right"> <?php echo $_smarty_tpl->tpl_vars['email']->value;?>
 </span>        
       </a>         
    </div>
    
   </nav>
    
  </nav>

  <!-- Menu Responsive -->
      <ul class="sidenav" id="menu-responsive">
        <li>
            <div class="user-view">
            
               <div class="background">
                  <img src="images/fondo3.jpg" alt="">
               </div>
               <a href="#">
               <img src="images/<?php echo $_smarty_tpl->tpl_vars['foto']->value;?>
" alt="" class="circle">
               </a>
               <a href="#">
               <span class="name white-text"> <?php echo $_smarty_tpl->tpl_vars['user']->value;?>
    </span>
               </a>
               <a href="#">
               <span class="email white-text"> <?php echo $_smarty_tpl->tpl_vars['email']->value;?>
   <img border="1" src="images/logo_bol.png" alt="" > </span>
               
               </a>                              
               
            </div>
        </li>
      <?php
$__section_op1_2_loop = (is_array(@$_loop=$_smarty_tpl->tpl_vars['menu']->value) ? count($_loop) : max(0, (int) $_loop));
$__section_op1_2_total = $__section_op1_2_loop;
$_smarty_tpl->tpl_vars['__smarty_section_op1'] = new Smarty_Variable(array());
if ($__section_op1_2_total !== 0) {
for ($__section_op1_2_iteration = 1, $_smarty_tpl->tpl_vars['__smarty_section_op1']->value['index'] = 0; $__section_op1_2_iteration <= $__section_op1_2_total; $__section_op1_2_iteration++, $_smarty_tpl->tpl_vars['__smarty_section_op1']->value['index']++){
?>
          <li><a class="blue darken-4" href="#"><?php echo $_smarty_tpl->tpl_vars['menu']->value[(isset($_smarty_tpl->tpl_vars['__smarty_section_op1']->value['index']) ? $_smarty_tpl->tpl_vars['__smarty_section_op1']->value['index'] : null)]['name'];?>
</a></li>
               <!-- SubMenu Responsive-->
             <?php
$__section_op2_3_loop = (is_array(@$_loop=$_smarty_tpl->tpl_vars['menu']->value[(isset($_smarty_tpl->tpl_vars['__smarty_section_op1']->value['index']) ? $_smarty_tpl->tpl_vars['__smarty_section_op1']->value['index'] : null)]['subMenu']) ? count($_loop) : max(0, (int) $_loop));
$__section_op2_3_total = $__section_op2_3_loop;
$_smarty_tpl->tpl_vars['__smarty_section_op2'] = new Smarty_Variable(array());
if ($__section_op2_3_total !== 0) {
for ($__section_op2_3_iteration = 1, $_smarty_tpl->tpl_vars['__smarty_section_op2']->value['index'] = 0; $__section_op2_3_iteration <= $__section_op2_3_total; $__section_op2_3_iteration++, $_smarty_tpl->tpl_vars['__smarty_section_op2']->value['index']++){
?>
                <li><a href="<?php echo $_smarty_tpl->tpl_vars['menu']->value[(isset($_smarty_tpl->tpl_vars['__smarty_section_op1']->value['index']) ? $_smarty_tpl->tpl_vars['__smarty_section_op1']->value['index'] : null)]['subMenu'][(isset($_smarty_tpl->tpl_vars['__smarty_section_op2']->value['index']) ? $_smarty_tpl->tpl_vars['__smarty_section_op2']->value['index'] : null)]['link'];?>
">  <?php echo $_smarty_tpl->tpl_vars['menu']->value[(isset($_smarty_tpl->tpl_vars['__smarty_section_op1']->value['index']) ? $_smarty_tpl->tpl_vars['__smarty_section_op1']->value['index'] : null)]['subMenu'][(isset($_smarty_tpl->tpl_vars['__smarty_section_op2']->value['index']) ? $_smarty_tpl->tpl_vars['__smarty_section_op2']->value['index'] : null)]['name'];?>
</a></li>
            <?php
}
}
?>           
      <?php
}
}
?>
    </ul>
    
<br>
<div class="section container col12">
 <?php 
$_smarty_tpl->inheritance->instanceBlock($_smarty_tpl, 'Block_111424585460f89eab5b2ab7_78440959', "cuerpo");
?>

</div>

 <!-- Footer -->
 
 
        <footer class="page-footer" >
           <center><?php echo $_smarty_tpl->tpl_vars['message']->value;?>
</center>
          <div class="footer-copyright  blue darken-4">
          <div class="right hide-on-med-and-down">
            <img border="0" src="images/apache_pb.gif" width="120" height="17" alt="power by APACHE">
            <img border="0" src="images/php-power-micro.png" alt="power by PHP">
            <img border="0" src="images/slonik_m.gif" width="40" height="17" alt="power by PostgreSQL">
           </div>
            <div class="container">            
            <a class="grey-text text-lighten-4 left" href="#">© 2021 Copyright UAGRM-FICCT | INF513 ("Tecnologia Web")</a>            
            <a class="grey-text text-lighten-4 right" href="https://www.tecnoweb.org.bo">https://www.tecnoweb.org.bo</a>
            </div>
          </div>
        </footer>
                 
      
<?php echo '<script'; ?>
 src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"><?php echo '</script'; ?>
>
<?php echo '<script'; ?>
 >

 document.addEventListener('DOMContentLoaded',function(){M.AutoInit(); });

<?php echo '</script'; ?>
>
</body>
</html><?php }
/* {block "cuerpo"} */
class Block_111424585460f89eab5b2ab7_78440959 extends Smarty_Internal_Block
{
public $subBlocks = array (
  'cuerpo' => 
  array (
    0 => 'Block_111424585460f89eab5b2ab7_78440959',
  ),
);
public function callBlock(Smarty_Internal_Template $_smarty_tpl) {
}
}
/* {/block "cuerpo"} */
}
