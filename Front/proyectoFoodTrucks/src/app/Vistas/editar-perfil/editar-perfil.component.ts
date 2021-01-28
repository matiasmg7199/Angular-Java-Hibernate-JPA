import { Component, OnInit } from '@angular/core';

import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ApiService } from '../../servicios/api/api.service';
import { registroI } from '../../modelos/registro.interface';

@Component({
  selector: 'app-editar-perfil',
  templateUrl: './editar-perfil.component.html',
  styleUrls: ['./editar-perfil.component.css']
})
export class EditarPerfilComponent implements OnInit {

  editarPerfilForm = new FormGroup({
    usuario : new FormControl('', Validators.required),
    password : new FormControl('', Validators.required),
    nombre : new FormControl('', Validators.required),
    apellido : new FormControl('', Validators.required),
    email: new FormControl('', Validators.required)
  })

  constructor(private api: ApiService) { }

  ngOnInit(): void {
  }

  onEditar(form: registroI){
    let nuevoForm = {
      "nombreUsuario": form.usuario,
      "contraseña": form.password,
      "nombre": form.nombre,
      "apellido": form.apellido,
      "email": form.email
    }
    let id = localStorage.getItem("userID");
    this.api.editarFoodTrucker(nuevoForm, id).subscribe(data => console.log(data));
  }
}
