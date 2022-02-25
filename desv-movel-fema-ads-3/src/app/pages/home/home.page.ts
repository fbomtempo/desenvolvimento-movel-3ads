import { Component } from '@angular/core';
import { NavigationExtras, Router } from '@angular/router';

interface Formacao {

  key: string;
  value: string;
  title: string;

}

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  data: any = {
    nome: '',
    email: '',
    senha: '',
    curso: '',
    periodos: [],
    formacoes: [],
    matriculado: false,
    ativo: false
  };

  formacoes: Formacao[] = [
    {
      key: 'graduacao',
      value: 'Graduação',
      title: 'Gr'
    },
    {
      key: 'pos-graduacao',
      value: 'Pós-Graduação',
      title: 'Esp'
    },
    {
      key: 'mestrado',
      value: 'Mestrado',
      title: 'Mestre'
    },
    {
      key: 'doutorado',
      value: 'Doutorado',
      title: 'Doutor'
    }
  ];

  constructor(private router: Router) {}

  confirmar(): void {
    console.log('confirmar');
    console.log(this.data);

    const extras: NavigationExtras = {
      queryParams: {
        data: JSON.stringify(this.data)
      }
    };

    this.router.navigate(['details'], extras);
  }



  cancelar(): void {
    console.log('cancelar');
    this.data = {};
  }

  remover(): void {
    console.log('remover');
  }

  preencher(): void {
    this.data = {
      nome: 'Jonas',
      email: 'jonas_mend@hotmail.com',
      senha: '123',
      curso: 'ads',
      periodos: ['diurno', 'noturno'],
      formacoes: [
        {
          key: 'mestrado',
          value: 'Mestrado',
          title: 'Mestre'
        },
        {
          key: 'doutorado',
          value: 'Doutorado',
          title: 'Doutor'
        }
      ],
      matriculado: true,
      ativo: false
    };
  }
}
