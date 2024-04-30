@Grab(group='org.yaml', module='snakeyaml', version='1.29')

import org.yaml.snakeyaml.Yaml
import java.nio.file.Files
import java.nio.file.Paths

def myMap = [:]

// Read YAML file
def yamlText = new String(Files.readAllBytes(Paths.get("./ci.yaml")))

// Parse YAML
def configYaml = new Yaml().load(yamlText)

configYaml.each { key, value ->
       // Expose each key-value pair as properties
       this."$key" = value
}
println "TEST KANIKO"
println config.kaniko.dockerHost

println configYaml.ciTemplate

println configYaml.qs.sonar.enabled
println configYaml.qs.sonar.host
println configYaml.qs.sonar.credentialID

println configYaml.qs.checkmarx.enabled
println configYaml.qs.checkmarx.host
println configYaml.qs.checkmarx.credentialID

println configYaml.build.steps.get(0)
println configYaml.build.steps.get(1)

println "iterate build environment"
configYaml.build.environment.each { env ->
       println env
}
println "iterate build steps"
configYaml.build.steps.collect { step ->
       println step
}

println configYaml.kaniko.dockerHost
println configYaml.kaniko.credentialID

println configYaml.deploy.type
println configYaml.deploy.cluster
println configYaml.deploy.image




//println(myMap)
// Access properties

//println("Age: ${yaml.age}")

/*
if ('appName' in this) {
    println "Is a PTC instance ${appName}"
}else{
    def appName="sample-app-helloworld"
    println "Is a Markerfile instance ${appName}"
}
if ('k8AgentPodyaml' in this) {
    println "Is a PTC instance ${k8AgentPodyaml}"
}else{
    def k8AgentPodyaml="podTemplate-curl.yaml"
    println "Is a Markerfile instance ${k8AgentPodyaml}"
}
*/

