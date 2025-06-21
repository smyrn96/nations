# 🌍 Full Stack App Documentation (MariaDB + Spring Boot + Angular)

---

## 🏗 Architecture Overview

- **Database**: MariaDB (via SQL schema)
- **Backend**: Spring Boot (RESTful API)
- **Frontend**: Angular with Angular Material

---

# 🏁 How to Run the Full Stack Application

---

## ✅ Prerequisites

Ensure the following tools are installed:

| Tool           | Version          |
|----------------|------------------|
| Java           | 17 or higher     |
| Maven          | 3.6+             |
| Node.js        | 16+              |
| npm or yarn    | npm 8+ / yarn 1+ |
| Angular CLI    | 15+              |
| MariaDB Server | Installed & running |

---

## 🗃 Step 1: Setup the MariaDB Database

1. **Start MariaDB** (locally or via Docker).
2. **Run your SQL schema** to initialize the DB:

```bash
mysql -u your_user -p your_database < schema.sql
```

## Step 2: Run the Spring Boot API

### Navigate to the backend directory:

```bash
cd path/to/backend-directory
./mvnw spring-boot:run
```

### Example Configuration for MariaDB

```properties
# Database configuration
spring.datasource.url=jdbc:mariadb://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect

# Server settings
server.port=8080

```

### Step 3: Run the Angular Frontend
Navigate to the frontend project directory:
```bash
cd path/to/frontend-directory
npm install
ng serve
```

### Navigate to the client URL:
http://localhost:4200


## 🔙 Backend API (Spring Boot)

### 📁 Base URL

http://localhost:8080/api

pgsql
Αντιγραφή
Επεξεργασία

---

### 🧾 Endpoints

#### 1. `GET /countries`

Fetch all countries with `name`, `area`, and `countryCode2`, ordered by name.

- **Method**: `GET`
- **Response**:
```json
[
  {
    "name": "Germany",
    "area": 357022,
    "countryCode2": "DE"
  }
]
```

#### 2. GET /countries/{code2}/languages
Fetch all spoken languages for a specific country.

- **Method**: `GET`
- **Response**:
```json
[
  {
    "language": "German",
    "isOfficial": true,
    "percentage": 95.0
  }
]
```

#### 3. GET /country-stats/max-gdp-per-population
Return each country's maximum GDP-to-population ratio over the years.

- **Method**: `GET`
- **Response**:
```json

[
  {
    "name": "USA",
    "countryCode3": "USA",
    "year": 2019,
    "population": 331000000,
    "gdp": 21400000000000
  }
]
```

### 4. `GET /country-stats/region-stats`

Fetch country statistics with optional filters:

- **Region**
- **Year range** (`from` and `to`)

---

#### 🔧 Query Parameters

| Parameter | Type   | Description                             | Optional |
|-----------|--------|-----------------------------------------|----------|
| `region`  | string | Filter by region name (e.g., "Europe")  | ✅       |
| `from`    | number | Filter records starting from this year  | ✅       |
| `to`      | number | Filter records up to this year          | ✅       |

---

```json
[
  {
    "continentName": "Asia",
    "regionName": "Southern Asia",
    "countryName": "India",
    "year": 2018,
    "population": 1352617328,
    "gdp": 2700000000000
  },
  {
    "continentName": "Asia",
    "regionName": "Southern Asia",
    "countryName": "India",
    "year": 2019,
    "population": 1366417754,
    "gdp": 2870000000000
  }
]
```

# Frontend Documentation (Angular + Angular Material)

---

## Modules Used

```ts
BrowserModule,
AppRoutingModule,
HttpClientModule,
BrowserAnimationsModule,
MatTableModule,
MatSortModule,
MatPaginatorModule,
FormsModule
```

## 🔁 Angular Routing Configuration

Your application uses the following routes defined in `AppRoutingModule`:

```ts
const routes: Routes = [
  { path: '', component: HomepageComponent },
  { path: 'countries-table', component: CountriesTableComponent },
  { path: 'continents-table', component: ContinentsTableComponent },
  {
    path: 'countries/:countryId/languages',
    component: CountryLanguagesComponent,
  },
  { path: '**', redirectTo: '' }, // wildcard fallback
];

```

# 📺 Angular Screens Overview

This application includes three main screens plus a homepage and a fallback for unknown routes. Each screen uses Angular Material tables and supports dynamic interaction.

---

## 🏠 1. Homepage (`/`)

### Component: `HomepageComponent`

- **Route**: `/`
- **Purpose**: Acts as the entry point of the application.
- **Typical contents**: Navigation to other sections (e.g., buttons or links to `/countries-table` and `/continents-table`).

---

## 🌍 2. Countries Table (`/countries-table`)

### Component: `CountriesTableComponent`

- **Route**: `/countries-table`
- **Purpose**: Displays a list of countries with the highest **GDP per population** ratio.

#### 🗂️ Table Columns:

| Column         | Source Field     |
|----------------|------------------|
| `name`         | Country name     |
| `countryCode3` | 3-letter code    |
| `year`         | Year of the record |
| `population`   | Population       |
| `gdp`          | GDP              |

#### ✅ Features:

- Angular Material `MatTable`, `MatSort`, `MatPaginator`
- Data retrieved from: `GET /countries/max-gdp-per-population`
- Sorted and paginated list of country statistics

---

## 📚 3. Continents Table (`/continents-table`)

### Component: `ContinentsTableComponent`

- **Route**: `/continents-table`
- **Purpose**: Displays statistics across continents, regions, and countries, filtered by region and year range.

#### 🗂️ Table Columns:

| Column     | Description               |
|------------|---------------------------|
| `continentName`| Continent name            |
| `regionName`   | Region name               |
| `countryName`  | Country name              |
| `year`     | Statistical year          |
| `population`| Population in that year |
| `gdp`      | GDP in that year          |

#### 🔍 Filters:

- Dropdown for selecting a region
- `From Year` and `To Year` number inputs
- Uses reactive form or template-driven filters
- Optional: Add pagination for better UX

#### ✅ Data Source:

- API: `GET /region-stats`
- Query params: `region`, `from`, `to`

---

## 🗣️ 4. Country Languages (`/countries/:countryId/languages`)

### Component: `CountryLanguagesComponent`

- **Route**: `/countries/:countryId/languages`
- **Purpose**: Displays all spoken languages in a specific country
- **Activated via**: Click on a country in another screen (e.g., from homepage or countries table)
