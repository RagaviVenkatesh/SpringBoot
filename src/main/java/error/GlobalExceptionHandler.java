package error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
		
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		
		ErrorDetails error = new ErrorDetails("server Error", details);
		return new ResponseEntity(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleUserNotFoundExceptions(Exception ex, WebRequest request){
		
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		
		ErrorDetails error = new ErrorDetails("Record not found", details);
		return new ResponseEntity(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleMethodArguementNotValid(Exception ex, WebRequest request){
		
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		
		ErrorDetails error = new ErrorDetails("validation failed", details);
		return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
	}
}
