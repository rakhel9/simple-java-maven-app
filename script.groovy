def test() {
    echo 'Testing the app..'
    echo "Executing Pipeline for $BRANCH_NAME"
    sh 'mvn test'
}

def buildJar() {
    echo 'Building the app..'
    sh 'mvn package'
}

def buildImage() {
    echo 'Building the app..' 
    withCredentials([usernamePassword(credentialsId: 'dockerhub-credential',passwordVariable: 'PASS',usernameVariable: 'USER')]) {
        sh 'docker build -t rakhel/jenkins-build:jma-3.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push rakhel/jenkins-build:jma-2.0'    
    }
}

def deployImage() {
    echo 'deploying the application.'
}

return this
