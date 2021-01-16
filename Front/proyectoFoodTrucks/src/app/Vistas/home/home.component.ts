import { Component, OnInit } from '@angular/core';

import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ApiService } from '../../servicios/api/api.service';
import { ListaFoodTruckersI } from '../../modelos/listaFoodTrucks.interface';

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
  constructor(private api: ApiService) { }

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
      console.log(data);
    })
  }
  //Modificar
  eliminarFood(id){
    this.api.eliminarFoodTruck(id).subscribe(data =>{
      console.log(data);
    })
  }
}
 