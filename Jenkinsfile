pipeline {
    agent any

    stages {
        stage('pull-repositorio'){
            steps{
                dir('repositorioBack/Tingeso-BackEnd'){
                    git branch: 'main', credentialsId: 'GIT', url: 'https://github.com/KevinS404/Tingeso-BackEnd.git'
                }
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
        /*  
        stage('Test Junit'){
            steps{
                dir("/var/lib/jenkins/workspace/Mingeso/Evaluacion2") {
                    sh 'chmod +x ./gradlew'
                    sh './gradlew test'
                }
            }
        }*/
        stage('Backend-build'){
            steps{
                dir("/var/lib/jenkins/workspace/Mingeso/Evaluacion2") {
                    sh 'chmod +x ./gradlew'
                    sh "./gradlew build"
                    sh "docker build . -t imagen-backend"
                    sh "docker tag imagen-backend kevins404/imagen-back"
                    script{
                        docker.withRegistry('', 'docker'){
                        sh "docker push kevins404/imagen-back"
                        }
                    }
                }
            }
        }
    }
}


