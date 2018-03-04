#!/usr/bin/env sh

swagger-codegen generate \
    -i "big-idea-api.yml" \
    -l java \
    -o "./java-sdk"