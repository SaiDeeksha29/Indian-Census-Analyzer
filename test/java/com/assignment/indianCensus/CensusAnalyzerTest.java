package com.assignment.indianCensus;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyzerTest {

	private static final String INDIA_CENSUS_CSV_FILE_PATH = "/Users/saideeksha/Desktop/eclipse-workspace/indianCensus/src/test/resources/IndiaStateCensusData.csv";
	private static final String INDIA_STATECODE_CSV_FILE_PATH = "/Users/saideeksha/Desktop/eclipse-workspace/indianCensus/src/test/resources/IndiaStateCode.csv";
	private static final String WRONG_STATECODE_CSV_FILE_PATH = "/Users/saideeksha/Desktop/eclipse-workspace/indianCensus/src/main/resources/IndiaStateCode.csv";

	@Test
	public void givenIndianCensusCSVFileReturnsCorrectRecords() {
		try {
			CensusAnalyzer censusAnalyser = new CensusAnalyzer();
			int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
			Assert.assertEquals(29, numOfRecords);
		} catch (CensusAnalyzerException e) {
		}
	}

	@Test
	public void givenIndianStateCodeCSVFileReturnsCorrectRecords() {
		try {
			CensusAnalyzer censusAnalyser = new CensusAnalyzer();
			int numOfRecords = censusAnalyser.loadStateCode(INDIA_STATECODE_CSV_FILE_PATH);
			Assert.assertEquals(37, numOfRecords);
		} catch (CensusAnalyzerException e) {
		}
	}

	@Test
	public void givenIndianStateCodeData_WithWrongFile_ShouldThrowException() {
		try {
			CensusAnalyzer censusAnalyser = new CensusAnalyzer();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyzerException.class);
			censusAnalyser.loadStateCode(WRONG_STATECODE_CSV_FILE_PATH);
		} catch (CensusAnalyzerException e) {
			Assert.assertEquals(CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}
}
