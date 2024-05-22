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
					userName:"UNAME",passWord:"PWD")])
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
