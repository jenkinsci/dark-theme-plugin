DEMO_IMAGE=jenkins4eval/dark-theme
DEVEL_VOLUMES=-v $(CURDIR)/../theme.css:/usr/share/jenkins/ref/userContent/theme.css
# TODO: Override by your local path if needed
LOCAL_THEME=../../../core/jenkins/war/src/main/webapp/css
LOGIN_THEME_VOLUME=-v $(CURDIR)/${LOCAL_THEME}:/usr/share/jenkins/ref/userContent/login-theme

build:
	docker build -t ${DEMO_IMAGE} .

#TODO: Add for Pipeline development demo: -v maven-repo:/root/.m2 -v ${MY_PIPELINE_LIBRARY_DIR}:/var/jenkins_home/pipeline-library -v ${MY_OTHER_PIPELINE_LIBS_DIRS}:/var/jenkins_home/pipeline-libs -e DEV_HOST=${CURRENT_HOST}
run:
	docker run --rm  -p 8080:8080 -p 50000:50000 ${DEMO_IMAGE}

run-preview:
	docker run --rm  -e EXPERIMENTAL_UI=true -p 8080:8080 -p 50000:50000 ${DEMO_IMAGE}

run-light:
	docker run --rm  -e LIGHT=true -p 8080:8080 -p 50000:50000 ${DEMO_IMAGE}

run-light-preview:
	docker run --rm  -e LIGHT=true -p 8080:8080 -p 50000:50000 ${DEMO_IMAGE}

devel:
	docker run --rm  -e DEVEL=true -p 8080:8080 -p 8081:8081 -p 50000:50000 ${DEVEL_VOLUMES} ${DEMO_IMAGE}

devel-login:
	docker run --rm  -e DEVEL=true -e DARK_LOGIN=true -p 8080:8080 -p 8081:8081 -p 50000:50000 ${DEVEL_VOLUMES} ${LOGIN_THEME_VOLUME} ${DEMO_IMAGE}

devel-preview:
	docker run --rm  -e EXPERIMENTAL_UI=true -e DEVEL=true -p 8080:8080 -p 8081:8081 -p 50000:50000 ${DEVEL_VOLUMES} ${DEMO_IMAGE}

devel-light:
	docker run --rm  -e DEVEL=true  -p 8080:8080 -p 8081:8081 -p 50000:50000 ${DEVEL_VOLUMES} ${DEMO_IMAGE}

devel-light-preview:
	docker run --rm  -e EXPERIMENTAL_UI=true -e DEVEL=true -p 8080:8080 -p 8081:8081 -p 50000:50000 ${DEVEL_VOLUMES} ${DEMO_IMAGE}
