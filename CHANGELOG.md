# Changelog

All notable changes to the MTM DMN Evaluator Simulator project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Added
- GitHub Actions CI/CD pipeline
- Security scanning with OWASP Dependency Check
- Automated release workflow
- Issue templates for bug reports and feature requests
- Code of Conduct and Contributing guidelines
- Security policy documentation

### Changed
- Improved repository structure for better discoverability
- Enhanced documentation with comprehensive architecture details

## [1.0.0] - 2025-01-18

### Added
- Initial release of MTM DMN Evaluator Simulator
- Support for DMN 1.3, 7.x, and 8+ versions
- Camunda DMN Engine 7.23.0 integration
- Modern, minimal UI with Tailwind CSS
- Drag & drop file upload functionality
- Dynamic form generation based on DMN inputs
- Real-time DMN rule evaluation
- RESTful API endpoints for upload and evaluation
- Sample loan approval DMN file
- Comprehensive error handling
- Responsive design for mobile and desktop
- In-memory caching for decision models
- JSON serialization optimization
- Debug logging for troubleshooting

### Technical Details
- **Backend**: Spring Boot 3.3.0 with Java 21
- **Frontend**: Thymeleaf templates with Tailwind CSS
- **DMN Engine**: Camunda DMN Engine 7.23.0
- **Build Tool**: Maven
- **Architecture**: MVC pattern with service layer

### API Endpoints
- `POST /api/dmn/upload` - Upload and parse DMN files
- `POST /api/dmn/evaluate` - Evaluate DMN decisions

### Features
- 🎨 Elegant minimal UI with premium design
- 📁 Smart DMN file upload and parsing
- ⚡ Real-time DMN rule evaluation
- 🎯 Multi-version DMN support
- 🔧 Enterprise-grade Camunda integration
- 📊 Detailed evaluation results
- 🛡️ Comprehensive error handling

## [0.9.0] - 2025-01-17

### Added
- Initial development version
- Basic DMN file upload functionality
- Simple decision evaluation
- Basic UI implementation

### Changed
- Migrated from KIE DMN to Camunda DMN Engine
- Updated to Java 21 from Java 25
- Improved UI design from flashy to minimal

### Fixed
- JSON serialization issues with DmnModelInstance
- Input expression mapping for DMN evaluation
- Decision ID vs Decision Table ID confusion

## [0.8.0] - 2025-01-16

### Added
- KIE DMN Core integration
- Basic DMN parsing functionality
- Initial UI implementation

### Changed
- Switched from Camunda to KIE DMN engine
- Updated Spring Boot to 3.3.0

### Fixed
- Dependency resolution issues
- Maven build problems

## [0.7.0] - 2025-01-15

### Added
- Initial Camunda DMN Engine integration
- Basic project structure
- Maven configuration

### Changed
- Updated to Java 25 (later reverted to Java 21)
- Initial Spring Boot setup

### Fixed
- Camunda dependency resolution issues

---

## Version History

- **v1.0.0**: First stable release with full functionality
- **v0.9.0**: Development version with major fixes
- **v0.8.0**: KIE DMN integration attempt
- **v0.7.0**: Initial Camunda DMN setup

## Future Roadmap

### Planned Features
- [ ] Database persistence for decisions
- [ ] User authentication and authorization
- [ ] DMN file versioning
- [ ] Batch evaluation support
- [ ] Advanced rule visualization
- [ ] Export evaluation results
- [ ] Integration with external systems
- [ ] Docker containerization
- [ ] Kubernetes deployment guides
- [ ] Performance monitoring
- [ ] Advanced caching strategies

### Technical Improvements
- [ ] Unit test coverage improvement
- [ ] Integration test suite
- [ ] Performance optimization
- [ ] Security enhancements
- [ ] API documentation with OpenAPI/Swagger
- [ ] Monitoring and observability
- [ ] CI/CD pipeline improvements

---

**Note**: This changelog follows the [Keep a Changelog](https://keepachangelog.com/) format and uses [Semantic Versioning](https://semver.org/).
