def buildJAR() {
	echo "Building the Applicaion"
	sh "mvn package"
}

def buildImage() {
	echo "Testing the Applicaion"
	withCredentials([usernamePassword(credentialsID:"docker-hub-pvt-repo",
	usernameVariable:"UNAME",passwordVariable:"PWD")]) {
		sh "echo $PWD | docker login -u $UNAME --password-stdin"
		sh "docker build -t rakhel/java-maven-app ."
		sh "docker push rakhel/java-maven-app:4.0"
	}
}

/*def deployApp() {
	echo "Deploying the Applicaion"
	echo "Deploying App Version ${params.VERSION}"
}*/
//VERSION is Pameterized env variable defined in Jenkinsfile & accessed using params.VERSION
//All the environmental variables in the jenkins file are available in the groovy script.
return this
//return keyword 
