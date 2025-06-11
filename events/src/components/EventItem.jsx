import { EVENT_TYPES } from "../constants/eventType";

function EventItem({ event, onUpdateStatus }) {
  const isActive = event.status === "PLANNING";
  const cardClass = `event-card ${!isActive ? event.status.toLowerCase() : ""}`;

  const handleComplete = () => onUpdateStatus(event.id, "CONFIRMED");
  const handleCancel = () => onUpdateStatus(event.id, "CANCELLED");

  return (
    <div className={cardClass}>
      <h3>{event.name}</h3>
      <p>
        <b>Место:</b> {event.place}
      </p>
      <p>
        <b>Организатор:</b> {event.organizer}
      </p>
      <p>
        <b>Дата:</b> {new Date(event.dateTime).toLocaleString()}
      </p>
      <p>
        <b>Тип:</b> {EVENT_TYPES[event.type] || event.type}
      </p>

      {isActive ? (
        <div className="actions">
          <button className="complete" onClick={handleComplete}>
            Завершить
          </button>
          <button className="cancel" onClick={handleCancel}>
            Отменить
          </button>
        </div>
      ) : event.status === "CANCELLED" ? (
        <div className="actions">
          <button
            className="complete"
            onClick={() => onUpdateStatus(event.id, "PLANNING")}
          >
            Возобновить
          </button>
        </div>
      ) : (
        <p>
          <b>Статус:</b>{" "}
          {event.status === "CONFIRMED" ? "Завершено" : event.status}
        </p>
      )}
    </div>
  );
}

export default EventItem;
