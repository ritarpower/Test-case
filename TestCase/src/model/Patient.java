package model;

import java.time.LocalDate;

public abstract class Patient {
    private int id;
    private String codeFile;
    private String codePatient;
    private String name;
    private LocalDate inDate;
    private LocalDate outDate;
    private String reason;

    public Patient(int id, String codeFile, String codePatient, String name, LocalDate inDate, LocalDate outDate, String reason) {
        this.id = id;
        this.codeFile = codeFile;
        this.codePatient = codePatient;
        this.name = name;
        this.inDate = inDate;
        this.outDate = outDate;
        this.reason = reason;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeFile() {
        return codeFile;
    }

    public void setCodeFile(String codeFile) {
        this.codeFile = codeFile;
    }

    public String getCodePatient() {
        return codePatient;
    }

    public void setCodePatient(String codePatient) {
        this.codePatient = codePatient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getInDate() {
        return inDate;
    }

    public void setInDate(LocalDate inDate) {
        this.inDate = inDate;
    }

    public LocalDate getOutDate() {
        return outDate;
    }

    public void setOutDate(LocalDate outDate) {
        this.outDate = outDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public abstract String toString();
}
