[![Build](https://github.com/UniversityOfHawaii/uh-sql-export/actions/workflows/build.yml/badge.svg)](https://github.com/UniversityOfHawaii/uh-sql-export/actions/workflows/build.yml)

uh-sql-export
===========

SQL Export

##### Overview

A command-line program to create a SQL export file.

##### Build Tool

First, you need to download and install maven (version 3.2.3+).

##### Java

You'll need a Java JDK to build and run the project (version 1.8).

The files for the project are kept in a code repository,
available from here:

https://github.com/fduckart/uh-sql-export

##### Building

Install the necessary project dependencies:

    $ ./mvnw install

To build a deployable jar file:

    $ ./mvnw clean package

Usage:

    $ java -jar exporter.jar --spring.config.location=exporter.properties

