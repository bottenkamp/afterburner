#!/usr/bin/env bash
source setup-afterburner-01-exports.sh
source setup-afterburner-02-creates.sh
source setup-afterburner-03-exports.sh
cd afterburner-java
source setup-afterburner-04-build-and-push-image.sh
source setup-afterburner-05-create-webapp.sh
cd -
