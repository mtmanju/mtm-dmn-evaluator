# MTM DMN Evaluator Simulator

A modern, web-based Camunda DMN Simulator Service that supports DMN 7 and 8+ versions with a beautiful, responsive user interface.

## Features

- 🚀 **Modern UI**: Beautiful, responsive interface built with Tailwind CSS and modern web technologies
- 📁 **Easy Upload**: Drag & drop or browse to upload DMN files (.dmn, .xml)
- 🔄 **Dynamic Forms**: Automatically generated input forms based on DMN decision table structure
- ⚡ **Real-time Evaluation**: Instant DMN rule evaluation with matching results
- 🎯 **Multi-version Support**: Compatible with DMN 1.3, 7.x, and 8+ versions
- 🎨 **Glass Morphism Design**: Modern UI with glass effects and smooth animations

## Technology Stack

- **Backend**: Spring Boot 3.3.0, Java 21
- **DMN Engine**: Camunda DMN Engine 7.21.0
- **Frontend**: Thymeleaf, Tailwind CSS, Vanilla JavaScript
- **Build Tool**: Maven

## Quick Start

### Prerequisites

- Java 21 or higher
- Maven 3.6 or higher

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd mtm-dmn-evaluator
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application**
   - Open your browser and navigate to: `http://localhost:8080`
   - The simulator is available at: `http://localhost:8080/simulator`

## Usage

### 1. Upload DMN File
- Navigate to the simulator page
- Drag and drop your DMN file or click "Browse Files"
- Supported formats: `.dmn`, `.xml`

### 2. Input Parameters
- After upload, a dynamic form will be generated based on your DMN decision table inputs
- Fill in the required values for each input parameter

### 3. Evaluate Decision
- Click "Evaluate Decision" to run the DMN rules
- View the results showing matched rules and output values

## Sample DMN File

A sample loan approval DMN file is included in `src/main/resources/sample.dmn` for testing purposes.

## API Endpoints

### Upload DMN File
```
POST /api/dmn/upload
Content-Type: multipart/form-data
Body: file (DMN file)
```

### Evaluate Decision
```
POST /api/dmn/evaluate
Content-Type: application/json
Body: {
  "decisionId": "string",
  "inputValues": {
    "input1": "value1",
    "input2": "value2"
  }
}
```

## Project Structure

```
src/
├── main/
│   ├── java/com/mtm/dmn/
│   │   ├── controller/          # REST and Web controllers
│   │   ├── model/              # Data models
│   │   ├── service/            # Business logic
│   │   └── DmnEvaluatorApplication.java
│   └── resources/
│       ├── templates/          # Thymeleaf templates
│       ├── sample.dmn         # Sample DMN file
│       └── application.yml    # Configuration
└── test/                      # Test files
```

## Configuration

The application can be configured via `application.yml`:

- **Server Port**: Default 8080
- **File Upload**: Max 10MB file size
- **Logging**: Configurable log levels

## Development

### Running in Development Mode
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

### Building for Production
```bash
mvn clean package -Pprod
```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## License

This project is licensed under the MIT License.

## Support

For support and questions, please open an issue in the repository.
