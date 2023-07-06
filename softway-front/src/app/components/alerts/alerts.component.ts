import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Alert } from '../../model/Alert.model';
import { AlertsService } from '../../services/alerts.service';


const DISPLAY_DELAY = 10000;

/* TRANSITION_DELAY will note affect CSS transition but
   it will only let time for CSS transition to happen
*/
const TRANSITION_DELAY = 500;

@Component({
  selector   : 'app-alerts',
  templateUrl: './alerts.component.html',
  styleUrls  : ['./alerts.component.scss'],
})
export class AlertsComponent implements OnInit, OnDestroy {
  public alerts: Alert[] = [];
  private subscriptions: Subscription[] = [];

  public constructor(private alertsService: AlertsService) {
  }

  public ngOnInit(): void {
    this.subscriptions.push(
      this.alertsService.alert$.subscribe((alert) => {
        this.alerts.push(alert);
        this.deleteAlertAfterDelay(alert);
      })
    );
  }

  public ngOnDestroy(): void {
    this.subscriptions.forEach((subscription) => subscription.unsubscribe());
  }

  private deleteAlertAfterDelay(alert: Alert): void {
    setTimeout(() => {
      this.closeAlert(alert);
    }, DISPLAY_DELAY);
  }

  public closeAlert(alert: Alert): void {
    alert.hide = true;
    setTimeout(() => {
      const alertIndex = this.alerts.findIndex(
        (alertInArray) => alert === alertInArray
      );
      this.alerts.splice(alertIndex, 1);
    }, TRANSITION_DELAY);
  }
}
