# UI tests for Betcity.ru

## Technology Stack
![](src/test/resources/files/icons/Java.png "Java")
![](src/test/resources/files/icons/Selenide.png "Selenide")
![](src/test/resources/files/icons/Rest-Assured.png "REST-Assured")
![](src/test/resources/files/icons/Gradle.png "Gradle")
![](src/test/resources/files/icons/JUnit5.png "JUnit 5")
![](src/test/resources/files/icons/Allure_Report.png "Allure Report")
![](src/test/resources/files/icons/AllureTestOps.png "Allure TestOps")
![](src/test/resources/files/icons/Jira.png "JIRA")
![](src/test/resources/files/icons/Telegram.png "Telegram Bot")
![](src/test/resources/files/icons/Jenkins.png "Jenkins")
![](src/test/resources/files/icons/Selenoid.png "Selenoid")
![](src/test/resources/files/icons/Intelij_IDEA.png "IntelliJ IDEA")
![](src/test/resources/files/icons/Github.png "GitHub")

This project has written in [Java](https://go.java/) using [Selenide](https://selenide.org/) framework for UI-tests
and [REST-Assured](https://rest-assured.io/) for API-test. [Gradle](https://gradle.org/) is used to build the project.
[JUnit 5](https://junit.org/junit5/) is used as a unit-testing framework. [Allure Report](http://allure.qatools.ru/),
[Allure TestOps](https://docs.qameta.io/allure-testops/), [Jira](https://www.atlassian.com/software/jira) and
[Telegram Bot](https://github.com/qa-guru/allure-notifications) are used to visualize test results. Tests are launched
from [Jenkins](https://github.com/EIOmelyashchik/qa_guru_final_project/blob/master). [Selenoid](https://aerokube.com/selenoid/)
is used to run browsers in [Docker containers](https://www.docker.com/resources/what-container).


## Description
You can run tests by configuring the following parameters:
- browser (chrome is by default)
- browserVersion (89.0 is by default)
- browserSize (1920x1080 is by default)
- browserMobileView (mobile device name, for example iPhone X)
- remoteDriverUrl (url address from selenoid or grid)
- videoStorage (url address where you should get video)
- threads (number of threads)

![](src/test/resources/files/jenkins_params.png "Jenkins")

#### To run tests locally (default):
`gradle clean test`

#### To run tests on Selenoid:
```
gradle clean test
  -Dweb.remote.driver.url=selenoid.autotests.cloud
  -Dweb.remote.driver.user={USER}
  -Dweb.remote.driver.password={PASSWORD}
    * -Dweb.browser={BROWSER}
    * -Dweb.browser.version={BROWSER_VERSION}
    * -Dweb.browser.size={BROWSER_SIZE}
    * -Dthreads={THREADS_AMOUNT}
```
*optional

## Allure Report
![](src/test/resources/files/allure_report1.png "Allure Report")

#### Test with steps, attached image, console logs and video:
![](src/test/resources/files/allure_report2.png "Allure Report with steps")

#### The video of the test:
![](src/test/resources/files/video_betcity.gif "Video from Selenoid")

## Allure TestOps
#### Launches
![](src/test/resources/files/allure_testops1.png "Allure TestOps Launches")

#### Test cases
![](src/test/resources/files/allure_testops2.png "Allure TestOps Test Cases")

## Telegram bot will show whether smth is broken
![](src/test/resources/files/telegram_bot.png "Telegram bot")

## Jira integration
![](src/test/resources/files/jira.png "Jira Integration")
