package rocketseat.hdlg.passin.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rocketseat.hdlg.passin.domain.event.exceptions.EventNotFoundException;


@ControllerAdvice //permite que você centralize a lógica de tratamento de exceções, personalização de vinculadores de dados e fornecimento de atributos globais em um único local
public class ExceptionEntityHandler {

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity handleEventNotFound(EventNotFoundException exception){
        return ResponseEntity.notFound().build();
    }

//    @ExceptionHandler(EventFullException.class)
//    public ResponseEntity<ErrorResponseDTO> handleEventFull(EventFullException exception){
//        return ResponseEntity.badRequest().body(new ErrorResponseDTO(exception.getMessage()));
//    }
//
//    @ExceptionHandler(AttendeeNotFoundException.class)
//    public ResponseEntity handleAttendeeFound(AttendeeNotFoundException exception){
//        return ResponseEntity.notFound().build();
//    }
//
//    @ExceptionHandler(AttendeeAlreadyExistException.class)
//    public ResponseEntity handleAttendeeAlreadyExist(AttendeeAlreadyExistException exception){
//        return ResponseEntity.status(HttpStatus.CONFLICT).build();
//    }
//
//    @ExceptionHandler(CheckInAlreadyExistsException.class)
//    public ResponseEntity handleCheckInAlreadyExist(CheckInAlreadyExistsException exception){
//        return ResponseEntity.status(HttpStatus.CONFLICT).build();
//    }
}
