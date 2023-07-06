import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';
import { isUndefinedOrEmptyControlValue } from './validators';

export const NUMBER_PATTERN = /^\d+$/;

export function seNumberValidator(): ValidatorFn {

  return (control: AbstractControl): ValidationErrors | null => {
    let valid = true;

    if (!isUndefinedOrEmptyControlValue(control)) {
      valid = NUMBER_PATTERN.test(control.value);
    }

    return valid ? null : { senumber: true };
  };

}
