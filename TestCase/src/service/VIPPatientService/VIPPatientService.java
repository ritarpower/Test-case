package service.VIPPatientService;

import model.VIPPatient;
import repository.VIPVictim.IVIPPatientRepository;
import repository.VIPVictim.VIPPatientRepository;

import java.util.List;

public class VIPPatientService implements IVIPPatientService {
    private IVIPPatientRepository vipPatientRepository = new VIPPatientRepository();


    @Override
    public List<VIPPatient> getAll() {
        return vipPatientRepository.getAll();
    }

    @Override
    public VIPPatient findByCodeFile(String codeFile) {
        return vipPatientRepository.findByCodeFile(codeFile);
    }

    @Override
    public void addVIPPatient(VIPPatient vipPatient) {
        vipPatientRepository.addVIPPatient(vipPatient);
    }

    @Override
    public void removeVIPPatient(VIPPatient vipPatient) {
        vipPatientRepository.removeVIPPatient(vipPatient);
    }
}
