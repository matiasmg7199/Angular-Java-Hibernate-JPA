import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './Vistas/login/login.component';
import { HomeComponent } from './Vistas/home/home.component';
import { RegistroComponent } from './Vistas/registro/registro.component';
import { EditarFoodTruckComponent } from './Vistas/editar-food-truck/editar-food-truck.component';
import { EditarPerfilComponent } from './Vistas/editar-perfil/editar-perfil.component';

const routes: Routes = [
    { path:'' , redirectTo: 'login', pathMatch:'full'},
    { path:'login', component:LoginComponent},
    { path:'home', component:HomeComponent},
    { path:'registro', component:RegistroComponent},
    { path:'editarFoodTruck', component:EditarFoodTruckComponent},
    { path:'editarPerfil', component:EditarPerfilComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule { }
export const routingComponents = [LoginComponent, HomeComponent, RegistroComponent, EditarFoodTruckComponent, EditarPerfilComponent]