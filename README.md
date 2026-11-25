# CareFlow – Patient Admission Management System

A full-stack Patient Admission Management application developed for the **DScribe / Unriddle Technologies Software Engineer Intern – Round 1 Assignment**.

CareFlow helps hospital staff manage patient admission records, search and filter patients, update patient information, and manage discharge status.

## Live Demo

- **Frontend:** https://patient-admission-management-ten.vercel.app/
- **Backend API:** https://patient-admission-management-production.up.railway.app/
- **Patient API:** https://patient-admission-management-production.up.railway.app/api/patients
- **GitHub Repository:** https://github.com/prammu/patient-admission-management

## Tech Stack

**Frontend**
- React.js
- Vite
- JavaScript
- HTML5 and CSS3
- Lucide React

**Backend**
- Java 17+
- Spring Boot 3.5
- Spring Web
- Spring Data JPA
- Bean Validation

**Database**
- H2 file-based database

**Deployment**
- Frontend: Vercel
- Backend: Railway
- Source Control: Git and GitHub

## Features Implemented

1. Add new patient records.
2. View all patient records.
3. Search patients by name using case-insensitive partial matching.
4. Filter patients by ward, department, and doctor.
5. Edit existing patient information.
6. Delete patient records with confirmation.
7. Mark admitted patients as discharged.
8. Responsive user interface for desktop, tablet, and mobile devices.
9. Persistent database storage using H2.

## Patient Information

The application manages the following details:

- Patient Name
- Age
- Gender
- Ward
- Department
- Doctor
- Admission Date
- Admission Status (Admitted / Discharged)

## Validation

Frontend and backend validation are implemented.

- **Name:** Required; accepts alphabetic names with spaces, apostrophes, and hyphens.
- **Age:** Required integer between 0 and 120.
- **Gender:** Required.
- **Ward:** Required.
- **Department:** Required.
- **Doctor:** Required.
- **Admission Date:** Required and cannot be a future date.
- **Status:** Required.

Invalid patient data is rejected by the backend with an appropriate HTTP 400 response.

## Prerequisites

- Java 17 or newer
- Maven 3.8+
- Node.js 18 or newer
- npm

## Run Locally

### 1. Clone the repository

```bash
git clone https://github.com/prammu/patient-admission-management.git
cd patient-admission-management
```

### 2. Start the backend

Open a terminal inside the `backend` directory.

```bash
mvn spring-boot:run
```

The backend runs at:

```text
http://localhost:8080
```

Patient API:

```text
http://localhost:8080/api/patients
```

### 3. Configure the frontend

Open another terminal inside the `frontend` directory.

Create a `.env.local` file containing:

```env
VITE_API_BASE_URL=http://localhost:8080
```

The API base URL must not include `/api`, because the frontend appends that path automatically.

### 4. Start the frontend

Run:

```bash
npm install
npm run dev
```

Open the local URL displayed by Vite, normally:

```text
http://localhost:5173
```

## Database Configuration

The application uses an H2 file-based database with Spring Data JPA.

The database configuration is maintained in:

```text
backend/src/main/resources/application.properties
```

For local development, the database can use:

```properties
spring.datasource.url=jdbc:h2:file:./data/patientdb
```

For Railway deployment, the database is configured to use:

```properties
spring.datasource.url=jdbc:h2:file:/app/data/patientdb
```

A persistent Railway volume should be mounted at `/app/data` to retain database records across deployments and restarts.

The H2 console is available at:

```text
http://localhost:8080/h2-console
```

Use the JDBC URL configured for the environment you are running.

## REST API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/patients` | Retrieve all patients |
| POST | `/api/patients` | Add a new patient |
| PUT | `/api/patients/{id}` | Update patient details |
| DELETE | `/api/patients/{id}` | Delete a patient |
| PATCH | `/api/patients/{id}/discharge` | Mark patient as discharged |

The GET endpoint supports optional query parameters:

- `ward`
- `department`
- `doctor`
- `search`

### Example Patient Request

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

## Deployment Configuration

**Frontend – Vercel**

- Connected to the GitHub repository.
- Root directory: `frontend`.
- Build command: `npm run build`.
- Output directory: `dist`.
- Environment variable:

```env
VITE_API_BASE_URL=https://patient-admission-management-production.up.railway.app
```

**Backend – Railway**

- Connected to the GitHub repository.
- Backend deployed using Spring Boot.
- Uses the Railway-provided port.
- Database configured for `/app/data`.

## Project Structure

```text
patient-admission-management/
│
├── backend/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       └── resources/
│   │           └── application.properties
│   └── pom.xml
│
├── frontend/
│   ├── src/
│   │   ├── App.jsx
│   │   ├── App.css
│   │   ├── main.jsx
│   │   └── styles.css
│   ├── index.html
│   └── package.json
│
├── .gitignore
└── README.md
```

## Testing

The following operations should be tested before submission:

- Add a patient.
- View patient records.
- Search by patient name.
- Filter by ward, department, and doctor.
- Edit patient details.
- Mark a patient as discharged.
- Delete a patient record.
- Refresh the application and verify saved records.
- Verify database persistence after restarting the backend.

## Future Improvements

- Authentication and authorization.
- Integration with a managed production database.
- More advanced patient reporting and analytics.

---
