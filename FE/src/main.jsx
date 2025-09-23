import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./assets/css/bootstrap.min.css";
import "./assets/css/style.css";
import "./index.css";
import App from "./App.jsx";

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <App />
  </StrictMode>
);
