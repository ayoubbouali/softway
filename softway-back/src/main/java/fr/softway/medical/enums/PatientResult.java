package fr.softway.medical.enums;

/**
 * Enumeration representing possible patient results or diagnoses.
 *
 * This enum defines two values: CARDIOLOGY and TRAUMATOLOGY, each representing a specific diagnosis related to patients.
 * Each enum value is associated with a label (a human-readable representation) that describes the diagnosis.
 */
public enum PatientResult {
    /**
     * Represents the diagnosis "Cardiologie".
     */
    CARDIOLOGY("Cardiologie"),
    /**
     * Represents the diagnosis "Traumatologie".
     */
    TRAUMATOLOGY("Traumatologie");

    /**
     * The human-readable label associated with each enum value.
     */
    private String label;

    /**
     * Constructor to associate a label with each enum value.
     *
     * @param label The human-readable label representing the diagnosis.
     */
    PatientResult(String label) {
        this.label = label;
    }

    /**
     * Returns the human-readable label associated with the enum value.
     *
     * @return The human-readable label representing the diagnosis.
     */
    @Override
    public String toString() {
        return label;
    }
}
