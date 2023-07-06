import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {PatientRoutingModule} from './patient-routing.module';
import {PatientComponent} from './patient.component';
import {ComponentsModule} from "../components/components.module";
import {ReactiveFormsModule} from '@angular/forms';
import {ShowResultPatientComponent} from "./show-result-patient/show-result-patient.component";


@NgModule({
  declarations: [
    PatientComponent,
    ShowResultPatientComponent
  ],
  imports: [
    CommonModule,
    PatientRoutingModule,
    ComponentsModule,
    ReactiveFormsModule
  ],
  providers: [
  ]
})
export class PatientModule {
}
