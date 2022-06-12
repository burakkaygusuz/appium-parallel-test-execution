# Appium Parallel Test Execution

![Appium](https://img.shields.io/maven-central/v/io.appium/java-client?color=%23428bca&label=appium&logo=appium&style=for-the-badge) ![TestNG](https://img.shields.io/maven-central/v/org.testng/testng?color=%23ffcc66&label=testng&logo=testng&style=for-the-badge)

Demo project that demonstrates how to test mobile devices in parallel using Appium 2.0 and TestNG.

## Prerequisites

Make sure you have installed all the following prerequisites on your development machine:

| OS      | JDK                                | Maven                 | Node.js                    | Android Studio                                |
|---------|------------------------------------|-----------------------|----------------------------|-----------------------------------------------|
| Windows | `scoop install java/temurin17-jdk` | `scoop install maven` | `scoop install nodejs-lts` | `winget install --id=Google.AndroidStudio -e` |
| macOS   | `brew install --cask temurin`      | `brew install maven`  | `brew install node@16`     | `brew install --cask android-studio`          |

- Install the appium server via npm:

```shell
npm install appium@next -g
```

- Install the UIAutomator2 driver.

```shell
appium driver install uiautomator2
```

- Download the
  latest [Selenium Grid Server](https://github.com/SeleniumHQ/selenium/releases/download/selenium-4.2.0/selenium-server-4.2.2.jar)
  .

## Executing Tests

- Create and start the two virtual devices according to a below guide.

> https://developer.android.com/studio/run/managing-avds

- Start appium server.

```shell
appium server -ka 800
```

- Clone the repository.

```shell
git clone git@github.com:burakkaygusuz/appium-parallel-test-execution.git
```

- Start grid server as standalone.

```shell
java -jar selenium-server-4.x.x.jar standalone --config .\path-to-repo\config.toml
```

- Run the test.

```shell
mvn clean test
```



