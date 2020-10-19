package com.assignment.indianCensus;

public class CensusAnalyzerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CensusAnalyzerException(String message, String name) {
		super(message);
		this.type = ExceptionType.valueOf(name);
	}

	enum ExceptionType {
		CENSUS_FILE_PROBLEM,UNABLE_TO_PARSE
	}

	ExceptionType type;

	public CensusAnalyzerException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}

	public CensusAnalyzerException(String message, ExceptionType type, Throwable cause) {
		super(message, cause);
		this.type = type;
	}
}
