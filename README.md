# 🏥 HealthSystem API – Java EE RESTful Web Service

🏅 **Awarded: 95.6%** – Client-Server Architectures  
🧑‍🎓 Developed by **Leandro Felix**  
📚 *University of Westminster – 2024*

HealthSystem is a modular **Java EE 8** web service designed to manage healthcare-related data through a RESTful API. The application follows a layered architecture and leverages **JAX-RS**, **JPA 2.2**, and **WAR deployment structure** to simulate a real-world healthcare backend.

---

## 🌐 Overview

This project simulates the backend for a hospital management system, supporting:

- 📋 Appointments  
- 💳 Billing  
- 👨‍⚕️ Doctor management  
- 🧾 Medical records  
- 🧍 Patient registration  
- 💊 Prescription tracking

Each module supports full **CRUD operations** via dedicated REST endpoints.

---

## 🧱 Architecture

The project follows a classic **Java EE layered architecture**:

src/
└── main/
├── java/com/healthsystem/
│ ├── dao/ # JPA DAOs for database access
│ ├── model/ # Entity classes (JPA annotations)
│ └── resource/ # RESTful API endpoints (JAX-RS)
├── resources/ # Configuration files (e.g., persistence.xml)
└── webapp/ # Web layer with index.html (optional for testing)


### 📦 Packages

| Package               | Description                              |
|-----------------------|------------------------------------------|
| `dao`                 | Data Access Objects (JPA)                |
| `model`               | Entities representing business objects   |
| `resource`            | RESTful API endpoints                    |
| `resources/META-INF`  | `persistence.xml` for JPA configuration  |
| `webapp`              | Static web resources                     |

---

## 🧠 Technologies Used

- ☕ **Java EE** (JAX-RS, JPA)
- 🗃️ **JPA** with `persistence.xml`
- 🌐 **RESTful APIs** via `@Path` endpoints
- 📄 **HTML Frontend** placeholder (`index.html`)
- 🧪 **Maven** build system

---

## 🔗 Sample Endpoints

```http
GET     /api/doctors
POST    /api/patients
PUT     /api/appointments/{id}
DELETE  /api/billings/{id}
```

Each Resource class corresponds to one entity and supports HTTP methods like GET, POST, PUT, DELETE.

⚙️ Setup & Deployment

# Clone the repository
git clone https://github.com/leandrofelixdev/healthsystem.git

Import as a Maven project in an IDE (e.g., IntelliJ, Eclipse)

Ensure your persistence.xml points to your desired database: <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/healthdb" />

Build and deploy to a Java EE-compatible server (e.g., Payara, WildFly, TomEE)

Test endpoints using Postman or cURL

📋 Example Entity
@Entity
public class Patient {
    @Id
    private String patientId;
    private String name;
    private String contactInfo;
}

🧪 Testing
✅ Unit-tested DAO layers using local database

✅ Endpoints validated via Postman

✅ Data persisted through JPA to relational DB

📝 Notes
This project was developed as part of the Client-Server Architectures module.
You may configure cross-entity relationships using @OneToMany, @ManyToOne, etc., as needed.

📜 License
Shared for educational and portfolio purposes only.

🙌 Credits
Made with 🧠 and ☕ in Java EE
By Leandro Felix
University of Westminster – 2024