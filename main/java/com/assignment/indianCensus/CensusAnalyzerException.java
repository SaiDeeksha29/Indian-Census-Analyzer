package com.assignment.indianCensus;

public class CensusAnalyzerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	enum ExceptionType {
		CENSUS_FILE_PROBLEM
	}

	ExceptionType type;

	public CensusAnalyzerException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}
}
