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
                sh "ajv -s ci-json-scheme.json -d ci.yaml"
                //Move to shared Lib
                script {
                   def configYaml = readYaml file: 'ci.yaml'
                   def kanikoKeys = configYaml.kaniko.keySet()
                   // Print the keys
                   println "Kaniko keys"
                   kanikoKeys.each { key ->
                          println "#############"
                          println(key)
                          //configYaml.kaniko."$key".toString()
                          if ("$key".startsWith('registry_')){
                                 println "key startsWith $key"
                                 println configYaml.kaniko."$key"
                          }else{
                                  println "key doesn`t startsWith registry"
                           }
                          println "#############"
                    }
                }
                sh 'hostname'
            }
        }
    }
}
