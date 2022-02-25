import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ReceberFormPageRoutingModule } from './receber-form-routing.module';

import { ReceberFormPage } from './receber-form.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ReceberFormPageRoutingModule
  ],
  declarations: [ReceberFormPage]
})
export class ReceberFormPageModule {}
