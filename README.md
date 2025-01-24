# Sample hello World
* https://www.w3schools.io/file/yaml-arrays/ 
* https://www.jenkins.io/blog/2018/04/25/configuring-jenkins-pipeline-with-yaml-file/
* https://www.baeldung.com/java-snake-yaml

# Json Scheme validator
* https://json-schema.org/implementations#validators-command-line
* https://hub.docker.com/r/miy4/json-schema-validator 
* https://www.npmjs.com/package/pajv
* https://github.com/python-jsonschema/jsonschema 

## ajv-cli
* https://hub.docker.com/u/3scale
* https://ajv.js.org/packages/ajv-cli.html
* https://github.com/3scale-archive/docker-ajv
* https://www.npmjs.com/package/ajv-cli

# Test

```
docker run  -v $(PWD):/data 3scale/ajv validate -s ci-json-scheme.json -d ci.yaml
```

Update the ci.yaml and break for example the IPAddress or hostName pattern to see the schema error