@echo off
title Employee Onboarding App - Launcher

echo ============================================
echo   Employee Onboarding Application Launcher
echo ============================================
echo.

REM Check if Java is installed
java -version >nul 2>&1
IF %ERRORLEVEL% NEQ 0 (
    echo [ERROR] Java is not installed or not found in PATH.
    echo         Please install Java 17+ and try again.
    echo         Download: https://adoptium.net/
    pause
    exit /b 1
)

echo [OK] Java detected.
echo.

REM Navigate to project directory (same folder as this script)
cd /d "%~dp0"

REM Create data directory if it doesn't exist (for H2 file-based DB)
if not exist "data" (
    mkdir data
    echo [OK] Created data directory for H2 database.
)

echo [INFO] Building and starting the Spring Boot application...
echo [INFO] This may take a minute on first run (downloading dependencies).
echo.
echo [INFO] Once started, open your browser at:
echo        http://localhost:8080
echo.
echo [INFO] H2 Console available at:
echo        http://localhost:8080/h2-console
echo        JDBC URL to enter in console: jdbc:h2:file:./data/onboardingdb
echo        (Username: sa  ^|  Password: [leave blank])
echo.
echo ============================================
echo  Press Ctrl+C to stop the application
echo ============================================
echo.

REM Run the Spring Boot app using Maven Wrapper
call mvnw.cmd spring-boot:run

IF %ERRORLEVEL% NEQ 0 (
    echo.
    echo [ERROR] Application failed to start. Check the output above for details.
    pause
    exit /b 1
)

pause
