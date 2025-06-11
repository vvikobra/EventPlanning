import {
  cancelEvent,
  completeEvent,
  resumeEvent,
} from "../services/api.js";

export const STATUS_ACTIONS = {
  CANCELLED: cancelEvent,
  CONFIRMED: completeEvent,
  PLANNING: resumeEvent,
};