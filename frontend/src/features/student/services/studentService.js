import api from "../../../services/api";

export const getStudentProfile = () => {
  return api.get("/students/me");
};

export const createStudentProfile = (data) => {
  return api.post("/students/profile", data);
};

export const updateStudentProfile = (data) => {
  return api.put("/students/profile", data);
};

export const getStudentById = (id) => {
  return api.get(`/students/${id}`);
};

export const getAllStudents = () => {
  return api.get("/students");
};
