#Production Data Collection App - QA Automation Project
# OverView
This project involves **analyzing**, **writing test cases**, **automating**, and **documenting** the testing process of a mobile application used for **Production Data Collection** in an agricultural or controlled-environment context.

The application allows users to:
- Add **Specimen** details (Dome, Line, Set, Chamber, Position)
- Add **Harvesting** data for Grades A–D
- Record **Media Moisture** and **Brix Value**
  
# Project Structure

AppiumAAutomationTestinfD/
│
├── Src main/java
│ └── defaultPackage-->[AddSpicemen.java],[AppLaunch]
│
├── tests/
│ ├── Harvest.java
│ 
│
├── test-data/
│ └── specimen_records.csv
│ └── harvesting_records.csv
│
├──- JRE System Library
│ -- Maven Dependencies

├──--TestNG
├──- src
├──- target
   └──Pom.xml



## Environment Setup

### Prerequisites

- Java JDK **17 or higher**
- Android Studio (SDK + Emulator)
- Appium Server
- Node.js (required for Appium)
- Appium Inspector
- Eclipse Ide
- Android device or emulator
- Git

  # install Java 21
  # install Node.js & Appium
  npm install -g appium command is for installing the appium
  # install Andriod Studio and add Sdk and platform-tools and build-tools and add the path with the specific system enviorment varibles
  System Variables
  C:\Program Files\Java\jdk-21
  C:\Program Files\nodejs\
  C:\Program Files\nodejs\npm
  %ANDROID_HOME%\platform-tools
  %ANDROID_HOME%\emulator
  %ANDROID_HOME%\build-tools\36.0.0
# In pom.xml add dependencies 
  <dependencies>
   <!-- Appium Java Client -->
    <!-- Selenium Java -->
<!-- Compiler Plugin -->
    </dependency>
# write Manual Test Cases for the application 
  and execute them with positive and negative scenarios and edge cases 

  # write automation testcases and execute it i have written some testcases in the above Poject
  - for launch the application
  - for Creating the the Specimen 
  - for Add Harvesting Section with 50 records given automaticlly as the input field

# Commit and push the code to git repo by adding comments for the code 
