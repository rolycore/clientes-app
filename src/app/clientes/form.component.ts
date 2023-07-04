import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';
import { ClienteService } from './cliente.service';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl, Validators, AbstractControl } from '@angular/forms';
import swal from 'sweetalert2';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css'],
})
export class FormComponent implements OnInit {

  formulario!: FormGroup;
  public cliente: Cliente = new Cliente();
  public titulo: string = 'Crear Cliente';
  public errores: string[] = [];

  constructor(
    private clienteService: ClienteService,
    private router: Router,
    private activateRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {

    this.formulario = new FormGroup({
      fecha: new FormControl('', Validators.required)
    });
    this.formulario.get('fecha')?.setValidators(this.validarFechaActual.bind(this));
    this.formulario.get('fecha')?.updateValueAndValidity();

    this.cargarCliente();
  }

  cargarCliente(): void {
    this.activateRoute.params.subscribe((params) => {
      let id = params['id'];
      if (id) {
        this.clienteService
          .getCliente(id)
          .subscribe((cliente) => (this.cliente = cliente));
      }
    });
  }

  create(): void {
    this.clienteService.create(this.cliente).subscribe((cliente) => {
      this.router.navigate(['/clientes']);
      swal.fire(
        'Nuevo cliente',
        `El cliente ${this.cliente.nombre} ha sido creado con éxito!`,
        'success'
      );
    }, err=>{
      this.errores = err.error.errors ? err.error.errors as string[] : [];
      console.error('Código del error desde el backend: '+ err.status);
      console.error(err.error.errors);

    });
  }

  update(): void {
    this.clienteService.update(this.cliente).subscribe((json) => {
      this.router.navigate(['/clientes']);
      swal.fire(
        'Cliente Actualizado',
        `${json.mensaje}: ${this.cliente.nombre}`,
        'success'
      );
    }, err=>{
      this.errores = err.error.errors ? err.error.errors as string[] : [];
      console.error('Código del error desde el backend: '+ err.status);
      console.error(err.error.errors);

    });
  }

  validarFechaActual(control: AbstractControl): { [key: string]: any } | null {
    const fechaSeleccionada = new Date(control.value);
    const fechaActual = new Date();

    if (fechaSeleccionada.getTime() > fechaActual.getTime()) {
      return { fechaInvalida: true };
    }

    return null;
  }
}
