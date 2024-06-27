# 定义变量
APP_NAME=wrk
VERSION=0.0.1
DOCKER_REGISTRY=10.200.82.51
NAMESPACE=default
K8S_DEPLOYMENT_FILE=k8s-deployment.yaml

# 编译应用
build:
	mvn clean package

# 构建 Docker 镜像
docker-build:
	docker build -t $(DOCKER_REGISTRY)/$(APP_NAME):$(VERSION) .

# 推送 Docker 镜像到仓库
docker-push:
	docker push $(DOCKER_REGISTRY)/$(APP_NAME):$(VERSION)

# 部署到 Kubernetes
deploy:
	kubectl apply -f $(K8S_DEPLOYMENT_FILE) -n $(NAMESPACE)

# 清理
clean:
	mvn clean
	docker rmi $(DOCKER_REGISTRY)/$(APP_NAME):$(VERSION)

# 全部步骤
all: build docker-build docker-push deploy
