//Validación de un formulario
let submitbtn = document.getElementById("btnRegistro");


submitbtn.addEventListener("click",

(postCliente = async() => {
      
      let nombreI = document.getElementById("exampleFirstName").value;
      let apellidoI = document.getElementById("exampleLastName").value;
      let emailI = document.getElementById("exampleInputEmail").value;
      let cumpleañosI = document.getElementById("exampleBirthday").value;        
      let edadI = document.getElementById("exampleAge").value;
      let dniI = document.getElementById("exampleDNI").value;
      let contraseñaI = document.getElementById("exampleInputPassword").value;
      let contraseña2I = document.getElementById("exampleRepeatPassword").value;
      let error = document.getElementById("error_message");
      let text;
      if(nombreI.length < 2){
        text = "Por favor, ingrese un nombre válido";
        error.innerHTML = text;
        return false;
      }
      if(apellidoI.length < 2){
        text = "Por favor, ingrese un apellido válido";
        error.innerHTML = text;
        return false;
      }
      if(emailI.indexOf("@") == -1 || emailI.length < 6){
        text = "Por favor, ingrese un correo electrónico válido";
        error.innerHTML = text;
        return false;
      } 
      if(dniI.length != 9){
        text = "Por favor, ingrese un DNI válido";
        error.innerHTML = text;
        return false;
      }
      if(contraseñaI < 9){
        text = "Por favor, ingrese una contraseña válida";
        error.innerHTML = text;
        return false;
      }
      if(contraseña2I != contraseñaI){
        text = "La contraseña introducida no coincide";
        error.innerHTML = text;
        return false;
      }
      error.innerHTML = null;

      let request = await fetch("/clientesPOST", {
          method : "POST",
          credentials: "same-origin", 
          headers: { 
            "Content-Type": "application/json"
            
          },
          body: JSON.stringify({
              nombre : nombreI,
              apellido : apellidoI,
              email : emailI,
              cumpleaños : cumpleañosI.toString(),
              dni : dniI,
              edad : parseInt(edadI),
              contraseña : contraseñaI,
              contraseña2 : contraseña2I

          }),
          dataType: "json"
    }).catch(console.error);

  if(request.ok) {
      console.log("Success!");
    }


  let get = await fetch("/clientesGET", {
      method: "GET",
      credentials: "same-origin",
      dataType: "json",
    });

    if (get.ok) {
      var data = await get.json();

      let nombreG = data.nombre;
      let apellidoG = data.apellido;
      let emailG = data.email;
      let cumpleañosG = data.cumpleaños.toString();
      let dniG= data.dni;
      let edadG = data.edad;
  
      document.getElementById("nombreG").innerHTML = nombreG;
      document.getElementById("apellidoG").innerHTML = apellidoG;
      document.getElementById("emailG").innerHTML = emailG;
      document.getElementById("cumpleañosG").innerHTML = cumpleañosG;
      document.getElementById("dniG").innerHTML = dniG;
      document.getElementById("edadG").innerHTML = edadG;
    }
  
  })
);



  function validationPassword(){
      
    let contraseña = document.getElementById("newPassword").value;
    let contraseña2 = document.getElementById("newRepeatPassword").value;
    let error = document.getElementById("error_message");
    let text;

    if(contraseña < 9){
      text = "Por favor, ingrese una contraseña válida";
      error.innerHTML = text;
      return false;
    }
    if(contraseña2 != contraseña){
      text = "La contraseña introducida no coincide";
      error.innerHTML = text;
      return false;
    }
    alert("La contraseña se ha actualizado, muchas gracias!");
    window.open('index.html');
    return true;
    
}

function validationUnete(){
      
  let nombre = document.getElementById("exampleFirstName").value;
  let apellido = document.getElementById("exampleLastName").value;
  let email = document.getElementById("exampleInputEmail").value;
  let DNI = document.getElementById("exampleDNI").value;
  let contacto = document.getElementById("exampleContacto").value;
  let error = document.getElementById("error_message");
  let text;

  if(nombre.length < 2){
    text = "Por favor, ingrese un nombre válido";
    error.innerHTML = text;
    return false;
  }
  if(apellido.length < 2){
    text = "Por favor, ingrese un apellido válido";
    error.innerHTML = text;
    return false;
  }
  if(email.indexOf("@") == -1 || email.length < 6){
    text = "Por favor, ingrese un correo electrónico válido";
    error.innerHTML = text;
    return false;
  } 
  if(DNI.length != 9){
    text = "Por favor, ingrese un DNI válido";
    error.innerHTML = text;
    return false;
  }
  if(contacto.length != 9){
    text = "Por favor, ingrese un número de teléfono válido";
    error.innerHTML = text;
    return false;
  }
  alert("Su comentario se ha tendrá en cuenta, muchas gracias!")
  window.open('index.html');
  return true;
  
  
}


function validationPassword(){
  
let contraseña = document.getElementById("newPassword").value;
let contraseña2 = document.getElementById("newRepeatPassword").value;
let error = document.getElementById("error_message");
let text;

if(contraseña < 9){
  text = "Por favor, ingrese una contraseña válida";
  error.innerHTML = text;
  return false;
}
if(contraseña2 != contraseña){
  text = "La contraseña introducida no coincide";
  error.innerHTML = text;
  return false;
}
alert("La contraseña se ha actualizado, muchas gracias!");
window.open('index.html');
return true;

}

function validationLogin(){
      
  let email = document.getElementById("loginInEmail").value;
  let contraseña = document.getElementById("loginPassword").value;
  let error = document.getElementById("error_message");
  let text;
  console.log("Estoy dentro");

  //En en una versión nueva se comprobará que coincida a su vez con la info guardaba en la base de datos
  
  if(email.indexOf("@") == -1 || email.length < 6){
    text = "Por favor, ingrese un correo electrónico válido";
    error.innerHTML = text;
    return false;
  } 
  if(contraseña < 9){
    text = "Por favor, ingrese una contraseña válida";
    error.innerHTML = text;
    return false;
  }
  alert("La contraseña se ha actualizado, muchas gracias!");
  window.open('index.html');
  return true;
}
