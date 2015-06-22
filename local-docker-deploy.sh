DOCKER_IP="boot2docker ip"

# run zookeeper (docker image will be pulled if not already present)
docker run -d --name zookeeper --publish 2181:2181 jplock/zookeeper

# run kafka
docker run -d --name kafka --publish 9092:9092 --publish 7203:7203 --env EXPOSED_HOST=$DOCKER_IP --env ZOOKEEPER_IP=$DOCKER_IP ches/kafka


# run hadoop
docker run -i -t --name yarn -p 8042:8042 -p 8088:8088 -p 50070:50070 -p 50075:50075 -p 50090:50090 sequenceiq/hadoop-docker:2.4.0 /etc/bootstrap.sh -bash