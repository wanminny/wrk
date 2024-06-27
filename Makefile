# 定义变量
APP_NAME=wrk
VERSION=0.0.1
DOCKER_REGISTRY=10.200.82.51/k8s
NAMESPACE=default
K8S_DEPLOYMENT_FILE=deploy.yaml

# 编译应用
# package命令会编译项目、运行单元测试并打包，但不会将打包文件部署到Maven仓库。
# install命令会在执行package的基础上将打包文件部署到本地Maven仓库，但不会部署到远程仓库
# deploy命令会完成编译、单元测试、打包并将打包文件同时部署到本地和远程Maven仓库。
build:
	mvn clean deploy

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
