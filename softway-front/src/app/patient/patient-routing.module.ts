import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PatientComponent } from './patient.component';
import {ShowResultPatientComponent} from "./show-result-patient/show-result-patient.component";
import {PatientResolver} from "../resolvers/Patient.resolver";

const routes: Routes = [
  { path: '', component: PatientComponent },
  {
    path       : 'showResult/:idPatient',
    pathMatch  : 'full',
    component  : ShowResultPatientComponent,
    resolve    : { patient: PatientResolver }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PatientRoutingModule { }
