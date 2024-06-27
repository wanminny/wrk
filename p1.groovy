//流水线测试ok
def git_address = "https://github.com/wanminny/wrk.git"
def git_auth = "github_my_wrk"

// 创建一个Pod的模板，label为jenkins-slave
podTemplate(label: 'jenkins-slave', cloud: 'k8s', containers: [
        containerTemplate(
                name: 'jnlp',
                image: "wanminny/jnlp:v4"
        )
]) {
    // 引用jenkins-slave的pod模块来构建Jenkins-Slave的pod
    node("jenkins-slave") {
        // 第一步
        stage('拉取代码') {
            checkout([$class: 'GitSCM',
                      branches: [[name: 'master']],
                      userRemoteConfigs: [[credentialsId: "${git_auth}", url: "${git_address}"]]
            ])
        }
    }
}