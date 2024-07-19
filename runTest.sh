#! /bin/bash

docker run  -v $(PWD):/data 3scale/ajv validate -s ci-json-scheme.json -d ci.yaml