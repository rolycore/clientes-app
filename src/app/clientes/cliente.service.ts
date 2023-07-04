import { ErrorHandler, Injectable } from '@angular/core';
import { formatDate} from '@angular/common';

//import { CLIENTES } from './cliente.json';
import { Cliente } from './cliente';
import { Observable, throwError,of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import swal from 'sweetalert2'
import { Router } from '@angular/router';
import {catchError,map, tap } from 'rxjs/operators';
@Injectable({
  providedIn: 'root',
})
export class ClienteService {
  private urlEndpoint: string = 'http://localhost:8080/api/clientes';
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient, private router: Router) {}
  //Metodo get que muestra todos los clientes
  getClientes(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(this.urlEndpoint).pipe(
      tap(response =>{
        let clientes=response as Cliente[];
        clientes.forEach(cliente=>{
          console.log('ClienteService : tap 1');
          console.log(cliente.nombre);
        })
      }),
      map(response=> {
        let clientes=response as Cliente[];
        return clientes.map(cliente=> {
          cliente.nombre = cliente.nombre.toUpperCase();
          cliente.apellido = cliente.apellido.toUpperCase();
          //let datePipe = new DatePipe('en-US');

          //cliente.createAt = formatDate(cliente.createAt,'EEEE dd, MMMM yyyy','es-PA');//formatDate(cliente.createAt,'dd-MM-yyyy','en-US');
          return cliente;
        });
      }),
      tap(response =>{
          console.log('ClienteService : tap 2');
          response.forEach(cliente=>{
           console.log(cliente.nombre);
          })
      })
    ); //forma de retornar el verbo get
    //return this.http.get(this.urlEndpoint).pipe(map((response) => as Cliente[])); //esta forma esta deprecada
  }
  //metodo get buscar Cliente por ID
  getCliente(id: any): Observable<Cliente> {
    return this.http.get<Cliente>(`${this.urlEndpoint}/${id}`).pipe(
      catchError(e =>{
        this.router.navigate(['/clientes']);
        console.error(e.error.mensaje);

        swal.fire('Error al editar',e.error.mensaje,'error');
        return throwError(e);
      })
    );
  }
  //Metodo create que crea los clientes
  create(cliente: Cliente): Observable<any> {
    return this.http.post<any>(this.urlEndpoint, cliente, {
      headers: this.httpHeaders,
    }).pipe(
      catchError(e => {
        if(e.status==400){
          return throwError(e);
        }
        console.error(e.error.mensaje);
        swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      }),
      map((response: Cliente | null) => {
        if (response === null) {
          this.router.navigate(['/clientes']);
          throw new Error('Null response received');
        }
        return response;
      })
    );
  }
  //Metodo update que actualizalos clientes por ID
  update(cliente: Cliente): Observable<any> {
    return this.http.put<any>(
      `${this.urlEndpoint}/${cliente.id}`,cliente,{headers: this.httpHeaders }).pipe(
        catchError(e =>{
          if(e.status==400){
            return throwError(e);
          }
          this.router.navigate(['/clientes']);
          console.error(e.error.mensaje);
          swal.fire( e.error.mensaje, e.error.error,'error');
          return throwError(e);
        })
      );
  }
  //Metodo delete que borra el cliente por ID
  delete(id: number):Observable<Cliente>{
    return this.http.delete<Cliente>(`${this.urlEndpoint}/${id}`,{headers: this.httpHeaders })
  }
}
