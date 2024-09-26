package repository.VIPVictim;

import model.VIPPatient;

import java.util.List;

public interface IVIPPatientRepository {
    List<VIPPatient> getAll();

    VIPPatient findByCodeFile(String codeFile);

    void addVIPPatient(VIPPatient vipPatient);

    void removeVIPPatient(VIPPatient vipPatient);
}
