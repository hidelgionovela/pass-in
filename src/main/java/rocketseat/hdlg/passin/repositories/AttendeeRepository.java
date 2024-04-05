package rocketseat.hdlg.passin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rocketseat.hdlg.passin.domain.attendee.Attendee;

public interface AttendeeRepository extends JpaRepository<Attendee, String> {

//    List<Attendee> findByEventId(String eventId);
//
//    Optional<Attendee> findByEventIdAndEmail(String eventId, String email);

}
