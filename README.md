# CareFlow — Patient Admission Management App

A full-stack patient admission management app for the DScribe / Unriddle Technologies Software Engineer Intern Round 1 task.

## Tech stack
- Frontend: React.js + Vite (JavaScript only)
- Backend: Java 17 + Spring Boot 3.5, Spring Web, Spring Data JPA, Bean Validation
- Database: H2 file-based database (records persist across backend restarts)

## Features implemented
1. Add patient
2. View all patient records
3. Filter by ward, department and doctor
4. Search by patient name (case-insensitive partial match)
5. Edit patient
6. Delete patient with browser confirmation
7. Mark an admitted patient as discharged
8. Responsive layout for desktop, tablet and mobile

## Validation (frontend and backend)
- Name: required; alphabetic name with spaces, apostrophe or hyphen separators
- Age: required integer from 0 through 120
- Gender, ward, department, doctor and status: required and restricted to the supplied lists
- Admission date: required and cannot be after today's date
- Backend returns HTTP 400 with a clear message for invalid data

## Prerequisites
- Java 17 or newer
- Maven 3.8+
- Node.js 18+ and npm

## Run the backend
Open a terminal in `backend`:

```bash
mvn spring-boot:run
```

API base URL: `http://localhost:8080/api`

The H2 database is stored in `backend/data/patientdb.mv.db`. It is file-backed, so patient records remain after restarting the backend. Do not delete the `data` folder if you want to retain records.

Optional H2 console: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:file:./data/patientdb;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE`
- User: `sa`
- Password: (leave blank)

## Run the frontend
Open another terminal in `frontend`:

```bash
npm install
npm run dev
```

Open the local URL printed by Vite (normally `http://localhost:5173`). The frontend expects the backend at `http://localhost:8080`. To use a different API URL, create `frontend/.env` with:

```env
VITE_API_URL=http://localhost:8080/api
```

## REST API
| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/patients` | List patients; optional `ward`, `department`, `doctor`, `search` query params |
| POST | `/api/patients` | Create patient |
| PUT | `/api/patients/{id}` | Update patient |
| DELETE | `/api/patients/{id}` | Delete patient |
| PATCH | `/api/patients/{id}/discharge` | Mark patient discharged |

### Example create request
```json
{
  "name": "Aarav Sharma",
  "age": 32,
  "gender": "Male",
  "ward": "General Ward",
  "department": "Cardiology",
  "doctor": "Dr. Ananya Rao",
  "admissionDate": "2026-11-24",
  "status": "Admitted"
}
```

## Important notes before submission
- The ward, department, doctor and gender values are selectable lists in the UI and are also allow-listed by the backend. Replace the sample doctor/department/ward choices if the assignment brief or evaluator provides a specific master list.
- Test the full flow in a browser after starting both servers: add, search, filter, edit, discharge, delete, then restart the backend and confirm records persist.
- For production deployment, configure a managed database, authentication/authorization and HTTPS. Those are not required in the supplied task brief.
