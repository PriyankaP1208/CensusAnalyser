package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyserTest {

    private static final String INDIAN_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndianStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndianStateCensusData.csv";
    private static final String WRONG_FILE_TYPE = "./src/test/resources/IndianStateCensusData.txt";
    private static final String DELIMITER_CSV_FILE = "./src/test/resources/DelimiterFile.csv";
    private static final String HEADER_CSV_FILE = "./src/test/resources/SampleHeaderFile.csv";

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

    @Test
    public void Given_IndianCensusCsvFile_WithWrongPath_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void Given_IndianCensusCsvFile_WithWrongFileType_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaCensusData(WRONG_FILE_TYPE);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void Given_IndianCensusCsvFile_WithWrongDelimiter_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaCensusData(DELIMITER_CSV_FILE);
        }catch (CensusAnalyserException e)
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.PROBLEM_TO_PARSE, e.type);
        }
    }

    @Test
    public void Given_IndianCensusCsvFile_WithWrongHeader_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaCensusData(HEADER_CSV_FILE);
        }catch (CensusAnalyserException e)
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.PROBLEM_TO_PARSE, e.type);
        }
    }
}
