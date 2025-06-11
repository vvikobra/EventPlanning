import EventItem from "./EventItem";

function EventList({ title, events, onUpdateStatus }) {
  return (
    <section>
      <h2>{title}</h2>
      {events.length === 0 ? (
        <p>Нет мероприятий.</p>
      ) : (
        <div className="event-list">
          {events.map((event) => (
            <EventItem
              key={event.id}
              event={event}
              onUpdateStatus={onUpdateStatus}
            />
          ))}
        </div>
      )}
    </section>
  );
}

export default EventList;
