pipeline {
	stages {
		stage("Build") {
			steps {
				script {
					echo "Building the Application"
					sh "mvn package"
				}
			}
		}
		stage("Test") {
			steps {
				script {
					echo "Testing the Application"
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
