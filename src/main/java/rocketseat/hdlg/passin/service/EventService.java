package rocketseat.hdlg.passin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rocketseat.hdlg.passin.domain.attendee.Attendee;
import rocketseat.hdlg.passin.domain.event.Event;
import rocketseat.hdlg.passin.domain.event.exceptions.EventFullException;
import rocketseat.hdlg.passin.domain.event.exceptions.EventNotFoundException;
import rocketseat.hdlg.passin.dto.attendee.AttendeeIdDTO;
import rocketseat.hdlg.passin.dto.attendee.AttendeeRequestDTO;
import rocketseat.hdlg.passin.dto.event.EventIdDTO;
import rocketseat.hdlg.passin.dto.event.EventRequestDTO;
import rocketseat.hdlg.passin.dto.event.EventResponseDTO;
import rocketseat.hdlg.passin.repositories.EventRepository;

import java.text.Normalizer;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final AttendeeService attendeeService;


    public EventResponseDTO getEventDetail(String eventId) {
        Event event = this.eventRepository.findById(eventId).orElseThrow(() -> new EventNotFoundException("Evento nao encontrado com o ID:" + eventId));
//        depois de tratar excepcoes fica
//        Event event = this.getEventById(eventId);
        List<Attendee> attendeeList = this.attendeeService.getAllAttendeesFromEvent(eventId);
        return new EventResponseDTO(event, attendeeList.size());
    }

    public EventIdDTO createEvent(EventRequestDTO eventDTO) {
        Event newEvent = new Event();
        newEvent.setTitle(eventDTO.title());
        newEvent.setDetails(eventDTO.details());
        newEvent.setMaximumAttendees(eventDTO.maximumAttendees());
        newEvent.setSlug(this.createSlug(eventDTO.title()));

        this.eventRepository.save(newEvent);

        return new EventIdDTO(newEvent.getId());

    }


    private String createSlug(String text) {
    //  Um "slug" é uma versão formatada de um texto que é frequentemente usado em URLs para representar um título ou uma identificação de forma amigável aos humanos.


        // Normaliza a string de entrada para lidar com caracteres acentuados ou especiais
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD);

        // Remove todos os diacríticos (símbolos de acentuação) da string normalizada
        return normalized.replaceAll("[\\p{InCOMBINING_DIACRITICAL_MARKS}]", "")
                // Remove todos os caracteres que não são letras ou espaços em branco
                .replaceAll("[^\\w\\s]", "")
                // Substitui todos os espaços em branco por hífens ("-") para criar URLs amigáveis
                .replaceAll("\\s+", "-")
                // Converte a string resultante para minúsculas para consistência
                .toLowerCase();

    }

    public AttendeeIdDTO registerAttendeeOnEvent(String eventId, AttendeeRequestDTO attendeeRequestDTO){
        this.attendeeService.verifyAttendeeSubscription(attendeeRequestDTO.email(), eventId);

        Event event = this.getEventById(eventId);
        List<Attendee> attendeeList = this.attendeeService.getAllAttendeesFromEvent(eventId);

        if(event.getMaximumAttendees() <= attendeeList.size()) throw new EventFullException("Evento esta lotado");

        Attendee newAttendee = new Attendee();
        newAttendee.setName(attendeeRequestDTO.name());
        newAttendee.setEmail(attendeeRequestDTO.email());
        newAttendee.setEvent(event);
        newAttendee.setCreatedAt(LocalDateTime.now());
        this.attendeeService.registerAttendee(newAttendee);

        return new AttendeeIdDTO(newAttendee.getId());

    }

    private Event getEventById(String eventId){
        return this.eventRepository.findById(eventId).orElseThrow(() -> new EventNotFoundException("Event not fount with ID:" + eventId));
    }




}
