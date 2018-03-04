#!/usr/bin/env sh

set -eu

if [ -n "${SWAGGER_CMD+1}" ]
then
    echo "Using Swagger command \`${SWAGGER_CMD}\`."
else
    if ! which swagger-codegen
    then
        echo "swagger-codegen is either not installed on this system or is"\
            "unavailable through the \$PATH."
        while true; do
            printf "Install it from Homebrew now? [y/N] "
            read -r  yn
            case "$yn" in
                [Yy]* ) break;;
                [Nn]* ) exit;;
                '' ) exit;;
            esac
        done

        echo "Updating Homebrew and then installing swagger-codegen"
        brew update
        brew install swagger-codegen
    fi

    SWAGGER_CMD="swagger-codegen"
fi

target_language="${1:-}"

generate_for_language() {
    $SWAGGER_CMD generate \
        --input-spec "./big-idea-api.yml" \
        --lang "$1" \
        --config "./configs/$1-config.json" \
        --output "./swagger-out/$1"
}

if [ -n "$target_language" ]
then
    generate_for_language "$target_language"
else
    configs=$(ls configs)
    config_suffix="-config.json"
    for config in $configs
    do
        generate_for_language ${config%$config_suffix}
    done
fi

