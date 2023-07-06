import { AbstractControl, FormControl } from '@angular/forms';
import { seMailsValidator } from './mail.validator';
import { seNumberValidator } from './number.validator';

export function isUndefinedOrEmptyControlValue(control: FormControl | AbstractControl) {
  return !control.value || (!!control.value && control.value.length === 0);
}

export const SeValidators = {
  mails     : seMailsValidator,
  number    : seNumberValidator,
}
