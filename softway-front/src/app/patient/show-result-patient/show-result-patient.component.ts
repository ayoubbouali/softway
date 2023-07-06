import { Component } from '@angular/core';
import {
  FormBuilder,
} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import {
  PatientControllerService,
  PatientDTO
} from 'src/app/remote';

@Component({
  selector   : 'se-edit-patient',
  templateUrl: './show-result-patient.component.html',
  styleUrls  : ['./show-result-patient.component.scss'],
})
export class ShowResultPatientComponent {

  patient?: PatientDTO;

  constructor(
    private _patientService: PatientControllerService,
    private _router: Router,
    private _route: ActivatedRoute,
    private _formBuilder: FormBuilder,
  ) {
    this.patient = this._route.snapshot.data?.['patient'] as PatientDTO || {};
  }

}
