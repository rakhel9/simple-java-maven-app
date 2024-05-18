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

return this
