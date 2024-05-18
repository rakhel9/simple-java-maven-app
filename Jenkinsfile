CODE_CHANGES = getGitChanges()

pipeline {
    agent any

    parameters {
    	//string(name: "VERSION",defaultValue: "", description: "version to deploy on prod")
    	choice(name: "VERSION",choices: ['1.1.0','1.2.0','1.3.0'], description: "")
     	booleanParam(name:"executeTests",defaultValue: true,description: "")
    }
    //provides external configuration to yuor build to change some behavior
    //ex.select which version of application you wanna deploy to stagin server
    //in that case you'll define the selection in parameters section.
    //Types of Parameter
	//1.string(name,defaultValue,description)
	//2.choice(name,choices,description)
	//3.booleanParam(name,defaultValue,description)
	/*
    tools{ //Access Build tools for your projects.
		maven "Maven" //(tool "Name of the tool") defined in global tool configuration
		//gradle    //this will make the build tool available in all the stages			
		//jdk    	//only 3 build tools supports this methord of assignment.
    }

    environment {
    	NEW_VERSION='1.3.0'
    	SERVER_CRED=credentials('server-credentials')//uses ID to bind the credentials
    	//Not best practice to declare credentials as global variable.better to use 
    	//inside wrappper syntax "syntax([objectName(.....)]){script..}" directly 
    	//on that stage itself.
    }
	*/
    stages {
    	stage('Build') {
    	  /*when {
    			expression {
    				BRANCH_NAME == "dev" || BRANCH_NAME == 'master' && CODE_CHANGES == true	
    			}	
    	 	}*/ 
        	steps {
    	    	echo 'Building the App'
    	        // sh "mvn install"
    	        //echo "building version ${NEW_VERSION}" //use ""
    	    }
    	}
        stage('Test') {
        	when {
        		expression {
        			params.executeTests == true
        			//execute this stage only when 
        			//executeTests parameters is set to true.		
        		}
        	}
            steps {
                echo 'Testing the APP'
            }
        }
		
		stage('Deploy') {
            steps {
                echo 'Deploying the App'
               /*	withCredentials([
               		usernamePassword(credentials: 'server-credentials',usernameVariable: USER,passwordVariable: PWD)	
               	]) {
               		sh "some script ${USER} ${PWD}"
               	}*/
               	echo "Deploying Version ${params.VERSION}" 
            }
	    }	
    }
    /*post { //Build status or build status change
    	always {
    		echo "send an email about build condition"
    	}
    	success {
    		echo "build is success"
    	}
		failure {
			echo "build failed"
		}
    }*/
}
