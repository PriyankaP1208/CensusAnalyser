package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyserTest {

    final String INDIAN_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndianStateCensusData.csv";

    @Test
    public void Given_IndianCensusCsvFile_ReturnsCorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29, numOfRecords);
        }catch (CensusAnalyserException e)
        {

        }
    }
}
