import { Component, Input } from '@angular/core';

@Component({
  selector: 'check-icn',
  templateUrl: './check.svg'
})
export class CheckIconComponent {
  @Input() color = "#000";
  @Input() height = "9";
  @Input() width = "12";
}