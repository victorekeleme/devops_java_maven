pipeline{

    agent any
    tools {
        maven 'maven-3.8.6'
    }

    stages{
        stage('version increment'){
            steps{
                script{
                    echo 'Increasing version'
                    sh "mvn build-helper:parse-version versions:set\
                    -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} versions:commit"
                }
            }
        }

        stage('test'){
            steps{
                script{
                    sh 'mvn test'
                }
            }
        }

        stage('build'){
            steps{
                script{
                    sh 'mvn clean package'
                }
            }
        }

    }
}
