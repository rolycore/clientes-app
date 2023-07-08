import { NgModule,LOCALE_ID } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header_component';
import {FooterComponent} from './footer/footer.component';
import { DirectivaComponent } from './directiva/directiva.component';
import { ClientesComponent } from './clientes/clientes.component';
import { EquipoclientesComponent } from './equipoclientes/equipoclientes.component';
import { ClienteService } from './clientes/cliente.service';
import { EquipoclienteService } from './equipoclientes/equipocliente.service';
import { RouterModule,Routes } from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import { FormComponent } from './clientes/form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { registerLocaleData } from '@angular/common';
import localPa from '@angular/common/locales/es-PA';
import { TabsModule } from 'ngx-bootstrap/tabs';
registerLocaleData(localPa,'es-PA');
const routes: Routes=[
{path:'',redirectTo:'/clientes',pathMatch:'full'},
{path:'',redirectTo:'/equipoclientes',pathMatch:'full'},
{path:'directivas',component:DirectivaComponent},
{path:'clientes',component:ClientesComponent},
{path:'clientes/form',component: FormComponent},
{path:'clientes/form/:id',component: FormComponent},
{path:'equipoclientes',component:EquipoclientesComponent},
{path:'equipoclientes/form',component: FormComponent},
{path:'equipoclientes/form/:id',component: FormComponent}
];
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    DirectivaComponent,
    ClientesComponent,
    EquipoclientesComponent,
    FormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    TabsModule.forRoot()
  ],
  providers: [ClienteService,EquipoclienteService,{provide: LOCALE_ID, useValue: 'es-PA'}],
  bootstrap: [AppComponent]
})
export class AppModule { }
