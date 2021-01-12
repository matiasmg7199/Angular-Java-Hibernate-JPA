import { Component, OnInit } from '@angular/core';

import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ApiService } from '../../servicios/api/api.service';
import { LoginI } from '../../modelos/login.interface';
import { ResponseI } from '../../modelos/response.interface';

import { Router } from '@angular/router'
import { from } from 'rxjs';

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
  constructor(private api:ApiService, private router:Router) { }

  ngOnInit(): void {
    if( localStorage.getItem("token") != null && localStorage.getItem("token") != "null" ){
      this.router.navigate(['/home']);
    }
  }

  errorCheck:Boolean=false;

  onLogin(form: LoginI){
    this.api.loginByUsername(form).subscribe(data => {
        localStorage.setItem("token", data.token);
        localStorage.setItem("status", data.status);
        localStorage.setItem("userType", data.type);
        localStorage.setItem("userID", data.userID);
        localStorage.setItem("user", form.usuario);
        this.router.navigate(['/home']);
    }, error => this.errorCheck=true);
  }
}
