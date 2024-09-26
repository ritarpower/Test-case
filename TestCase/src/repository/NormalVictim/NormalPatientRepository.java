package repository.NormalVictim;

import common.IONormalPatient;
import model.NormalPatient;

import java.util.Collections;
import java.util.List;

public class NormalPatientRepository implements INormalPatientRepository{
    @Override
    public List<NormalPatient> getAll() {
        return IONormalPatient.readNormalPatientFromFile();
    }

    @Override
    public NormalPatient findbyCodeFile(String codeFile) {
        return IONormalPatient.findNormalPatientByCodeFile(codeFile);
    }

    @Override
    public void addNormalPatient(NormalPatient normalPatient) {
        IONormalPatient.writeNormalPatientToFile(normalPatient);
    }

    @Override
    public void removeNormalPatient(NormalPatient normalPatient) {
        IONormalPatient.removeNormalPatientFromFile(normalPatient);
    }
}
