#!/bin/bash

REPOSITORY=/home/ubuntu/app/travis

CURRENT_PID=$(pgrep -f springboot-gradle-application)

echo "$CURRENT_PID"

if [ -z ${CURRENT_PID} ]; then
    echo "> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다."
else
    echo "> kill -15 ${CURRENT_PID}"
    kill -15 ${CURRENT_PID}
    sleep 5
fi

cp ${REPOSITORY}/build/build/libs/*.jar ${REPOSITORY}/jar/

echo "> 새 어플리케이션 배포"

JAR_NAME=$(ls ${REPOSITORY}/jar/ |grep 'springboot-gradle-application' | tail -n 1)

echo "> JAR Name: $JAR_NAME"

nohup java -jar ${REPOSITORY}/jar/${JAR_NAME} &
