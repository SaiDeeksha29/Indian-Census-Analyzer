package com.assignment.indianCensus;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CensusAnalyzer {
	public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyzerException {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
			CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(IndiaCensusCSV.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
			Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();
			int namOfEntries = 0;
			while (censusCSVIterator.hasNext()) {
				namOfEntries++;
				censusCSVIterator.next();
			}
			return namOfEntries;
		} catch (IOException e) {
			throw new CensusAnalyzerException(e.getMessage(),
					CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM);
		}
	}
}
