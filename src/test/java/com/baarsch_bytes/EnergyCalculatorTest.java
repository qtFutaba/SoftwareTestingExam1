package com.baarsch_bytes;

import com.baarsch_bytes.Exceptions.IllegalArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnergyCalculatorTest {

    //-----------------------------------------------------------------------------------------------------------------------------------------------
    //EQUIVALENCE PARTITION
    //-----------------------------------------------------------------------------------------------------------------------------------------------
    // I determined that all the equivalence partition based tests ultimately were redundant after finishing the boundary value and decision table charts.

    //-----------------------------------------------------------------------------------------------------------------------------------------------
    //BOUNDARY VALUE
    //-----------------------------------------------------------------------------------------------------------------------------------------------

    //TCI 2.1->2.6
    @Test
    void bvaTests() {
        EnergyCalculator energyCalculator = new EnergyCalculator();
        try {
            //TCI 2.1
            assertEquals(0.0 , energyCalculator.calculateRebate(1,false,false));
            //TCI 2.2
            assertEquals(0.0 , energyCalculator.calculateRebate(500,false,false));
            //TCI 2.3
            assertEquals(0.0 , energyCalculator.calculateRebate(501,false,false));
            //TCI 2.4
            assertEquals(0.0 , energyCalculator.calculateRebate(1500,false,false));
            //TCI 2.5
            assertEquals(0.05 , energyCalculator.calculateRebate(1501,false,false));
            //TCI 2.6
            assertEquals(0.05 , energyCalculator.calculateRebate(Integer.MAX_VALUE,false,false));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
    //TCI 2.7 AND 2.8 (ILLEGAL ARGUMENT EXCEPTION)
    @Test
    void bvaIllegalArguments() {
        EnergyCalculator energyCalculator = new EnergyCalculator();
        //TCI 2.7
        assertThrows(IllegalArgumentException.class, () -> {energyCalculator.calculateRebate(-1,false,false);});
        //TCI 2.8
        assertThrows(IllegalArgumentException.class, () -> {energyCalculator.calculateRebate(Integer.MIN_VALUE,false,false);});
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------
    //DECISION TABLE
    //-----------------------------------------------------------------------------------------------------------------------------------------------
    //TCI 3.1->3.12
    @Test
    void dtTests() {
        EnergyCalculator energyCalculator = new EnergyCalculator();
        try {
            //TCI 3.1
            assertEquals(0.0 , energyCalculator.calculateRebate(250,true,true));
            //TCI 3.2
            assertEquals(0.0 , energyCalculator.calculateRebate(250,true,false));
            //TCI 3.3
            assertEquals(0.0 , energyCalculator.calculateRebate(250,false,true));
            //TCI 3.4
            assertEquals(0.0 , energyCalculator.calculateRebate(250,false,false));

            //TCI 3.5
            assertEquals(0.15 , energyCalculator.calculateRebate(1000,true,true));
            //TCI 3.6
            assertEquals(0.10 , energyCalculator.calculateRebate(1000,true,false));
            //TCI 3.7
            assertEquals(0.10 , energyCalculator.calculateRebate(1000,false,true));
            //TCI 3.8
            assertEquals(0.0 , energyCalculator.calculateRebate(1000,false,false));

            //TCI 3.9
            assertEquals(0.20 , energyCalculator.calculateRebate(2500,true,true));
            //TCI 3.10
            assertEquals(0.05 , energyCalculator.calculateRebate(2500,true,false));
            //TCI 3.11
            assertEquals(0.05 , energyCalculator.calculateRebate(2500,false,true));
            //TCI 3.12
            assertEquals(0.05 , energyCalculator.calculateRebate(2500,false,false));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
}