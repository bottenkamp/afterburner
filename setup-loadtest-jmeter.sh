#!/usr/bin/env bash
cd afterburner-loadtest-jmeter
source setup-afterburner-06-build-and-push-image.sh
cd -
#docker login --username ${DOCKER_USER} --password ${DOCKER_PASSWORD} ${DOCKER_REGISTRY}
#docker tag <your hash for jmeter image> ${DOCKER_REGISTRY}/jmeter
#docker push ${DOCKER_REGISTRY}/jmeter
