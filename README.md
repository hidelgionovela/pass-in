# Pass.in

Pass.in is an application for managing participants in face-to-face events, providing a comprehensive solution for organizers and participants.

## About the Project

Pass.in allows organizers to create and manage events, while participants can register for events and issue their credentials for check-in on the day of the event. The system offers a public registration page for each event, making it easy for participants to register.

## Features

### Organizers:
- Registration of new events.
- Viewing event data.
- Viewing the list of registered participants.

### Participants:
- Registration for events.
- Viewing the registration badge.
- Check-in at the event.

## Requirements

### Functional Requirements
- Event registration.
- Viewing event data.
- Viewing the list of participants.
- Registration for events.
- Viewing the registration badge.
- Check-in at the event.

### Business Rules
- Participants can register for an event only once.
- Participants can only register for events with available slots.
- Participants can only check-in at an event once.

### Non-Functional Requirements
- Check-in at the event is done through a QRCode.

## Technologies Used
- Spring Initializr: Java framework for enterprise application development.
- Spring Web: For creating web applications, including RESTful.
- Flyway: For database versioning control and migration.
- Dev Tools: Development tools to increase productivity.
- Lombok: Java library that helps reduce boilerplate code.
- JPA: Java Persistence API for object-relational mapping.

