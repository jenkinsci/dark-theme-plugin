#! /bin/bash -e
# Additional wrapper, which adds custom environment options for the run

extra_java_opts=( )

if [[ "$DEVEL" ]] ; then
  extra_java_opts+=( \
    '-Dio.jenkins.themes.dark.developerMode=true' \
  )
fi

if [[ "$EXPERIMENTAL_UI" ]] ; then
  extra_java_opts+=( \
    '-Djenkins.ui.refresh=true' \
  )
fi

export JAVA_OPTS="$JAVA_OPTS ${extra_java_opts[@]}"
exec /usr/local/bin/jenkins2.sh "$@"
