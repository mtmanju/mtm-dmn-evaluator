# Contributing to MTM DMN Evaluator Simulator

Thank you for your interest in contributing to the MTM DMN Evaluator Simulator! This document provides guidelines and information for contributors.

## Table of Contents

- [Code of Conduct](#code-of-conduct)
- [Getting Started](#getting-started)
- [Development Setup](#development-setup)
- [Contributing Guidelines](#contributing-guidelines)
- [Pull Request Process](#pull-request-process)
- [Issue Reporting](#issue-reporting)
- [DMN Testing](#dmn-testing)

## Code of Conduct

This project and everyone participating in it is governed by our [Code of Conduct](CODE_OF_CONDUCT.md). By participating, you are expected to uphold this code.

## Getting Started

### Prerequisites

- Java 21 or higher
- Maven 3.6 or higher
- Git
- A modern web browser for testing

### Development Setup

1. **Fork the repository**
   ```bash
   git clone https://github.com/YOUR_USERNAME/mtm-dmn-evaluator.git
   cd mtm-dmn-evaluator
   ```

2. **Set up the development environment**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

3. **Verify the setup**
   - Open http://localhost:8080
   - Upload the sample DMN file
   - Test the evaluation functionality

## Contributing Guidelines

### Types of Contributions

We welcome several types of contributions:

- **Bug fixes**: Fix issues in existing functionality
- **New features**: Add new capabilities to the simulator
- **Documentation**: Improve README, code comments, or API docs
- **DMN examples**: Add sample DMN files for testing
- **UI/UX improvements**: Enhance the user interface
- **Performance optimizations**: Improve speed and efficiency
- **Testing**: Add unit tests, integration tests, or end-to-end tests

### Code Style

- Follow Java naming conventions
- Use meaningful variable and method names
- Add Javadoc comments for public methods
- Keep methods focused and small
- Use consistent indentation (4 spaces)

### Commit Messages

Use clear, descriptive commit messages:

```
feat: add support for DMN 8.0 decision tables
fix: resolve JSON serialization error in DmnDecision
docs: update API documentation with examples
test: add unit tests for DmnService
```

## Pull Request Process

1. **Create a feature branch**
   ```bash
   git checkout -b feature/your-feature-name
   ```

2. **Make your changes**
   - Write clean, well-documented code
   - Add tests for new functionality
   - Update documentation as needed

3. **Test your changes**
   ```bash
   mvn clean test
   mvn spring-boot:run
   ```

4. **Commit your changes**
   ```bash
   git add .
   git commit -m "feat: add your feature description"
   ```

5. **Push to your fork**
   ```bash
   git push origin feature/your-feature-name
   ```

6. **Create a Pull Request**
   - Provide a clear description of your changes
   - Reference any related issues
   - Include screenshots for UI changes
   - Ensure all tests pass

### Pull Request Template

```markdown
## Description
Brief description of the changes made.

## Type of Change
- [ ] Bug fix
- [ ] New feature
- [ ] Documentation update
- [ ] Performance improvement
- [ ] Code refactoring

## Testing
- [ ] Unit tests added/updated
- [ ] Integration tests added/updated
- [ ] Manual testing completed

## DMN Compatibility
- [ ] Tested with DMN 1.3
- [ ] Tested with DMN 7.x
- [ ] Tested with DMN 8+

## Screenshots (if applicable)
Add screenshots for UI changes.

## Checklist
- [ ] Code follows project style guidelines
- [ ] Self-review completed
- [ ] Documentation updated
- [ ] No breaking changes (or clearly documented)
```

## Issue Reporting

### Bug Reports

When reporting bugs, please include:

- **Environment details**: OS, Java version, browser
- **Steps to reproduce**: Clear, numbered steps
- **Expected behavior**: What should happen
- **Actual behavior**: What actually happens
- **DMN file**: If applicable, attach the DMN file
- **Screenshots**: If applicable, include screenshots

### Feature Requests

For feature requests, please include:

- **Use case**: Why is this feature needed?
- **Proposed solution**: How should it work?
- **Alternatives**: Other approaches considered
- **DMN compatibility**: How it affects different DMN versions

## DMN Testing

### Testing with Sample Files

1. **Use the included sample**: `src/main/resources/sample.dmn`
2. **Create your own**: Test with various DMN structures
3. **Test different versions**: DMN 1.3, 7.x, 8+
4. **Test edge cases**: Empty tables, complex rules, etc.

### DMN File Guidelines

When contributing DMN files:

- Use clear, descriptive decision names
- Include comprehensive rule coverage
- Add comments for complex logic
- Test with various input combinations
- Follow DMN best practices

## Development Workflow

### Branch Naming

- `feature/description` - New features
- `fix/description` - Bug fixes
- `docs/description` - Documentation updates
- `refactor/description` - Code refactoring
- `test/description` - Test improvements

### Testing Strategy

1. **Unit Tests**: Test individual methods and classes
2. **Integration Tests**: Test API endpoints
3. **End-to-End Tests**: Test complete user workflows
4. **DMN Tests**: Test with various DMN files

### Performance Considerations

- Keep file uploads under 10MB
- Optimize DMN parsing for large files
- Cache frequently used decisions
- Monitor memory usage during evaluation

## Getting Help

- **GitHub Issues**: For bugs and feature requests
- **Discussions**: For questions and general discussion
- **Documentation**: Check the README and code comments

## Recognition

Contributors will be recognized in:
- CONTRIBUTORS.md file
- Release notes
- Project documentation

Thank you for contributing to the MTM DMN Evaluator Simulator! 🚀
