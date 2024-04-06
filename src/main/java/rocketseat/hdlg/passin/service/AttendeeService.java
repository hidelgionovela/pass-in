package rocketseat.hdlg.passin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rocketseat.hdlg.passin.domain.attendee.Attendee;
import rocketseat.hdlg.passin.domain.checkIn.CheckIn;
import rocketseat.hdlg.passin.dto.attendee.AttendeeDetails;
import rocketseat.hdlg.passin.dto.attendee.AttendeesListResponseDTO;
import rocketseat.hdlg.passin.repositories.AttendeeRepository;
import rocketseat.hdlg.passin.repositories.CheckInRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttendeeService {

    private final AttendeeRepository attendeeRepository;
    private final CheckInRepository checkInRepository;

    public List<Attendee> getAllAttendeesFromEvent(String eventId){
        return this.attendeeRepository.findByEventId(eventId);
    }

    public AttendeesListResponseDTO getEventsAttendee(String eventId){
        List<Attendee> attendeeList = this.getAllAttendeesFromEvent(eventId);

//        Montando o AttendeeDetails de cada participante mas para tal temos que consultar checkins
        List<AttendeeDetails> attendeeDetailsList = attendeeList.stream().map(attendee -> {
            Optional<CheckIn> checkIn = this.checkInRepository.findByAttendeeId(attendee.getId());
            LocalDateTime checkedInAt = checkIn.<LocalDateTime>map(CheckIn::getCreatedAt).orElse(null);
            return new AttendeeDetails(attendee.getId(), attendee.getName(), attendee.getEmail(), attendee.getCreatedAt(), checkedInAt);
        }).toList();

        return new AttendeesListResponseDTO(attendeeDetailsList);
    }
//
//    public void verifyAttendeeSubscription(String email, String eventId){
//        Optional<Attendee> isAttendeeRegistered = this.attendeeRepository.findByEventIdAndEmail(eventId, email);
//        if(isAttendeeRegistered.isPresent()) throw new AttendeeAlreadyExistException("Attendee already registered");
//
//    }
//
//    public Attendee registerAttendee(Attendee newAttendee){
//        this.attendeeRepository.save(newAttendee);
//        return newAttendee;
//    }
//
//    public void checkInAttendee(String attendeeId){
//        Attendee attendee = this.getAttendee(attendeeId);
//        this.checkInService.registerCheckIn(attendee);
//    }
//
//    private Attendee getAttendee(String attendeeId){
//        return this.attendeeRepository.findById(attendeeId).orElseThrow(() -> new AttendeeNotFoundException("Attendee not found with ID: " + attendeeId));
//    }
//
//
//    public AttendeeBadgeResponseDTO getAttendeeBadge(String attendeeId, UriComponentsBuilder uriComponentsBuilder){
//        Attendee attendee = this.getAttendee(attendeeId);
//
//        var uri = uriComponentsBuilder.path("/attendees/{attendeeId}/check-in").buildAndExpand(attendeeId).toUri().toString();
//
//        AttendeeBadgeDTO attendeeBadgeDTO = new AttendeeBadgeDTO(attendee.getName(), attendee.getEmail(), uri, attendee.getEvent().getId());
//        return new AttendeeBadgeResponseDTO(attendeeBadgeDTO);
//    }
}
