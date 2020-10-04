#!/bin/sh
mvn clean package && docker build -t kamlendupandey/TestMicroClientApp .
docker rm -f TestMicroClientApp 2>/dev/null || true && docker run -it --name TestMicroClientApp -p 8080:8080 -p 4848:4848 -p 8181:8181 --name TestMicroClientApp kamlendupandey/TestMicroClientApp
