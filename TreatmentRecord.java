public class TreatmentRecord {

    private int treatmentId;
    private int patientId;
    private String patientName;
    private String treatmentDate;
    private String doctorName;
    private String treatmentDetails;

    public TreatmentRecord(
            int treatmentId,
            int patientId,
            String patientName,
            String treatmentDate,
            String doctorName,
            String treatmentDetails) {

        this.treatmentId = treatmentId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.treatmentDate = treatmentDate;
        this.doctorName = doctorName;
        this.treatmentDetails = treatmentDetails;
    }

    public int getTreatmentId() {
        return treatmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void displayTreatment() {

        System.out.println("----------------------------------------");
        System.out.println("Treatment ID   : " + treatmentId);
        System.out.println("Patient ID     : " + patientId);
        System.out.println("Patient Name   : " + patientName);
        System.out.println("Treatment Date : " + treatmentDate);
        System.out.println("Doctor Name    : " + doctorName);
        System.out.println("Treatment      : " + treatmentDetails);
        System.out.println("----------------------------------------");
    }
}