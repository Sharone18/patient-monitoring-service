package com.iitj.ecgserver.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VitalModel {

    private int respiratoryRate;
    private int pulse;
    private int systolic;
    private int diastolic;
    private double temperature;
    private int oxygen;
}
