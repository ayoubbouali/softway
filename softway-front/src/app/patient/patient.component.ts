import {Component, OnInit} from '@angular/core';
import {
  PatientControllerService,
  PatientVO
} from '../remote';
import {Router} from "@angular/router";
import {FormBuilder, FormGroup,Validators} from "@angular/forms";
import {EMAIL_PATTERN} from "../components/validators/mail.validator";
import {NUMBER_PATTERN} from "../components/validators/number.validator";
import {AlertsService} from "../services/alerts.service";

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.scss']
})
export class PatientComponent implements OnInit {

  patient!: PatientVO;
  patientFormGroup!: FormGroup;

  constructor(
    private _patientService: PatientControllerService,
    private _fb: FormBuilder,
    private _router: Router,
    private _formBuilder: FormBuilder,
    private _alertService: AlertsService
  ) {}

  ngOnInit() {
    this.initForm();
  }

  initForm() {
    this.patientFormGroup = this._formBuilder.group({
      nom                : [this.patient?.nom, Validators.compose([Validators.required, Validators.maxLength(30)])],
      email               : [this.patient?.email, Validators.compose([Validators.required, Validators.pattern(EMAIL_PATTERN), Validators.maxLength(50)])],
      healthIndex        : [this.patient?.healthIndex, Validators.compose([Validators.required, Validators.pattern(NUMBER_PATTERN)])],
    });
  }

  onSubmit() {
    if (this.patientFormGroup.valid) {
      this.patient = {
        ...this.patientFormGroup.value
      };
      if (this.patient) {
        this._patientService
            .createPatient(this.patient)
            .subscribe(patient => {
              this._alertService.displaySuccess({ title: "The diagnosis was successfully completed" });
              patient.idPatient && this.goToDiagnoseResultPage(patient.idPatient);
            });
      }
    } else {
      Object.entries(this.getFormValidationErrors(this.patientFormGroup))
        .forEach(el =>
          this._alertService.displayError({ title: "Error in field ("+el[0]+") "+el[1] })
        )
    }
  }

  goToDiagnoseResultPage(patientId: string) {
    this._router.navigate(['patient/showResult',patientId]);
  }

  getFormValidationErrors(formGroup: FormGroup): { [key: string]: string } {
    const errors: { [key: string]: string } = {};
    Object.keys(formGroup.controls).forEach(field => {
      const control = formGroup.get(field);
      if (control instanceof FormGroup) {
        const childErrors = this.getFormValidationErrors(control);
        Object.assign(errors, childErrors);
      } else if(control) {
        if (control.errors) {
          for (const key in control.errors) {
            if (control.errors.hasOwnProperty(key)) {
              errors[field] = this.getValidationMessage(key);
            }
          }
        }
      }
    });
    return errors;
  }

  getValidationMessage(validatorName: string): string {
    const messages: any = {
      required: 'This field is required',
      email: 'This field dont respect email format',
      maxlength: 'This field don\'t respect max length',
      pattern: 'This field don\'t respect pattern'
    };

    return messages[validatorName];
  }
}
