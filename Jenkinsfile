//CODE_CHANGES = getGitChanges()

pipeline {
    agent any

    parameters { //Allows users to input parameters before the build starts
    	//string(name: "VERSION",defaultValue: "", description: "version to deploy on prod")
    	choice(name: "VERSION",choices: ['1.1.0','1.2.0','1.3.0'], description: "")
     	booleanParam(name:"executeTests",defaultValue: true,description: "")
    }
    //provides external configuration to yuor build to change some behavior
    //ex.select which version of application you wanna deploy to stagin server
    //in that case you'll define the selection in parameters section.
    //parameter defined here are global and are available throughout the script.
    //hence its accessed as "params.NAME"
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
    	stage("init") {
    		steps {
    			script {
    				gv = load "script.groovy"
    				 //variable = load "script name"
    			    // this variable holds the groovy script & we'd make it globally 
    			   //available so that we can use it in all the stages by defining
    		      //it outside the pipeline block
    		     //All Environment variables in Jenkinsfile are available in groovy script   
    			}	
    		}	
    	}
    	
    	stage('Build') { 
    	 //"init" stage loads the groovy script from inside the "script" block
    	  /*when {
    			expression {
    				BRANCH_NAME == "dev" || BRANCH_NAME == 'master' && CODE_CHANGES == true	
    			}	
    	 	}*/ 
        	steps {
        		script {
        			gv.buildApp()
        		}
        	
    	    	//echo 'Building the App'
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
            	script {
            		gv.testApp()
            	}    
            }
        }
		
		stage('Deploy') {
			/*input { //input block allows user input before a stage
				message "Select the environment to deploy to" //Parameter 1
				//its a required field & we tell a user what they're gonna input
				ok "Environment Confirmed" //ok is for when user confirms their selection
				//In this case this parameter is available only within this scope.
				//hence accessed as ${NAME} not ${params.NAME}
				parameters {
					choice(name: "ENV1",choices: ['dev','staging','prod'], description: "")
					choice(name: "ENV2",choices: ['dev','staging','prod'], description: "")
					//This provides user to input multiple selections				
				}					 
			}*/
//Another common way of using the input in jenkins file is assign it directlt to 
//Env variable
//if we've 1 choice parameter we can assign the input result directly to a variable.
//if we wanna directly assign the input to a variable,we've to do it inside script section.
//because this part of groovy script.Hence we've to define input inside the script section.
//input iside script will have a different synax. 
            steps {
            	script {
            		env.ENV = input message "Select the environment to deploy to", ok "Environment Confirmed", parameters:[choice(name: "ENV1", choices: ['dev','staging','prod'], description: "")]
 //this is how we define a global variable env.VARNAME = value ,available to other stages 
            		gv.deployApp()
            		echo "Deploying to ${ENV}"
            		//echo "Deploying to ${ENV1}"
            		//echo "Deploying to ${ENV2}"
            	}
               /*	withCredentials([
               		usernamePassword(credentials: 'server-credentials',
               		usernameVariable: USER,passwordVariable: PWD)	
               	]) {
               		sh "some script ${USER} ${PWD}"
               	}*/
              	//echo "Deploying Version ${params.VERSION}" 
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
