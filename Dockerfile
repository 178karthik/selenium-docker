FROM bellsoft/liberica-openjdk-alpine:17.0.8

#Install curl jq

RUN apk add curl jq
#workspace
WORKDIR /home/selenium-docker

#Add the required Files

ADD target/docker-resources ./
ADD runner.sh runner.sh

#Environment Variables
#BROWSER
#HUB_HOST
#TEST_SUITE
#THREAD_COUNT

#for windows user
RUN dos2unix runner.sh

#start the runner.sh
ENTRYPOINT sh runner.sh






