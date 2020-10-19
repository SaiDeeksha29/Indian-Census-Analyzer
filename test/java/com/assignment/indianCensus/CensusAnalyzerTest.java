package com.assignment.indianCensus;

import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyzerTest {

	private static final String INDIA_CENSUS_CSV_FILE_PATH = "/Users/saideeksha/Desktop/eclipse-workspace/indianCensus/src/test/resources/IndiaStateCensusData.csv";
	private static final String INDIA_STATECODE_CSV_FILE_PATH = "/Users/saideeksha/Desktop/eclipse-workspace/indianCensus/src/test/resources/IndiaStateCode.csv";

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
}
