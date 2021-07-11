var emailformat = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

$(document).ready(function(){
    //boton y form
    const boton = document.getElementById("boton");
    const form = document.getElementById("formulario");
    //recuperar informacion del formulario
    const nameForm = document.getElementById("nameForm");
    const emailForm = document.getElementById("emailForm");
    const phoneForm = document.getElementById("phoneForm");
    const dateForm = document.getElementById("dateForm");
    const countryForm = document.getElementById("countryForm");
    const audioForm = document.getElementById("audioForm");
    const videoForm = document.getElementById("videoForm");


    //escuchamos el evento clik
    boton.addEventListener("click", async(e)=>{
        e.preventDefault();
        
        const name = nameForm.value;
        const phone = phoneForm.value;
        const email = emailForm.value;
        const date = dateForm.value;
        const country = countryForm.value;

        if(vacio(name)){
            alert("Por favor introducir un nombre valido");
        };
        if(vacio(phone)){
            alert("Por favor introducir un teléfono valido");
        };
        if(vacio(email)){
            alert("Por favor introducir un valor en email");
        }else if(!validarEmail(email)){
            alert("Por favor introducir un email valido");
        };
        if(vacio(date)){
            alert("Por favor introducir una fecha valida");
        };
        if(vacio(country)){
            alert("Por favor introducir un nombre de pais valido");
        };
        

        if (!vacio(name) &&
            !vacio(phone) &&
            validarEmail(email) &&
            !vacio(date) &&
            !vacio(country)) {       
        alert("Datos comprobados y enviados exitosamente!");
        form.submit();
        }
        

    });

});

//Funciones
function vacio(dato) {
    return dato === "";
}

function validarEmail(email){
    if(email.match(emailformat)){
        return true;
    };
    return false;
}

