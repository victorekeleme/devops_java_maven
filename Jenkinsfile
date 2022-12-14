@Library('jenkins-shared-library')

def gv

pipeline{
    agent any

    tools {
        maven 'Maven'
    }

    stages{
        stage("init"){
            steps{
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("version increment"){
            steps{
                script{
                    sh "mvn build-helper:parse-version versions:set \
                        -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} versions:commit"
                    
                    def matchVersion = readFile('pom.xml') =~ '<version>(.+)</version>'
                    def version = matchVersion[0][1]
                    env.IMAGE_NAME = "$version-$BUILD_NUMBER"
                }
            }
        }
        stage("test"){
            steps{
                script {
                    gv.TestApp()
                }
            }
        }

        stage("build jar"){
            steps{
                script{
                    echo "Building application Jar"
                    sh 'mvn clean package'
                }
            }
        }
        stage("build image"){
            steps {
                script{
                    echo "Building application Image"
                    buildImage "vistein12/java-maven-app:${IMAGE_NAME}"
                    dockerLogin()
                    dockerPush "vistein12/java-maven-app:${IMAGE_NAME}"
                }
            }
        }
        stage("deploy"){            
            steps{
                script{
                    gv.deployApp()
                }
            }
        }
        stage("commit version update"){
            steps{
                script{
                    sshagent(credentials: ['GitHub-SSH']) {
                        sh "git remote set-url origin git@github.com:victorekeleme/devops_java_maven.git"
                        sh 'git add .'
                        sh 'git commit -m "ci: version bump"'
                        sh 'git push origin HEAD:main'
                        
                    }
                }
            }
        }

    }

}
