# <a href="https://dreamli1314.github.io/angboot/"><img width="60px" align="center" src="https://raw.githubusercontent.com/DreamLi1314/angboot/master/client/web/src/favicon.ico" alt="icon"/></a> [angboot](https://dreamli1314.github.io/angboot/) 
[![Build Status](https://travis-ci.org/DreamLi1314/angboot.svg?branch=0.2.1)](https://travis-ci.org/DreamLi1314/angboot)
[![HitCount](http://hits.dwyl.com/DreamLi1314/angboot.svg)](http://hits.dwyl.com/DreamLi1314/angboot)
[![codecov](https://codecov.io/gh/DreamLi1314/angboot/branch/master/graph/badge.svg)](https://codecov.io/gh/DreamLi1314/angboot)
![GitHub issues](https://img.shields.io/github/issues/DreamLi1314/angboot)
![GitHub issues by-label](https://img.shields.io/github/issues/DreamLi1314/angboot/feature?color=%2300FF00&label=Feature)
![GitHub issues by-label](https://img.shields.io/github/issues/DreamLi1314/angboot/bug?color=%23FF0000&label=Bug)
![GitHub repo size](https://img.shields.io/github/repo-size/DreamLi1314/angboot)
![GitHub release](https://img.shields.io/github/release-pre/dreamli1314/angboot)
![GitHub License](https://img.shields.io/github/license/dreamli1314/angboot)
[![Gitter](https://badges.gitter.im/Angboot/Angboot.svg)](https://gitter.im/Angboot/Angboot?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)

## 0. Preview Application
You can preview angboot on [http://javafamily.club](http://javafamily.club)

## 1. Prerequisites
You should have installed the following software and configure the corresponding environment variables:

* JDK: version >= 1.8

## 2. Technical selection
* Java(Basic Framework): Spring Boot 2.1.6
* Security: SpringSecurity
* ORM: Mybatis
* SSO: CAS
* Web: Angular7 + Bootstrap4 + SCSS
* Server: Tomcat
* Datasource: H2 + Druid
* Project Management Tools: Gradle
* Doc Tools: Swagger2, Swagger-UI
* CI Tools: [Travis](https://travis-ci.org/DreamLi1314/angboot)(Default), Jenkins
* Cache: Map(Support Redis, Ehcache etc.)
* RPC: Dubbo
* Schedule: Quartz

## 3. Run application
> execute follow command for install dependencies in your terminal, Note: **just first**.
```
gradlew[.bat] build
```
> execute follow command for start up application
```
gradlew[.bat] server
```

## 4. Versions
* [0.0.0](https://github.com/DreamLi1314/angboot/tree/0.0.0)
* [0.1.x](https://github.com/DreamLi1314/angboot/tree/0.1.x)

## 5. Getting help
* Master version: To see [User Manual](https://dreamli1314.github.io/angboot/).
* Current Version: To see `docs/index.md`

## 6. Todo list of this version
* Upgrade gradle from `v5.x` to `v6.x`.
* Support Schedule Task With `Quartz`.

## 7. Change Log
### Version 0.2.0:
* Split module, microservitization project.
* Support outer authority application with `Dubbo`.
* Support private nexus repository: [http://javafamily.club:8081/](http://javafamily.club:8081/).
* Support Master Application [preview](http://javafamily.club/).
* Support `Swagger/Swagger-UI` for [angboot api doc](http://javafamily.club/swagger-ui.html).

### Version 0.1.x:
* project management tools from `ant + maven` to `gradle`.
* upgrade angular from `v6` to `v7`.

## License
AngBoot is Open Source software released under the Apache 2.0 license.
