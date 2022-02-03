import express from "express";
import { requestLogger } from "@4pd/shared";

const app = express();

app.use(express.json());

app.use(requestLogger);

export { app };
