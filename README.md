📘 E-Commerce API Security System

 Authors
Judy Marie Dizon
Shella Mae Colele

Security Type
This project uses **Session-Based Authentication** implemented through Spring Security.

 Authentication is managed using **HTTP Sessions**
 A **JSESSIONID cookie** is generated upon successful login
The system stores authentication state on the **server side**
Users remain logged in until they logout or the session expires

Session Management
Authentication Type: Session-Based Authentication
Cookie Name: `JSESSIONID`
Session Storage:Server-side session tracking

Login Process:
  1. User submits credentials to `/login`
  2. Spring Security validates credentials
  3. A session is created on the server
  4. A `JSESSIONID` cookie is sent to the client
  5. Cookie is used for all authenticated requests


 API Endpoints

Public Endpoints
| Method | Endpoint    | Description         |
| ------ | ----------- | ------------------- |
| POST   | `/register` | Register new user   |
| POST   | `/login`    | User authentication |
| GET    | `/products` | View product list   |

 🔐 Protected Endpoints
| Method | Endpoint  | Description                   |
| ------ | --------- | ----------------------------- |
| POST   | `/orders` | Create order (requires login) |


Security Features
Spring Security Form Login
  Session-based authentication
  CSRF protection enabled
  Role-based access control (ADMIN / USER)
  Method-level security using `@PreAuthorize`



References
 Spring Security Documentation
[Spring Security Reference](https://docs.spring.io/spring-security/reference/index.html?utm_source=chatgpt.com)
 Baeldung Spring Security Guide
[Baeldung Spring Security](https://www.baeldung.com/spring-security?utm_source=chatgpt.com)
 Bean Validation (Jakarta Validation)
[Bean Validation Guide](https://jakarta.ee/specifications/bean-validation/3.0/?utm_source=chatgpt.com)

