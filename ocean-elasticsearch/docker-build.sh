# 构建  docker tag SOURCE_IMAGE[:TAG] 192.168.3.59/di/IMAGE[:TAG]
docker build --tag 192.168.3.59/di/ocean-elasticsearch-service:1.0.0 .

## 推送镜像道harbor仓库中 ，注意推送前需要docker login登录一下   docker login --username jichao
docker push 192.168.3.59/di/ocean-elasticsearch-service:1.0.0