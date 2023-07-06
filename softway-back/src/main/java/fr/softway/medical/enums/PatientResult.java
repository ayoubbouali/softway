package fr.softway.medical.enums;

public enum PatientResult {
    CARDIOLOGY("Cardiologie"),
    TRAUMATOLOGY("Traumatologie");

    private String label;

    PatientResult(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
