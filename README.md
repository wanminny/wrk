## 本项目说明：

1. ** JDK 1.8**
2. **Spring Boot 2.x rest**
3. **Maven 构建** 
> mvn clean install
4. **REST 接口**
5. **only for jenkins ci/cd test!** 
6. **替换仓库地址和deploy的地址后；直接make all**

## REST 接口路径

- `http://ip:8080/wrk`
- `http://ip:8080/fab`

## ingress 访问
```angular2html
➜  wrk git:(master) ✗ kubectl get ing
NAME          CLASS   HOSTS     ADDRESS                     PORTS   AGE
wrk-ingress   nginx   wrk.com   10.200.82.79,10.200.82.80   80      35s
```
-  curl -verbose --header 'Host:wrk.com'    10.200.82.80
- curl --header 'Host:wrk.com'    10.200.82.80/fab

