package repository.VIPVictim;

import common.IOVIPPatient;
import model.VIPPatient;

import java.util.Collections;
import java.util.List;

public class VIPPatientRepository implements IVIPPatientRepository{
    @Override
    public List<VIPPatient> getAll() {
        return IOVIPPatient.readVIPPatientFromFile();
    }

    @Override
    public VIPPatient findByCodeFile(String codeFile) {
        return IOVIPPatient.findVIPPatientByCodeFile(codeFile);
    }

    @Override
    public void addVIPPatient(VIPPatient vipPatient) {
        IOVIPPatient.writeVIPPatientToFile(vipPatient);
    }

    @Override
    public void removeVIPPatient(VIPPatient vipPatient) {
        IOVIPPatient.removeVIPPatientFromFile(vipPatient);
    }
}
