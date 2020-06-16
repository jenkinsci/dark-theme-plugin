#! /bin/bash -e
# Additional wrapper, which adds custom environment options for the run
# See the Makefile for option examples

extra_java_opts=( )

if [[ "$LIGHT" ]] ; then
  extra_java_opts+=( \
    '-Dio.jenkins.themes.dark.disable=true' \
  )
fi

if [[ "$DEVEL" ]] ; then
  extra_java_opts+=( \
    '-Dio.jenkins.themes.dark.developerMode=true' \
  )
  echo "Will run a static server for themes on port 8081"
  static-file-server --config /usr/share/jenkins/ref/static-file-server.yml &
fi

if [[ "$EXPERIMENTAL_UI" ]] ; then
  extra_java_opts+=( \
    '-Djenkins.ui.refresh=true' \
  )
fi

export JAVA_OPTS="$JAVA_OPTS ${extra_java_opts[@]}"
exec /usr/local/bin/jenkins2.sh "$@"
