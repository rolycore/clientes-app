import { Component, OnInit  } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-directiva',
  templateUrl: './directiva.component.html'
})
export class DirectivaComponent implements OnInit {
  listaCurso: string[]=['TypeScript','JavaScript','Java SE','C#','PHP'];
  habilitar: boolean= true;
  form!: FormGroup;
  activeTab: number = 1;
  
constructor(private formBuilder: FormBuilder){
  
}
ngOnInit(): void {
  this.form = this.formBuilder.group({
    name: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    age: ['', Validators.required]
  });
  
}
setHabilitar():void{
  this.habilitar=!this.habilitar;
}
onSubmit() {
  if (this.form) {
    if (this.form.valid) {
      // Realizar acciones con los datos del formulario
      console.log('Formulario válido. Enviar datos:', this.form.value);
    } else {
      // El formulario no es válido, mostrar errores o realizar acciones adicionales
      console.log('Formulario inválido. No se puede enviar.');
    }
  }
}

}
