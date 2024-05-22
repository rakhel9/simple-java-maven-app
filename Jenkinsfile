pipeline {
	agent any
	stages {
		stage("Building JAR") {
			steps {
				script {
					echo "Building the Application"
					sh "mvn package"
				}
			}
		}
		stage("Building Docker Image") {
			steps {
				script {
					echo "Building th docker image"
					withCredentials([usernamePassword(credentialsId:"docker-hub-pvt-repo",
					usernameVariable:"UNAME",passwordVariable:"PASS")]){
						sh "docker build -t rakhel/java-maven-app:3.0 ."
						sh "echo $PASS | docker login -u $UNAME --password-stdin"
						sh "docker push rakhel/java-maven-app:3.0"		
					}
				}
			}
		}
		stage("Deploy") {
			steps {
				script {
					echo "Deploying the Application:"
				}
			}
		}
	}
}
