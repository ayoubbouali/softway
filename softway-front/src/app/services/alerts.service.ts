import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Alert, AlertType } from '../model/Alert.model';

@Injectable({
  providedIn: 'root',
})
export class AlertsService {
  private subject = new Subject<Alert>();
  public alert$ = this.subject.asObservable();

  private displayAlert(title: string, type: AlertType, message?: string): void {
    this.subject.next({ title: title, message: message, type, hide: false });
  }

  public displayError(content: {title: string, message?: string}): void {
    this.displayAlert(content.title, AlertType.Error, content.message);
  }

  public displaySuccess(content: {title:string, message?: string}): void {
    this.displayAlert(content.title, AlertType.Success, content.message);
  }

  public displayInfo(content: {title: string, message?: string}): void {
    this.displayAlert(content.title, AlertType.Info, content.message);
  }

  public displayWarning(content: {title: string, message?: string}): void {
    this.displayAlert(content.title, AlertType.Warning, content.message);
  }
}
