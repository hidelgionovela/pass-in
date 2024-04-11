package rocketseat.hdlg.passin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rocketseat.hdlg.passin.domain.attendee.Attendee;
import rocketseat.hdlg.passin.domain.checkIn.CheckIn;
import rocketseat.hdlg.passin.domain.checkIn.excepctions.CheckInAlreadyExistsException;
import rocketseat.hdlg.passin.repositories.CheckInRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheckInService {
    private final CheckInRepository checkInRepository;

    public void registerCheckIn(Attendee attendee){
        this.verifyCheckInExists(attendee.getId());
        CheckIn newCheckIn = new CheckIn();
        newCheckIn.setAttendee(attendee);
        newCheckIn.setCreatedAt(LocalDateTime.now());
        this.checkInRepository.save(newCheckIn);
    }

    private void verifyCheckInExists(String attendeeId){
        Optional<CheckIn> isCheckedIn = this.getCheckIn(attendeeId);
        if(isCheckedIn.isPresent()) throw new CheckInAlreadyExistsException("O participante ja fez o check in.");
    }

    public Optional<CheckIn> getCheckIn(String attendeeId){
        return this.checkInRepository.findByAttendeeId(attendeeId);

    }

}
