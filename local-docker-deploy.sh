DOCKER_IP="boot2docker ip"

# run zookeeper (docker image will be pulled if not already present)
docker run -d --name zookeeper --publish 2181:2181 jplock/zookeeper

# run kafka
docker run -d --name kafka --publish 9092:9092 --publish 7203:7203 --env EXPOSED_HOST=$DOCKER_IP --env ZOOKEEPER_IP=$DOCKER_IP ches/kafka


