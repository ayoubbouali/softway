import { Component, Input } from '@angular/core';

@Component({
  selector: 'error-icn',
  templateUrl: './error.svg'
})
export class ErrorIconComponent {
  @Input() color = "#000";
  @Input() height = "10";
  @Input() width = "10";
}