import { Component, EventEmitter, Input, Output } from '@angular/core';
import { AlertType } from 'src/app/model/Alert.model';

@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.scss'],
})
export class AlertComponent {
  @Input() message: string | undefined = "";
  @Input() title = '';
  @Input() type: AlertType = AlertType.Info;
  @Input() hide = false;
  @Output() closeEvent = new EventEmitter<void>();

  public ALERT_TYPE = AlertType;

  close() {
    this.closeEvent.emit();
  }
}
