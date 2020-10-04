#!/bin/sh
mvn clean package && docker build -t kamlendupandey/TrialMicroApp .
docker rm -f TrialMicroApp 2>/dev/null || true && docker run -it --name TrialMicroApp -p 8080:8080 -p 4848:4848 -p 8181:8181 --name TrialMicroApp kamlendupandey/TrialMicroApp
