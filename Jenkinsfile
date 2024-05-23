pipeline {
	agent none
	stages {
		stage("Test") {
			steps {
				script {
					echo "Testing the Application"
					echo "Executing Pipeline for $BRANCH_NAME"
				}
			}
		}
		stage("Build") {
			when {
				expression {
					BRANCH_NAME == "master"
					//BRANCH_NAME is jenkins provided Environmental variable
				   //available only in multibranch pipelines which points to
				  //the name of the currently active SCM branch in Jenkins. 
				}
			}
			steps {
				script {
					echo "Building the Application"
				}
			}
		}
		stage("Deploy") {
			when {
				expression {
					BRANCH_NAME == "master"
				}
			}
			steps {
				script {
					echo "Deploying the Application"
				}
			}
		}
	}
}
