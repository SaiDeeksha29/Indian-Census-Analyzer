package com.assignment.indianCensus;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;
import org.apache.commons.csv.*;

public class CensusAnalyzer {
	public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyzerException {
		CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
		try (CSVParser parser = new CSVParser(new FileReader(csvFilePath), format);
				Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
			CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(IndiaCensusCSV.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
			Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();
			int numOfEntries = 0;
			Iterable<IndiaCensusCSV> csvIterable = () -> censusCSVIterator;
			numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
			return numOfEntries;
		} catch (IOException e) {
			throw new CensusAnalyzerException(e.getMessage(),
					CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM);
		} catch (IllegalStateException e) {
			throw new CensusAnalyzerException(e.getMessage(), CensusAnalyzerException.ExceptionType.UNABLE_TO_PARSE);
		}
	}

	public int loadStateCode(String indiaCensusCSVFilePath) throws CensusAnalyzerException {
		CSVFormat format = CSVFormat.RFC4180.withDelimiter(',').withHeader();
		try (CSVParser parser = new CSVParser(new FileReader(indiaCensusCSVFilePath), format);
				Reader reader = Files.newBufferedReader(Paths.get(indiaCensusCSVFilePath));) {
			CsvToBeanBuilder<IndiaStateCodeCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(IndiaStateCodeCSV.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<IndiaStateCodeCSV> csvToBean = csvToBeanBuilder.build();
			Iterator<IndiaStateCodeCSV> stateCodeCSVIterator = csvToBean.iterator();
			int numOfEntries = 0;
			Iterable<IndiaStateCodeCSV> csvIterable = () -> stateCodeCSVIterator;
			numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
			return numOfEntries;
		} catch (IOException e) {
			throw new CensusAnalyzerException(e.getMessage(),
					CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM);
		} catch (IllegalStateException e) {
			throw new CensusAnalyzerException(e.getMessage(), CensusAnalyzerException.ExceptionType.UNABLE_TO_PARSE);
		}
	}
}
