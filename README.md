 📘 Ecommerce API — Lab 9 Documentation

## 👤 Author

**Name:** Dizon, Judy Marie A.
**Course:** WS101
**Project:** E-Commerce REST API (Spring Boot)

---

# 🔐 Security Architecture

## Session-Based Authentication (Spring Security)

This application uses **Session-Based Authentication**, not JWT.

### How it works:

1. User logs in via `/login`
2. Spring Security validates credentials
3. Server creates a **HTTP Session**
4. A **JSESSIONID cookie** is sent to the browser
5. Browser automatically includes the cookie in all future requests
6. Server uses the session to identify the authenticated user

### Flow:

Client → Login Request → Server
Server → Creates Session → JSESSIONID Cookie
Client → Stores Cookie
Client → Sends Cookie on every request
Server → Authenticates session automatically

---

# 🛡️ Security Features

* Session-based login (no JWT)
* Role-based access control
* CSRF protection enabled
* Protected endpoints using `@PreAuthorize`
* Logout invalidates session

---

# 🧾 Validation Rules

All incoming data is validated using **Bean Validation (Jakarta Validation)** before reaching the service layer.

## 👤 User Registration

| Field    | Rule                            |
| -------- | ------------------------------- |
| username | @NotBlank, @Size(min=8, max=20) |
| password | @NotBlank, @Size(min=8, max=20) |
| email    | @Email (if used)                |
| role     | Required                        |

---

## 📦 Product

| Field       | Rule      |
| ----------- | --------- |
| prodName    | @NotBlank |
| prodPrice   | @Positive |
| quantity    | @Positive |
| description | @NotBlank |

---

## ⚠️ Validation Behavior

* Invalid input returns **400 Bad Request**
* Error messages are handled globally using `@ControllerAdvice`
* Response format is user-friendly:

```json
{
  "timestamp": "2026-05-08T10:00:00",
  "errors": [
    "Price must be positive",
    "Name must not be blank"
  ]
}
```

---

# 🌐 API Reference

## 🔓 Public Endpoints

| Method | Endpoint              | Description       |
| ------ | --------------------- | ----------------- |
| POST   | /api/v1/auth/register | Register new user |
| GET    | /api/v1/products      | Get all products  |
| GET    | /api/v1/products/{id} | Get product by ID |

---

## 🔐 Authenticated Endpoints

| Method | Endpoint              | Role Required |
| ------ | --------------------- | ------------- |
| POST   | /api/v1/products      | ADMIN         |
| PUT    | /api/v1/products/{id} | ADMIN         |
| DELETE | /api/v1/products/{id} | ADMIN         |
| POST   | /api/v1/orders        | USER / ADMIN  |

---

## 🔑 Authentication Endpoints

| Method | Endpoint | Description                     |
| ------ | -------- | ------------------------------- |
| POST   | /login   | Login user (session created)    |
| POST   | /logout  | Logout user (session destroyed) |

---

# 🔐 Role-Based Access Control

* `ADMIN` → full access to product management
* `USER` → can access order-related endpoints
* Unauthenticated users → only public endpoints

---

# 🧹 Code Quality Standards

## Security Configuration

* All endpoints are clearly defined in `SecurityConfig`
* Role-based restrictions are enforced using:

  * `hasRole("ADMIN")`
  * `isAuthenticated()`
* Session management enabled
* CSRF protection enabled for form login

---

## Validation Handling

* All DTOs use `@Valid`
* Invalid requests are handled globally
* Error responses are structured and readable

---

## Clean Code Practices

* Service layer separates DTO and entity logic
* Controller handles only request/response flow
* Repository handles database access
* No business logic in controllers

---
