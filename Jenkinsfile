pipeline {
	agent any 
		stages {
			stage ('Git Checkout') {
				steps {
					git branch: 'nader', 
					url: 'https://github.com/takwasassi/DevOps.git'
				}
			}
			stage ('Maven Clean') {
				steps {
					sh 'mvn clean'
				}
			}
			stage ('Maven Compile') {
				steps {
					sh 'mvn compile'
				}
			}
			stage ('Junit test') {
				steps {
					sh 'mvn test'
				}
			}
			stage ('SonarQube') {
				steps {
					script {
						withSonarQubeEnv(credentialsId: 'sonar-api') {
    					sh 'mvn clean package sonar:sonar'
						}
					}
				}
			}
			stage ('Nexus Repo') {
				steps {
					sh 'mvn deploy Dskiptests'
				}
			}
			stage ('Image Build') {
				steps {
					script {
						docker image = docker.build registry + "$BUILD_NUMBER"
					}
				}
			}
			stage ('Login Dockerhub') {
				steps {
					sh 'echo £DOCKERHUB_CREDENTIALS_PSW | docker login -u naderbenmrad -p nbmnbmnbm'
				}
			}
			stage ('Image Deploy') {
				steps {
					script {
						docker.withRegistry(''. registryCredential) {
							docker Image.push()
						}
					}
				}
			}
			stage ('Docker-compose Down') {
				steps {
					sh 'docker-compose down --rmi all --remove-orphans'
				}
			}
			stage ('Docker-compose up') {
				steps {
					sh 'docker-compose up --force-recreate -d'
				}
			}
		}
}
