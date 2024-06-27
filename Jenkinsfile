podTemplate(label: 'jenkins-u-app', cloud: 'k8s', containers: [
  containerTemplate(
  name: 'jnlp',
  image: 'wanminny/jnlp:v4'
           ),
  containerTemplate(
  name: 'docker',
  image: 'docker:stable',
  ttyEnabled: true,
  command: 'cat'
             ),
],
volumes: [
  hostPathVolume(mountPath: '/usr/bin/docker', hostPath: '/usr/bin/docker'),
  hostPathVolume(mountPath: '/var/run/docker.sock', hostPath: '/var/run/docker.sock'),
  nfsVolume(mountPath: '/usr/local/apache-maven/repo', serverAddress: '10.200.30.8', serverPath: '/data/nfs/maven'),
])
{
  node('jenkins-slave') {
      stage('Test Docker') {
          container('docker') {
          echo "测试 Kubernetes 动态生成 jenkins slave"
          echo "==============docker in docker==========="
          sh 'docker info'
           }
    }
  }
}
