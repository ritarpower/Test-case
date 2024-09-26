package service.NormalPatientService;

import model.NormalPatient;

import java.util.List;

public interface INormalPatientService {
    List<NormalPatient> getAll();

    NormalPatient findbyCodeFile(String codeFile);

    void addNormalPatient(NormalPatient normalPatient);

    void removeNormalPatient(NormalPatient normalPatient);
}
