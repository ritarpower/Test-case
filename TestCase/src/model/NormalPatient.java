package model;

import java.time.LocalDate;

public class NormalPatient extends Patient {
    private double fee;

    public NormalPatient(int id, String codeFile, String codePatient, String name, LocalDate inDate, LocalDate outDate, String reason, double fee) {
        super(id, codeFile, codePatient, name, inDate, outDate, reason);
        this.fee = fee;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toData() {
        return "NormalPatient {" + "id=" + getId() + ", codeFile=" + getCodeFile() + ", codePatient=" + getCodePatient() + ", name='" + getName() + "', inDate='" + getInDate() + "', outDate='" +
                getOutDate() + "', reason='" + getReason() + "', fee=" + getFee() + "}";
    }
}
