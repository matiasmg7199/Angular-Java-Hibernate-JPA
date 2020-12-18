import { Component, OnInit } from '@angular/core';

import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ApiService } from '../../servicios/api/api.service';
import { registroI } from '../../modelos/registro.interface';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  registroForm = new FormGroup({
    usuario : new FormControl('', Validators.required),
    password : new FormControl('', Validators.required),
    nombre : new FormControl('', Validators.required),
    apellido : new FormControl('', Validators.required),
    email: new FormControl('', Validators.required),
    tipoCuenta: new FormControl('', Validators.required)
  })

  constructor(private api:ApiService) { }

  ngOnInit(): void {
  }

  onRegistro(form: registroI){
    let nuevoForm = {
        "nombreUsuario": form.usuario,
        "contraseña": form.password,
        "nombre": form.nombre,
        "apellido": form.apellido,
        "email": form.email
    }
    console.log(form.tipoCuenta);
    if(form.tipoCuenta==="2"){
      console.log("estas seleccionando ser foodtrucker");
      this.api.registroFoodTrucker(nuevoForm).subscribe(data =>{
        console.log(data);
      })
    }
    else if(form.tipoCuenta==="1"){
      console.log("estas seleccionando ser organizer");
      this.api.registroOrganizer(nuevoForm).subscribe(data =>{
        console.log(data);
      })
    }
  }
}
