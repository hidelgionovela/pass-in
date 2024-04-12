package rocketseat.hdlg.passin.domain.checkIn.excepctions;

public class CheckInAlreadyExistsException extends RuntimeException {

    public CheckInAlreadyExistsException(String message){
        super(message);
    }
}
