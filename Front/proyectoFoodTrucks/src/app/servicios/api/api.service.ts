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
  
  loginByUsername(form):Observable<ResponseI>{
    let direccion = "http://localhost:8080/ttps-spring/login";
    return this.http.post<ResponseI> (direccion, form, { headers: { 'username': form.username, 'password': form.password } });
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
    return this.http.get<ListaFoodTruckersI[]>(direccion, { headers: { 'token': "1123456" } });
  }

  agregarFoodTruck(form, id: string): Observable<ResponseI>{
    let direccion = "http://localhost:8080/ttps-spring/foodtrucks/" + id;
    return this.http.post<ResponseI>(direccion, form, { headers: { 'token': "1123456" } });
  }
}
