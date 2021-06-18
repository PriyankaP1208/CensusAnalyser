package com.bridgelabz;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class CensusAnalyser {
    public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndiaCensusCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();
            Iterable<IndiaCensusCSV> csvIterable = () -> censusCSVIterator;
            int numOfEntries = 0;
            numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
            return numOfEntries;
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.FILE_PROBLEM);
        }catch (RuntimeException e)
        {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.PROBLEM_TO_PARSE);
        }
    }

    public int loadIndiaStateCodeData(String csvFilePath) throws CensusAnalyserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<IndianStatesCodeCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndianStatesCodeCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndianStatesCodeCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IndianStatesCodeCSV> statesCodeCSVIterator = csvToBean.iterator();
            Iterable<IndianStatesCodeCSV> csvIterable = () -> statesCodeCSVIterator;
            int numOfEntries = 0;
            numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
            return numOfEntries;
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.FILE_PROBLEM);
        }
    }
}
