import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ReceberFormPage } from './receber-form.page';

const routes: Routes = [
  {
    path: '',
    component: ReceberFormPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ReceberFormPageRoutingModule {}
