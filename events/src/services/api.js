import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8080",
});

export const postEvent = async (event) => {
  try {
    const response = await api.post("/events", {
      name: event.name,
      place: event.place,
      dateTime: event.dateTime,
      organizer: event.organizer,
      eventType: event.eventType,
    });
    return response.data;
  } catch (error) {
    if (error.response) {
      throw new Error(error.response.data || "Ошибка сервера");
    } else if (error.request) {
      throw new Error("Сервер недоступен. Повторите позже.");
    } else {
      throw new Error("Неизвестная ошибка. Проверьте соединение.");
    }    
  }
};

export const getEvents = async () => {
  try {
    const response = await api.get("/events");
    return response.data;
  } catch (error) {
    if (error.response) {
      throw new Error(error.response.data || "Ошибка сервера");
    } else if (error.request) {
      throw new Error("Сервер недоступен. Повторите позже.");
    } else {
      throw new Error("Неизвестная ошибка. Проверьте соединение.");
    }    
  }
};

export const cancelEvent = async (eventId) => {
  try {
    const response = await api.post(`/events/cancel/${eventId}`, {
      eventId: eventId,
    });
    return response.data;
  } catch (error) {
    if (error.response) {
      throw new Error(error.response.data || "Ошибка сервера");
    } else if (error.request) {
      throw new Error("Сервер недоступен. Повторите позже.");
    } else {
      throw new Error("Неизвестная ошибка. Проверьте соединение.");
    }    
  }
};

export const completeEvent = async (eventId) => {
  try {
    const response = await api.post(`/events/complete/${eventId}`, {
      eventId: eventId,
    });
    return response.data;
  } catch (error) {
    if (error.response) {
      throw new Error(error.response.data || "Ошибка сервера");
    } else if (error.request) {
      throw new Error("Сервер недоступен. Повторите позже.");
    }
    else {
      throw new Error("Неизвестная ошибка. Проверьте соединение.");
    }    
  }
};

export const resumeEvent = async (eventId) => {
  try {
    const response = await api.post(`/events/resume/${eventId}`, {
      eventId: eventId,
    });
    return response.data;
  } catch (error) {
    if (error.response) {
      throw new Error(error.response.data || "Ошибка сервера");
    } else if (error.request) {
      throw new Error("Сервер недоступен. Повторите позже.");
    }
    else {
      throw new Error("Неизвестная ошибка. Проверьте соединение.");
    }    
  }
};
