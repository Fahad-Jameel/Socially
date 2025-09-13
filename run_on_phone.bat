@echo off
echo Building and installing Socially app on your phone...
echo.

REM Check if ADB is available
where adb >nul 2>nul
if %errorlevel% neq 0 (
    echo ERROR: ADB not found in PATH. Please install Android SDK Platform Tools first.
    echo Download from: https://developer.android.com/studio/releases/platform-tools
    pause
    exit /b 1
)

REM Check if device is connected
echo Checking for connected devices...
adb devices
echo.

REM Build the project
echo Building the project...
call gradlew assembleDebug
if %errorlevel% neq 0 (
    echo ERROR: Build failed!
    pause
    exit /b 1
)

REM Install on device
echo Installing app on your phone...
adb install -r app\build\outputs\apk\debug\app-debug.apk
if %errorlevel% neq 0 (
    echo ERROR: Installation failed! Make sure USB debugging is enabled on your phone.
    pause
    exit /b 1
)

echo.
echo SUCCESS: App installed successfully!
echo Launching the app...
adb shell am start -n fahadjameel.i210394/.MainActivity

echo.
echo App should now be running on your phone!
pause
