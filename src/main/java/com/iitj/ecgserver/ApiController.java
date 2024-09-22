package com.iitj.ecgserver;

import com.iitj.ecgserver.Model.LoginModel;
import com.iitj.ecgserver.Model.PatientModel;
import com.iitj.ecgserver.Model.VitalModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ApiController {

    private final CsvReaderService csvService;
    private final AuthService authService;
    private final PatientService patientService;

    ApiController(CsvReaderService csvService, AuthService authService, PatientService patientService)
    {
        this.csvService = csvService;
        this.authService = authService;
        this.patientService = patientService;
    }

    @GetMapping("/ecg")
    public Integer getData() {
        return csvService.getNextNumber(); // Sample data
    }

    @GetMapping("/vital-signs")
    public VitalModel getVitalModel() {
        Random random = new Random();
        VitalModel vitalModel = new VitalModel();
        vitalModel.setRespiratoryRate(getRandomInt(10, 21, random)); // Example range
        vitalModel.setPulse(getRandomInt(50, 110, random)); // Example range
        vitalModel.setSystolic(getRandomInt(70, 150, random)); // Example range
        vitalModel.setDiastolic(getRandomInt(40, 100, random)); // Example range
        vitalModel.setTemperature(getRandomDouble(35, 39, random)); // Example range
        vitalModel.setOxygen(getRandomInt(80, 100, random)); // Example range
        return vitalModel;
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody LoginModel loginModel) {
        if (this.authService.authenticate(loginModel.getUserId(), loginModel.getPassword())) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/patient")
    public ResponseEntity<String> savePatient(@RequestBody PatientModel patientModel) {
        try
        {
            this.patientService.savePatient(patientModel);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<String> saveUsers(@RequestBody LoginModel loginModel) {
        try
        {
            this.authService.save(loginModel);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    private int getRandomInt(int min, int max, Random random) {
        return random.nextInt(max - min + 1) + min;
    }

    private double getRandomDouble(double min, double max, Random random) {
        return Math.round((random.nextDouble() * (max - min) + min) * 10.0) / 10.0; // Round to 1 decimal place
    }
}
