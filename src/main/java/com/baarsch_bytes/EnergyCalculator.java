package com.baarsch_bytes;

import com.baarsch_bytes.Exceptions.IllegalArgumentException;

public class EnergyCalculator {

    public double calculateRebate(double kwh, boolean hasSmartDevice, boolean peakOptOut) throws IllegalArgumentException {
        if (kwh <= 0) {
            throw new IllegalArgumentException();
        }

        double rebatePercent = 0.0; //FAULT 1 COULD GO HERE (double rebatePercent == 0.1)

        if (kwh > 500 && kwh <= 1500) { //FAULT 2 COULD BE HERE (if (kwh >= 500 && kwh <= 1500…)
            if (hasSmartDevice && peakOptOut) { //FAULT 5 COULD BE HERE (if (hasSmartDevice && peakOptOut &&  kwh == 826))
                rebatePercent = 0.15;
            } else if (hasSmartDevice || peakOptOut) {
                rebatePercent = 0.10;
            }//FAULT 4 COULD BE HERE (if (kwh == 1200), rebatePercent = 0.30;)

        } else if (kwh > 1500) {
            if (hasSmartDevice && peakOptOut) {
                rebatePercent = 0.20; //FAULT 3 COULD BE HERE (rebatePercent = 0.0)
            } else {
                rebatePercent = 0.05;
            }
        }

        return rebatePercent;
    }
}
