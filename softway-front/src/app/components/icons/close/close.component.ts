import { Component, Input } from '@angular/core';

@Component({
  selector: 'close-icn',
  templateUrl: './close.svg'
})
export class CloseIconComponent {
  @Input() color = "#000";
  @Input() height = "17";
  @Input() width = "17";
}
