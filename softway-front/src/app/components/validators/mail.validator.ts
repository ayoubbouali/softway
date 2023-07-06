import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';
import { isUndefinedOrEmptyControlValue } from './validators';

export const EMAIL_PATTERN = /^([a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4},?)+$/i;

export function seMailsValidator(): ValidatorFn {

  return (control: AbstractControl): ValidationErrors | null => {
    let valid = true;

    if (!isUndefinedOrEmptyControlValue(control)) {
      valid = EMAIL_PATTERN.test(control.value);
    }

    return valid ? null : { mails: true };
  };

}
