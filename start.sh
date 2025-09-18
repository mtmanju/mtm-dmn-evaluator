#!/bin/bash

echo "🚀 Starting MTM DMN Evaluator Simulator..."
echo "=============================================="

# Check if Java is installed
if ! command -v java &> /dev/null; then
    echo "❌ Java is not installed. Please install Java 21 or higher."
    exit 1
fi

# Check if Maven is installed
if ! command -v mvn &> /dev/null; then
    echo "❌ Maven is not installed. Please install Maven 3.6 or higher."
    exit 1
fi

# Check Java version
JAVA_VERSION=$(java -version 2>&1 | head -n 1 | cut -d'"' -f2 | cut -d'.' -f1)
if [ "$JAVA_VERSION" -lt 21 ]; then
    echo "❌ Java version $JAVA_VERSION is not supported. Please install Java 21 or higher."
    exit 1
fi

echo "✅ Java version: $(java -version 2>&1 | head -n 1)"
echo "✅ Maven version: $(mvn -version | head -n 1)"

# Build the project
echo ""
echo "🔨 Building the project..."
mvn clean install -q

if [ $? -ne 0 ]; then
    echo "❌ Build failed. Please check the error messages above."
    exit 1
fi

echo "✅ Build successful!"

# Start the application
echo ""
echo "🌟 Starting the application..."
echo "📱 Application will be available at: http://localhost:8080"
echo "🎯 Simulator will be available at: http://localhost:8080/simulator"
echo ""
echo "Press Ctrl+C to stop the application"
echo ""

mvn spring-boot:run
