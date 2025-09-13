Write-Host "Building and installing ConnectMe app on your phone..." -ForegroundColor Green
Write-Host ""

# Check if ADB is available
try {
    $adbPath = Get-Command adb -ErrorAction Stop
    Write-Host "ADB found at: $($adbPath.Source)" -ForegroundColor Green
} catch {
    Write-Host "ERROR: ADB not found in PATH. Please install Android SDK Platform Tools first." -ForegroundColor Red
    Write-Host "Download from: https://developer.android.com/studio/releases/platform-tools" -ForegroundColor Yellow
    Read-Host "Press Enter to exit"
    exit 1
}

# Check if device is connected
Write-Host "Checking for connected devices..." -ForegroundColor Yellow
adb devices
Write-Host ""

# Build the project
Write-Host "Building the project..." -ForegroundColor Yellow
& .\gradlew assembleDebug
if ($LASTEXITCODE -ne 0) {
    Write-Host "ERROR: Build failed!" -ForegroundColor Red
    Read-Host "Press Enter to exit"
    exit 1
}

# Install on device
Write-Host "Installing app on your phone..." -ForegroundColor Yellow
adb install -r app\build\outputs\apk\debug\app-debug.apk
if ($LASTEXITCODE -ne 0) {
    Write-Host "ERROR: Installation failed! Make sure USB debugging is enabled on your phone." -ForegroundColor Red
    Read-Host "Press Enter to exit"
    exit 1
}

Write-Host ""
Write-Host "SUCCESS: App installed successfully!" -ForegroundColor Green
Write-Host "Launching the app..." -ForegroundColor Yellow
adb shell am start -n com.shaffinimam.i212963/.MainActivity

Write-Host ""
Write-Host "App should now be running on your phone!" -ForegroundColor Green
Read-Host "Press Enter to exit"
