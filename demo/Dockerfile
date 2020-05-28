FROM onenashev/demo-jenkins-config-as-code

# Override the Jenkins core by the incrementals or SNAPSHOT version
# ARG JENKINS_INCREMENTALS_VERSION=2.239-rc29973.611f6ad476ff
# ENV JENKINS_URL https://repo.jenkins-ci.org/incrementals/org/jenkins-ci/main/jenkins-war/${JENKINS_INCREMENTALS_VERSION}/jenkins-war-${JENKINS_INCREMENTALS_VERSION}.war
ENV JENKINS_URL https://repo.jenkins-ci.org/snapshots/org/jenkins-ci/main/jenkins-war/2.239-SNAPSHOT/jenkins-war-2.239-20200528.073947-2.war

USER root
RUN wget $JENKINS_URL -O /usr/share/jenkins/jenkins.war
USER jenkins

# Install extra plugins
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

# Inject configuration
COPY enable-theme.groovy /usr/share/jenkins/ref/init.groovy.d/enable-theme.groovy
RUN mkdir /usr/share/jenkins/ref/userContent

COPY jenkins3.sh /usr/local/bin/jenkins3.sh
ENTRYPOINT ["tini", "--", "/usr/local/bin/jenkins3.sh"]
