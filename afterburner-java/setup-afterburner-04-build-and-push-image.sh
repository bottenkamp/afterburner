#!/usr/bin/env bash
mvn clean install -DskipTests
mvn package docker:build -DpushImage
