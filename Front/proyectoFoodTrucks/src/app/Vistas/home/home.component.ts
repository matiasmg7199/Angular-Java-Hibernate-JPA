import { Component, OnInit } from '@angular/core';

import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ApiService } from '../../servicios/api/api.service';
import { ListaFoodTruckersI } from '../../modelos/listaFoodTrucks.interface';
import { Router } from '@angular/router'
import { Route } from '@angular/compiler/src/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  agregarFoodForm = new FormGroup({
    nombreFood: new FormControl('', Validators.required),
    descripcionFood: new FormControl('', Validators.required),
    urlFood: new FormControl(''),
    zonaFood: new FormControl('', Validators.required),
    comidaFood: new FormControl('', Validators.required),
    redesFood: new FormControl('', Validators.required)
  })

  modificarFoodForm = new FormGroup({
    nombreFood: new FormControl(),
    descripcionFood: new FormControl('', Validators.required),
    urlFood: new FormControl(''),
    zonaFood: new FormControl('', Validators.required),
    comidaFood: new FormControl('', Validators.required),
    redesFood: new FormControl('', Validators.required)
  })

  foodtrucks: ListaFoodTruckersI[];
  zonas: String[];
  constructor(private api: ApiService, private router: Router) { }

  ngOnInit(): void {
    this.api.getAllFoodTrucks(localStorage.getItem("userID")).subscribe(data =>{
      console.log(data);
      this.foodtrucks = data;
      console.log("Se llamo a getAllFoodtrucks");
    }, error => console.log("No se pudo llamar a la api getAllFoodTrucks"))
    this.api.getAllZonas().subscribe(data =>{
      console.log(data);
      this.zonas = data;
      console.log("Se llamo a zonas");
    }, error => console.log("No se pudo llamar a la api Zonas"))
  }

  onAgregarFoodTruck(form){
    let nuevoForm = {
      "nombre": form.nombreFood,
      "descripcion": form.descripcionFood,
      "zona": {
        "nombre": form.zonaFood
      },
      "comidas": [
        {
          "nombre": form.comidaFood
        }
      ],
      "url": form.urlFood,
      "redesSociales": form.redesFood
   }
    let unId = localStorage.getItem("userID");
    this.api.agregarFoodTruck(nuevoForm, unId).subscribe(data =>{
      this.router.navigate(['/home']);
      console.log(data);
    })
  }
  //Modificar
  eliminarFood(id){
    let confirmacion = confirm("¿Estas seguro que deseas eliminar el Food Truck? Ésta opción hará que se elimine el food truck y todo lo que se relacione a él.")
    if (confirmacion == true)
       this.api.eliminarFoodTruck(id).subscribe(data =>{
       console.log(data);
       this.router.navigate(['/home']);})
  }
}
 