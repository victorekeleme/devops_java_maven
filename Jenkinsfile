def gv

pipeline{
    agent any

    tools {
        maven "Maven"
        }
    stages{
        stage("init"){
            steps{
                script{
                    echo "Initializing"
                    gv = load "script.groovy"
                }
            }
        }
        // stage("version increment"){
        //     steps{
        //         script{
        //             echo "Increasing version"
        //             sh "mvn build-helper:parse-version versions:set\
        //             -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} versions:commit"
        //             def regex = readFile('pom.xml') =~ '<version>(.+)</version>'
        //             def version = regex[0][1]
        //             env.IMAGE_NAME = "$version"
        //         }
        //     }
        // }        
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
        //             gv.buildJar()

        //         }
        //     }
        // }
        // stage("build docker image/push"){
        //     steps{
        //         script{
        //             gv.buildImage "java-maven-app:${IMAGE_NAME}"                 
        //         }
        //     }
        // }

        // stage("push to AWS"){
        //     steps{
        //         script{
        //             gv.pushAWS "java-maven-app:${IMAGE_NAME}"                 
        //         }
        //     }
        // }

        // stage("push to Nexus"){
        //     steps{
        //         script{
        //             gv.pushNexus "java-maven-app:${IMAGE_NAME}"                 
        //         }
        //     }
        // }

        stage("commit version"){
            steps{
                script{
                    sshagent(credentials: ['github-ssh-credentials']) {
                        sh "git config --global user.name 'jenkins'"
                        sh "git config --global user.email 'jenkins@example.com'"
                        sh "git config --list"
                        sh "git branch"
                        sh "git status"
                    }
                                   
                }
            }
        }
        
    }
}