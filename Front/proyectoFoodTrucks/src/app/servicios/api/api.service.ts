import { Injectable } from '@angular/core';
import { LoginI } from '../../modelos/login.interface';
import { ResponseI } from '../../modelos/response.interface';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  url:string = "http://localhost:8080/ttps-spring/auth/login";  
  constructor(private http: HttpClient) { }

  loginByUsername(form):Observable<ResponseI>{
    let direccion = this.url;
    return this.http.post<ResponseI> (direccion, form);
  }

  registroFoodTrucker(form):Observable<ResponseI>{
    let direccion = "http://localhost:8080/ttps-spring/foodtruckers";
    return this.http.post<ResponseI> (direccion, form);
  }

  registroOrganizer(form):Observable<ResponseI>{
    let direccion = "http://localhost:8080/ttps-spring/organizadores";
    return this.http.post<ResponseI> (direccion, form);
  }
}
