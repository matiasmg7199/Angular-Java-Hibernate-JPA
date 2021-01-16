import { Injectable } from '@angular/core';
import { LoginI } from '../../modelos/login.interface';
import { ResponseI } from '../../modelos/response.interface';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { from, Observable } from 'rxjs';
import { ListaFoodTruckersI } from '../../modelos/listaFoodTrucks.interface';
import { identifierModuleUrl } from '@angular/compiler';
@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }
  
  loginByUsername(form: LoginI):Observable<any>{
    let direccion = "http://localhost:8080/ttps-spring/login";
    return this.http.post<any> (direccion, form, { headers: { 'username': form.usuario, 'password': form.password } });
  }

  registroFoodTrucker(form):Observable<ResponseI>{
    let direccion = "http://localhost:8080/ttps-spring/foodtruckers";
    return this.http.post<ResponseI> (direccion, form);
  }

  registroOrganizer(form):Observable<ResponseI>{
    let direccion = "http://localhost:8080/ttps-spring/organizadores";
    return this.http.post<ResponseI> (direccion, form);
  }

  getAllFoodTrucks(id:string): Observable<ListaFoodTruckersI[]>{
    let direccion = "http://localhost:8080/ttps-spring/foodtrucks/" + id;
    console.log(direccion);
    return this.http.get<ListaFoodTruckersI[]>(direccion, { headers: { 'token':localStorage.getItem("token") } });
    //return this.http.get<ListaFoodTruckersI[]>(direccion, { headers: { 'token':localStorage.getItem("token") } });
  }

  getAllZonas(): Observable<String[]>{
    let direccion = "http://localhost:8080/ttps-spring/zonas/";
    console.log(direccion);
    return this.http.get<String[]>(direccion);
  }

  agregarFoodTruck(form, id: string): Observable<ResponseI>{
    let direccion = "http://localhost:8080/ttps-spring/foodtrucks/" + id;
    return this.http.post<ResponseI>(direccion, form, { headers: { 'token':localStorage.getItem("token") } });
  }

  eliminarFoodTruck(id:string): Observable<ResponseI>{
    let direccion = "http://localhost:8080/ttps-spring/foodtrucks/" + id;
    return this.http.delete<ResponseI>(direccion, { headers: { 'token':localStorage.getItem("token") } });
  }
} 
