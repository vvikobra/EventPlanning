import { useState, useEffect } from "react";
import EventForm from "./components/EventForm";
import EventList from "./components/EventList";
import { STATUS_ACTIONS } from "./constants/eventStatus";
import { postEvent, getEvents } from "./services/api.js";
import "./App.css";

function App() {
  const [events, setEvents] = useState([]);
  const activeEvents = events.filter((e) => e.status === "PLANNING");
  const inactiveEvents = events.filter(
    (e) => e.status === "CONFIRMED" || e.status === "CANCELLED"
  );
  const [error, setError] = useState(null);

  const fetchEvents = async () => {
    try {
      const data = await getEvents();
      setEvents(data);
    } catch (error) {
      setError(error.message);
      alert(error.message);
    }
  };

  useEffect(() => {
    fetchEvents();
  }, []);

  const handleAddEvent = async (event) => {
    try {
      const response = await postEvent(event);
      setEvents((prev) => [...prev, response]);
      setError(null);
    } catch (error) {
      setError(error.message);
    }
  };

  const handleUpdateStatus = async (id, newStatus) => {
    try {
      const functionName = STATUS_ACTIONS[newStatus];
      const updatedEvent = await functionName(id);

      setEvents((prev) => prev.map((e) => (e.id === id ? updatedEvent : e)));
    } catch (error) {
      console.error("Ошибка при обновлении статуса: ", error);
      alert(error.message);
    }
  };

  return (
    <div className="app">
      <header>
        <h1>Event Planner</h1>
      </header>
      <main>
        <section>
          <EventForm onAddEvent={handleAddEvent} />
          {error && <p className="error-message">{error}</p>}
        </section>

        <EventList
          title="Активные мероприятия"
          events={activeEvents}
          onUpdateStatus={handleUpdateStatus}
        />

        <EventList
          title="Архивированные мероприятия"
          events={inactiveEvents}
          onUpdateStatus={handleUpdateStatus}
        />
      </main>
    </div>
  );
}

export default App;
