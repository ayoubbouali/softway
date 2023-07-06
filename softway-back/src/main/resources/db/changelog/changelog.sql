-- liquibase formatted sql

-- changeset liquibase:SOFTWAY-0
IF
NOT EXISTS (
        SELECT
            COLUMN_NAME
        FROM
            INFORMATION_SCHEMA.COLUMNS
        where
                TABLE_NAME = 'Patient'
    )
BEGIN
CREATE TABLE Patient
(
    id_patient          UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT PK_Patient PRIMARY KEY,
    healthIndex INT              NOT NULL,
    nom VARCHAR(30),
    email VARCHAR(50) NOT NULL
)
END;

-- changeset liquibase:SOFTWAY-1
IF
NOT EXISTS (
        SELECT
            COLUMN_NAME
        FROM
            INFORMATION_SCHEMA.COLUMNS
        where
                TABLE_NAME = 'PatientDiagnoseHistory'
    )
BEGIN
CREATE TABLE PatientDiagnoseHistory
(
    id_patient_history     UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT PK_Patient_HISTORY PRIMARY KEY,
    healthIndex INT NOT NULL,
    dateOfDiagnose DATE NOT NULL,
    id_patient UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT FK_HISTORYPATIENT references Patient
)
CREATE INDEX IX_FK_HISTORYPATIENT ON Patient(id_patient)
END;