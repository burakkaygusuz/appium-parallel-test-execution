# Appium Parallel Test Execution

![Appium](https://img.shields.io/maven-central/v/io.appium/java-client?color=%23428bca&label=appium&logo=appium&style=for-the-badge) ![TestNG](https://img.shields.io/maven-central/v/org.testng/testng?color=%23ffcc66&label=testng&logo=testng&style=for-the-badge)

Demo project that demonstrates how to test mobile devices in parallel using Appium 2.0 and TestNG.

## Prerequisites

Make sure you have installed all the following prerequisites on your development machine:

| OS      | JDK                            | Maven                 | Node.js                                 | Android Studio                                |
|---------|--------------------------------|-----------------------|-----------------------------------------|-----------------------------------------------|
| Windows | `scoop install java/openjdk21` | `scoop install maven` | `winget install --id OpenJS.NodeJS.LTS` | `winget install -e --id Google.AndroidStudio` |
| macOS   | `brew install --cask temurin`  | `brew install maven`  | `brew install node@18`                  | `brew install --cask android-studio`          |

- Install the appium server with a driver via npm:

```shell
npm install --global appium --drivers=uiautomator2
```

## Executing Tests

- Create and start the two virtual devices according to the
  guide:  <https://developer.android.com/studio/run/managing-avds>

### Capability Sets

- Emulator 1

```json

{
  "platformName": "android",
  "appium:platformVersion": "14",
  "appium:automationName": "UIAutomator2",
  "appium:udid": "emulator-5554",
  "appium:systemPort": "8101"
}
```

- Emulator 2

```json

{
  "platformName": "android",
  "appium:platformVersion": "13",
  "appium:automationName": "UIAutomator2",
  "appium:udid": "emulator-5556",
  "appium:systemPort": "8102"
}
```

- Clone the repository.

```shell
git clone git@github.com:burakkaygusuz/appium-parallel-test-execution.git
```

- Start the appium servers using the related config files, respectively.

```shell
appium server --config .\src\test\resources\servers\appium_1.yml

appium server --config .\src\test\resources\servers\appium_2.yml
```

- Execute the yml file to install the Grid.

```shell
docker-compose -f docker-compose.yml up
```

- Run the test.

```shell
mvn clean test
```
