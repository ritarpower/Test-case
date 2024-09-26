package repository.NormalVictim;

import model.NormalPatient;

import java.util.List;

public interface INormalPatientRepository {
    List<NormalPatient> getAll();

    NormalPatient findbyCodeFile(String codeFile);

    void addNormalPatient(NormalPatient normalPatient);

    void removeNormalPatient(NormalPatient normalPatient);
}
