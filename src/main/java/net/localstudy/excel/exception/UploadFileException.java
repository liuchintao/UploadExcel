package net.localstudy.excel.exception;

@SuppressWarnings("serial")
public class UploadFileException extends RuntimeException {

	public UploadFileException(String message, Throwable cause) {
		super(message, cause);
	}

	public UploadFileException(String message) {
		super(message);
	}

}
