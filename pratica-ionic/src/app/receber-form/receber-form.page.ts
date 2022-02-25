import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-receber-form',
  templateUrl: './receber-form.page.html',
  styleUrls: ['./receber-form.page.scss'],
})
export class ReceberFormPage implements OnInit {

  dados: any = {};

  constructor(
    private route: ActivatedRoute,
    private location: Location
  ) { }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      if(params && params.data){
        this.dados = JSON.parse(params.data);
      }
    });
  }

  back() {
    this.location.back();
  }
}
