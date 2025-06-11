import { useState } from "react";

function EventForm({ onAddEvent }) {
  const [form, setForm] = useState({
    name: "",
    place: "",
    organizer: "",
    dateTime: "",
    eventType: "",
  });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const newEvent = {
      ...form,
    };

    onAddEvent(newEvent); 
    setForm({
      name: "",
      place: "",
      organizer: "",
      dateTime: "",
      eventType: "",
    });
  };

  return (
    <form className="event-form" onSubmit={handleSubmit}>
      <h2>Создать мероприятие</h2>
      <input
        type="text"
        name="name"
        placeholder="Название"
        value={form.name}
        onChange={handleChange}
        minLength={2}
        required
      />
      <input
        type="text"
        name="place"
        placeholder="Место проведения"
        value={form.place}
        onChange={handleChange}
        minLength={2}
        required
      />
      <input
        type="text"
        name="organizer"
        placeholder="Организатор"
        value={form.organizer}
        onChange={handleChange}
        minLength={2}
        required
      />
      <input
        type="datetime-local"
        name="dateTime"
        value={form.dateTime}
        onChange={handleChange}
        required
      />
      <select
        name="eventType"
        value={form.eventType}
        onChange={handleChange}
        required
      >
        <option value="">Тип мероприятия</option>
        <option value="BIRTHDAY">День рождения</option>
        <option value="WEDDING">Свадьба</option>
        <option value="CONFERENCE">Конференция</option>
        <option value="CONCERT">Концерт</option>
        <option value="OTHER">Другое</option>
      </select>
      <button type="submit">Создать</button>
    </form>
  );
}

export default EventForm;
