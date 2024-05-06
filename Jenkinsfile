// Uses Declarative syntax to run commands inside a container.
pipeline {
    agent {
        kubernetes {
            yaml '''
apiVersion: v1
kind: Pod
spec:
  containers:
  - name: shell
    image: 3scale/ajv
    command:
    - sleep
    args:
    - infinity
'''
            defaultContainer 'shell'
        }
    }
    stages {
        stage('Main') {
            steps {
                sh "validate -s ci-json-scheme.json -d ci.yaml"
                script {
                   def configYaml = readYaml file: 'ci.yaml'
                   def kanikoKeys = configYaml.kaniko.keySet()
                   // Print the keys
                   println "PRINT Kaniko KEYS 1"
                   kanikoKeys.each { key ->
                          println "#############"
                          println(key)
                          println configYaml.kaniko."$key"
                          //configYaml.kaniko."$key".toString()
                          if ("$key".startsWith('registry_')){
                                 println "key startsWith $key"
                          }else{
                                  println "key doesnt startsWith registry"
                           }
                          println "#############"
                    }
                }
                sh 'hostname'
            }
        }
    }
}
