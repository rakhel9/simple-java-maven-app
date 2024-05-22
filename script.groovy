def buildApp() {
	echo "Building the Applicaion"
}

def testApp() {
	echo "Testing the Applicaion"
}

def deployApp() {
	echo "Deploying the Applicaion"
	echo "Deploying App Version ${params.VERSION}"
}
//VERSION is Pameterized env variable defined in Jenkinsfile & accessed using params.VERSION
//All the environmental variables in the jenkins file are available in the groovy script.
return this
//return keyword 
