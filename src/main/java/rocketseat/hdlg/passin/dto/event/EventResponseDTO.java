package rocketseat.hdlg.passin.dto.event;

import lombok.Getter;
import rocketseat.hdlg.passin.domain.event.Event;
@Getter
public class EventResponseDTO {

    EventDetailDTO event;

    public EventResponseDTO(Event event, Integer numberOfAttendees){
//        passar os parametros na ordem que foram passados no record
        this.event = new EventDetailDTO(
                event.getId(),
                event.getTitle(),
                event.getDetails(),
                event.getSlug(),
                event.getMaximumAttendees(),
                numberOfAttendees
        );
    }
}
