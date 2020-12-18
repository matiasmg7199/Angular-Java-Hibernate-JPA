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
  constructor(private api: ApiService) { }

  ngOnInit(): void {
    let unId="1";
    this.api.getAllFoodTrucks(unId).subscribe(data =>{
      console.log(data);
    })
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
          "nombre": form.nombreFood
        }
      ],
      "url": form.urlFood,
      "redesSociales": form.redesFood
   }
    let unId="1";
    this.api.agregarFoodTruck(nuevoForm, unId).subscribe(data =>{
      console.log(data);
    })
  }
}
