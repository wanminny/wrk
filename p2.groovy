//流水线测试ok
def git_address = "https://gitlab.vimicro.com/k8s/flink-jobs.git"
def git_auth = "gitlab_tmp"

def dockerreg='10.200.82.51:80'


// 创建一个Pod的模板，label为jenkins-slave
podTemplate(label: 'jenkins-slave', cloud: 'kubernetes', containers: [
        containerTemplate(
                name: 'jnlp',
                image: "${dockerreg}/devopstools/jenkins/jnlp-slave:4.13.2-1-jdk11",
                ttyEnabled: true,  args: '${computer.jnlpmac} ${computer.name}'
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