pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
        stage('SonarQube analysis') {
    		steps {
				dir("/var/lib/jenkins/workspace/Mingeso/Evaluacion2") {
					withSonarQubeEnv('sonarqube') { 
						sh 'chmod +x ./gradlew'
						sh './gradlew sonarqube'
    				}
				}
			}
  		}
        stage('Test Junit'){
            steps{
                dir("/var/lib/jenkins/workspace/Mingeso/Evaluacion2") {
                    sh 'chmod +x ./gradlew'
                    sh './gradlew test'
                }
            }
        }
        stage('Backend-build'){
            steps{
                dir("/var/lib/jenkins/workspace/Mingeso/Evaluacion2") {
                    sh 'chmod +x ./gradlew'
                    sh "./gradlew build"
                    sh "docker build . -t imagen-backend"
                    
                }
            }
        }
    }
}


