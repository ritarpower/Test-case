package model;

import java.time.LocalDate;

public class VIPPatient extends Patient {
    private String vipType;
    private LocalDate vipDate;

    public VIPPatient(int id, String codeFile, String codePatient, String name, LocalDate inDate, LocalDate outDate, String reason, String vipType, LocalDate vipDate) {
        super(id, codeFile, codePatient, name, inDate, outDate, reason);
        this.vipType = vipType;
        this.vipDate = vipDate;
    }

    public String getVipType() {
        return vipType;
    }

    public void setVipType(String vipType) {
        this.vipType = vipType;
    }

    public LocalDate getVipDate() {
        return vipDate;
    }

    public void setVipDate(LocalDate vipDate) {
        this.vipDate = vipDate;
    }


    @Override
    public String toString() {
        return "VIPPatient {" + "id=" + getId() + ", codeFile=" + getCodeFile() + ", codePatient=" + getCodePatient() + ", name='" + getName() + "', inDate='" + getInDate() + "', outDate='" +
                getOutDate() + "', reason='" + getReason() + "', vipType='" + getVipType() + "', vipDate='" + getVipDate() + "'}";
    }
}
