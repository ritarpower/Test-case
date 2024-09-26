package service.NormalPatientService;

import model.NormalPatient;
import repository.NormalVictim.INormalPatientRepository;
import repository.NormalVictim.NormalPatientRepository;

import java.util.Collections;
import java.util.List;

public class NormalPatientService implements INormalPatientService {
    private INormalPatientRepository normalPatientRepository = new NormalPatientRepository();


    @Override
    public List<NormalPatient> getAll() {
        return normalPatientRepository.getAll();
    }

    @Override
    public NormalPatient findbyCodeFile(String codeFile) {
        return normalPatientRepository.findbyCodeFile(codeFile);
    }

    @Override
    public void addNormalPatient(NormalPatient normalPatient) {
        normalPatientRepository.addNormalPatient(normalPatient);
    }

    @Override
    public void removeNormalPatient(NormalPatient normalPatient) {
        normalPatientRepository.removeNormalPatient(normalPatient);
    }
}
