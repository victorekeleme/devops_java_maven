@Library('jenkins-shared-library')

def gv

pipeline {
    agent any

    tools {
        maven "Maven"
        }

    stages {
        stage("init"){
            steps{
                script {
                    echo "Initializing"
                    // gv = load "script.groovy"
                }
            }
        }

        stage("version increment"){
            steps{
                script {
                    echo "Increasing version"
                    sh "mvn build-helper:parse-version versions:set\
                    -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} versions:commit"
                    
                    def regex = readFile('pom.xml') =~ '<version>(.+)</version>'
                    def version = regex[0][1]
                    env.IMAGE_NAME = "$version"
                }
            }
        }        
        // stage("test"){
        //     steps{
        //         script{
        //             gv.TestApp()
        //         }
        //     }
        // }
        // stage("build jar"){
        //     steps{
        //         script{
        //             buildJar()

        //         }
        //     }
        // }
        stage("build docker image/push"){
            steps {
                script {
                    // login()
                    buildDockerImage "vistein12/java-maven-app:${IMAGE_NAME}"
                    // pushDockerImage "java-maven-app:${VERSION}"
                }
            }
        }

        // stage("push to AWS"){
        //     steps{
        //         script{
        //           pushAWS "java-maven-app:${VERSION}"            
        //         }
        //     }
        // }

        // stage("push to Nexus"){
        //     steps{
        //         script{
        //             pushNexus "java-maven-app:${VERSION}"                 
        //         }
        //     }
        // }

        // stage("commit version"){
        //     steps{
        //         script{
        //             sshagent(credentials: ['github-ssh-credentials']) {
        //                 sh "git branch"
        //                 sh "git status"
                        
        //                 sh "git remote set-url origin git@github.com:victorekeleme/devops_java_maven.git"
        //                 sh "git add ."
        //                 sh 'git commit -m "ci: version bump"'
        //                 sh "git push origin HEAD:jenkins/maven"
        //             }
                                   
        //         }
        //     }
        // }
        
    }
}