#!usr/bin/env bash

export IMAGE=$1

docker-compose -f jma.yaml up --detach
echo "Success"
