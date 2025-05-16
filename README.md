# VI SEM Honors Assignment - Airline Management System ✈️

## Objective

Design an **Airline Management System** using **Spring Boot** with the following features:

- Retrieve **flight schedules**
- Retrieve **ticket details**
- **Create** or **book** a ticket
- **Cancel** a ticket
- All the required **validations** should be in place when necessary for duplication and general checks

---

## API Endpoints

### ✈️ Flights

- `GET /flights?sort=asc|desc`  
  Get all flights (sorted by ascending or descending order)

- `GET /flights/{id}`  
  Get a flight by ID

- `GET /flights/{id}/schedules?dates=YYYY-MM-DD`  
  Get flight schedules for a specific flight and date

### 🎫 Tickets

- `POST /tickets`  
  Create or book a ticket

- `GET /tickets/{id}`  
  Get ticket details by ID

- `DELETE /tickets/{id}`  
  Cancel/delete a ticket by ID

---

## Output Screenshot

![Output](https://github.com/user-attachments/assets/9681b4ad-e156-46cc-a209-73ed236663c2)
