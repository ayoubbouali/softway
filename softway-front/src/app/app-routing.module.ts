import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PagenotfoundComponent} from "./components/pagenotfound/pagenotfound.component";

const routes: Routes = [
  { path: '', redirectTo: 'patient', pathMatch: 'full' },
  {
    path        : 'patient',
    loadChildren: () =>
    import('./patient/patient.module').then(m => m.PatientModule),
  },
  {
    path     : '**',
    pathMatch: 'full',
    component: PagenotfoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
