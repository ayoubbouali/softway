import {CommonModule, DatePipe} from '@angular/common';
import {NgModule} from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import {AlertComponent} from "./alerts/alert/alert.component";
import {CloseIconComponent} from "./icons/close/close.component";
import {CheckIconComponent} from "./icons/check/check.component";
import {ErrorIconComponent} from "./icons/error/error.component";
import {WarningIconComponent} from "./icons/warning/warning.component";

const components = [
  AlertComponent,
  CloseIconComponent,
  CheckIconComponent,
  ErrorIconComponent,
  WarningIconComponent
]

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  declarations: [...components],
  providers: [DatePipe],
  exports: [
    ...components,
    ReactiveFormsModule
  ]
})
export class ComponentsModule {
}
