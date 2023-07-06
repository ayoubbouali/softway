import { Component, Input } from '@angular/core';

@Component({
  selector: 'warning-icn',
  templateUrl: './warning.svg'
})
export class WarningIconComponent {
  @Input() color = "#000";
  @Input() height = "18";
  @Input() width = "3";
}