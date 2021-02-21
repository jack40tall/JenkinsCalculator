pipeline {

    environment {
        registry = "jack40tall/204-calculator-app"
        registryCredential = 'dockerhub'
        dockerImage = ''
    }

    agent any
    tools {
        maven 'apache maven 3.6.3'
        jdk 'JDK 8'
    }
    stages {
        stage ('Clean') {
            steps {
                sh 'mvn clean'
            }
        }

        stage ('Build') {
            steps {
                sh 'mvn compile'
            }
        }

        stage ('Short Tests') {
            steps {
                sh 'mvn -Dtest=CalculatorTest test'
            }
        }

        stage ('Long Tests') {
            steps {
                sh 'mvn -Dtest=CalculatorTestThorough test'
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }

        stage ('Package') {
            steps {
                sh 'mvn package'
                archiveArtifacts artifacts: 'src/**/*.java'
                archiveArtifacts artifacts: 'target/*.jar'
            }
        }

        stage ('Building image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }

        stage ('Deploy image') {
            steps {
                script {
                    docker.withRegistry('', registryCredential) {
                        dockerImage.push()
                    }
                }
            }
        }

        stage ('Deploy image') {
            steps {
                sh "docker rmi $registry:$BUILD_NUMBER"
            }
        }
    }

    post {
    	failure{
           	  mail to: 'youremail@gmail.com',
    	  subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
    	  body: "Something is wrong with ${env.BUILD_URL}"
    	}
    }
}
