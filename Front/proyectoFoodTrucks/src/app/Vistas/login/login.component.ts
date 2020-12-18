import { Component, OnInit } from '@angular/core';

import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ApiService } from '../../servicios/api/api.service';
import { LoginI } from '../../modelos/login.interface';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm = new FormGroup({
      usuario : new FormControl('', Validators.required),
      password : new FormControl('', Validators.required)
  })
  constructor(private api:ApiService) { }

  ngOnInit(): void {
  }

  onLogin(form: LoginI){
    let nuevoForm = {
      "username": form.usuario,
      "password": form.password
  }
    console.log(nuevoForm);
    this.api.loginByUsername(nuevoForm).subscribe(data =>{
      console.log(data);
    })
  }
}
