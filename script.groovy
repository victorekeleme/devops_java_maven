def versionIncrement(){
    echo 'Increasing version'
    sh "mvn build-helper:parse-version versions:set\
    -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} versions:commit"
}

def testJar(){
    sh 'mvn test'
}

return this