build:
	docker build -t jenkins4eval/dark-theme .

#TODO: Add for Pipeline development demo: -v maven-repo:/root/.m2 -v ${MY_PIPELINE_LIBRARY_DIR}:/var/jenkins_home/pipeline-library -v ${MY_OTHER_PIPELINE_LIBS_DIRS}:/var/jenkins_home/pipeline-libs -e DEV_HOST=${CURRENT_HOST}
run:
	docker run --rm  -p 8080:8080 -p 50000:50000 jenkins4eval/dark-theme

run-preview:
	docker run --rm  -e EXPERIMENTAL_UI=true -p 8080:8080 -p 50000:50000 jenkins4eval/dark-theme

devel:
	docker run --rm  -e DEVEL=true -v $(CURDIR)/../theme.css:/usr/share/jenkins/ref/userContent/theme.css -p 8080:8080 -p 50000:50000 jenkins4eval/dark-theme

devel-preview:
	docker run --rm  -e EXPERIMENTAL_UI=true -e DEVEL=true -v $(CURDIR)/../theme.css:/usr/share/jenkins/ref/userContent/theme.css -p 8080:8080 -p 50000:50000 jenkins4eval/dark-theme
