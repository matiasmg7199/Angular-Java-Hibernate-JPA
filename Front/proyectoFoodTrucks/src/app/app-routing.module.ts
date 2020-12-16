import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './Vistas/login/login.component';
import { HomeComponent } from './Vistas/home/home.component';
import { RegistroComponent } from './Vistas/registro/registro.component';

const routes: Routes = [
    { path:'' , redirectTo: 'login', pathMatch:'full'},
    { path:'login', component:LoginComponent},
    { path:'home', component:HomeComponent},
    { path:'registro', component:RegistroComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule { }
export const routingComponents = [LoginComponent, HomeComponent, RegistroComponent]