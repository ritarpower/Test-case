package service.VIPPatientService;

import model.VIPPatient;

import java.util.List;

public interface IVIPPatientService {
    List<VIPPatient> getAll();

    VIPPatient findByCodeFile(String codeFile);

    void addVIPPatient(VIPPatient vipPatient);

    void removeVIPPatient(VIPPatient vipPatient);
}
