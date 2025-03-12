# Traini8 Training Center Registry

A Spring Boot API for managing government-funded training centers (MVP).

## Setup

### Prerequisites
- Java 17
- MySQL
- Maven

### Steps
1. **Create Database**:
   ```sql
   CREATE DATABASE trainingcenterdb;
   ```

2. **Configure Database** (`src/main/resources/application.properties`):
   ```properties
   spring.datasource.username=YOUR_USERNAME
   spring.datasource.password=YOUR_PASSWORD
   ```

3. **Run Application**:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## API Endpoints

### 1. Create Training Center (POST)
**URL**: `POST http://localhost:8080/api/training-centers`

**Sample Request**:
```json
{
    "centerName": "Mumbai Tech Institute",
    "centerCode": "MUMTECH2024A",
    "address": {
        "detailedAddress": "Tech Valley, Andheri East",
        "city": "Mumbai",
        "state": "Maharashtra",
        "pincode": 400069
    },
    "studentCapacity": 500,
    "coursesOffered": ["Java", "Python"],
    "contactEmail": "info@mumbaiti.com",
    "contactPhone": "9876543210"
}
```

**response**:
```json
{
    "centerName": "Mumbai Tech Institute",
    "centerCode": "MUMTECH2024A",
    "address": {
        "detailedAddress": "Tech Valley, Andheri East",
        "city": "Mumbai",
        "state": "Maharashtra",
        "pincode": 400069
    },
    "studentCapacity": 500,
    "coursesOffered": [
        "Java",
        "Python"
    ],
    "contactEmail": "info@mumbaiti.com",
    "contactPhone": "9876543210"
}
```

### 2. Get All Centers (GET)
**URL**: `GET http://localhost:8080/api/training-centers`

**response**:
```json
[
    {
        "centerName": "Mumbai IT Institute",
        "centerCode": "MUMIT2024XYZ",
        "address": {
            "detailedAddress": "45/B, Tech Park",
            "city": "Mumbai",
            "state": "Maharashtra",
            "pincode": 400001
        },
        "studentCapacity": 500,
        "coursesOffered": [
            "Java",
            "Python"
        ],
        "contactEmail": "info@mumbaiit.com",
        "contactPhone": "9876543210"
    },
    {
        "centerName": "Delhi Skill Hub",
        "centerCode": "DELSKILL2024",
        "address": {
            "detailedAddress": "22/7, Connaught Place",
            "city": "New Delhi",
            "state": "Delhi",
            "pincode": 110001
        },
        "studentCapacity": 750,
        "coursesOffered": [
            "Web Development",
            "AI Basics"
        ],
        "contactEmail": "contact@delhiskillhub.in",
        "contactPhone": "8887766554"
    }
]
```

## Validations
| Field             | Rules                                                                 |
|-------------------|-----------------------------------------------------------------------|
| centerName        | Required, <40 chars                                                  |
| centerCode        | Required, exactly 12 alphanumeric chars                              |
| contactPhone      | Required, 10 digits                                                  |
| contactEmail      | Valid email format (if provided)                                     |
| studentCapacity   | Required, number                                                     |
| address           | Detailed address/city/state required, pincode=6 digits               |

## Test Cases

### Valid Request
```json
{
    "centerName": "Delhi Coding School",
    "centerCode": "DELCODE2024XY",
    "address": {
        "detailedAddress": "Connaught Place",
        "city": "New Delhi",
        "state": "Delhi",
        "pincode": 110001
    },
    "studentCapacity": 300,
    "contactPhone": "8765432109"
}
```

### Invalid Request (Error Samples)
```json
{
    "centerName": "A very very long name exceeding 40 characters limit...",
    "centerCode": "SHORTCODE",
    "contactPhone": "123"
}
```

**Expected Error**:
```json
{
    "centerName": "Center name must be less than 40 characters",
    "centerCode": "Center code must be exactly 12 characters",
    "contactPhone": "Phone number must be 10 digits"
}
```

## Database Schema
- Uses MySQL with JPA
- Tables auto-created: `training_center_entity`, `address`, `training_center_entity_courses_offered`
