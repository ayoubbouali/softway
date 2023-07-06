export interface Alert {
    type: AlertType;
    title: string;
    message?: string;
    hide: boolean;
}

export enum AlertType {
    Success,
    Info,
    Warning,
    Error,
}
