import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  dados: any = {
    nome: null,
    ra: null
  }

  constructor(private router: Router) {}

  clear() {
    this.dados = {};
  }

  submit() {
    this.router.navigate(['receber-form'], {
      queryParams: {
        data: JSON.stringify(this.dados)
      }
    });
  }

}
