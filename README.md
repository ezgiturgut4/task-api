# task-api

A minimal Spring Boot REST API built to demonstrate clean layering, validation, exception handling, and testable backend design.

This project is intentionally small. The goal is not to build a large CRUD showcase, but to show how a backend API can evolve in a disciplined way: behavior first, infrastructure later.

## Why this project exists

Many small backend projects become messy very quickly because they jump straight into persistence and framework-heavy code.

This project takes a more deliberate path. It starts with a small in-memory implementation so the API contract, validation rules, error flows, and service boundaries can be made clear first. Persistence can come later, once the behavior is stable and properly tested.

## Current state

Implemented so far:

- `GET /health`
- `GET /tasks`
- `POST /tasks`
- `GET /tasks/{id}`
- validation for task creation
- global exception handling
- in-memory service layer
- initial MockMvc-based testing

Planned next:

- expose `PATCH /tasks/{id}/done`
- expand endpoint test coverage
- introduce PostgreSQL persistence
- add Docker Compose for local development

## Package structure

```text
com.example.taskapi
├─ controller
├─ service
├─ model
├─ exception
└─ TaskApiApplication
