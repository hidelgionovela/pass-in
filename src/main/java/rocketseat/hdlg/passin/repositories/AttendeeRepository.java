package rocketseat.hdlg.passin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rocketseat.hdlg.passin.domain.attendee.Attendee;

import java.util.List;
import java.util.Optional;

public interface AttendeeRepository extends JpaRepository<Attendee, String> {

    List<Attendee> findByEventId(String eventId);

//    Optional porque pode ou nao existir esse attendee
    Optional<Attendee> findByEventIdAndEmail(String eventId, String email);

}
