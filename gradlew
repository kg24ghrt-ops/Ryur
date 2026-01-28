#!/usr/bin/env sh
# Gradle wrapper script
DIRNAME=$(dirname "$0")
export GRADLE_USER_HOME="$DIRNAME/.gradle"
"$GRADLE_HOME/bin/gradle" "$@"