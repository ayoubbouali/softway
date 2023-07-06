import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { PatientControllerService, PatientDTO } from '../remote';

@Injectable({
  providedIn: 'root'
})
export class PatientResolver implements Resolve<PatientDTO> {

  constructor(private _patientService: PatientControllerService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<PatientDTO> {
    return this._patientService.getPatientById((route.paramMap.get('idPatient') as string).toUpperCase());
  }
}
