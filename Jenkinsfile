pipeline {
    agent any
    tools { 
        maven 'mvn' 
        jdk 'jdk8' 
    }
    stages {
         stage ('Git Checkout') {
              steps {
                  git branch: 'main',  url: 'https://github.com/anjukshrestha/javatestngselenium/'
                }
        }
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }

        stage ('Build') {
            steps {
                 sh '''
                    mvn -f starter/pom.xml test
                ''' 
            }
            post {
                always {
                  testNG()
                }
              }
        }
    }
}