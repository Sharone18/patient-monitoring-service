package com.iitj.ecgserver;

import com.iitj.ecgserver.Model.PatientModel;
import com.iitj.ecgserver.entity.Patient;
import com.iitj.ecgserver.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public void savePatient(PatientModel patientModel) {
        try {
            Patient patientEntity = new Patient();
            patientEntity.setAge(patientModel.getAge());
            patientEntity.setId(patientModel.getId());
            patientEntity.setName(patientModel.getName());
            patientEntity.setGender(patientModel.getGender());
            patientRepository.save(patientEntity);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
