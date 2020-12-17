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
    email: new FormControl('', Validators.required)
  })

  constructor(private api:ApiService) { }

  ngOnInit(): void {
  }

  onRegistro(form: registroI){
    this.api.registroFoodTrucker(form).subscribe(data =>{
      console.log(data);
    })
  }
}
