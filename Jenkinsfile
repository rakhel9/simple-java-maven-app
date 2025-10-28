#!/usr/bin/env groovy

@Library('jenkins-shared-library')
def gv

pipeline {
    agent any

    tools {
        maven 'maven3.9'
    }
    stages {
        stage('init'){
            steps {
                script{
                    gv = load 'script.groovy'
                }
            }
        }
        stage('test') {
            steps {
                script {
                    test()
                }
            }
        }
        stage('build jar') {
            when {
                expression {
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                script {
                    buildJar()
                }
            }
        }
        stage('build image') {
            when {
                expression {
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                script {
                    buildImage()
                }
            }
        }
        stage('deploy') {
            when {
                expression {
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                script {
                    gv.deployImage()
                }
            }
        }  
    }
}
