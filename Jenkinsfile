pipeline {
	agent any 
		stages {
			stage ('Git Checkout') {
				steps {
					git branch: 'nader', url: 'https://github.com/takwasassi/DevOps.git'
				}
			}
			stage ('Unit testing') {
				steps {
					sh 'mvn test'
				}
			}
			stage ('Integration testing') {
				steps {
					sh 'mvn verify -DskipUnitTests'
				}
			}
			stage ('Maven Build') {
				steps {
					sh 'mvn clean install'
				}
			}
			stage ('MVN SonarQube') {
				steps {
					script {
						withSonarQubeEnv(credentialsId: 'sonar-api') {
    					sh 'mvn clean package sonar:sonar'
						}
					}
					
				}
			}
		}
}
