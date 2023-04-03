import groovy.json.JsonSlurperClassic
import hudson.Util;
def jsonParse(def json) {
    new groovy.json.JsonSlurperClassic().parseText(json)
}
def current_stage
def build_duration_msg = "\n *Detail by Stage* \n"

pipeline {
    agent any
    stages {
       stage("Paso 1: Compilar"){
            steps {
                script {
                    start = System.currentTimeMillis()
                    current_stage =env.STAGE_NAME 
                    sh "echo 'Stage 1: Compiling code!'"
                    sh "chmod 755 *"
                    sh "./mvnw clean compile -e"
                    end = System.currentTimeMillis()
                    build_duration_msg = build_duration_msg +  "*" + current_stage + "*" + " : "  + Util.getTimeSpanString(end - start) +"\n"
                }
            }
        }
        stage("Paso 2: Testear"){
            steps {
                script {
                    start = System.currentTimeMillis()
                    current_stage =env.STAGE_NAME 
                    sh "echo 'Stage 2: Testing code!'"                    
                    sh "./mvnw clean test -e"
                    end = System.currentTimeMillis()
                    build_duration_msg = build_duration_msg + "*" + current_stage + "*" + " : "  + Util.getTimeSpanString(end - start) +"\n"
                }
            }
        }
        stage("Paso 3: Validacion Sonarqube!"){
            when {
               anyOf {
                    branch 'main';
                    branch 'PR-*'
                  }
            }
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh "echo 'Calling sonar Service !!'"
                    // Run Maven on a Unix agent to execute Sonar.
                    sh 'sh mvnw clean verify sonar:sonar'
                }
            }
        }
        stage("Paso 4: Test en Sonarqube") {
        when {
           anyOf {
                branch 'main';
                branch 'PR-*'
              }
            }
          steps {
            timeout(time: 1, unit: 'MINUTES') { // If analysis takes longer than indicated time, then build will be aborted
                waitForQualityGate abortPipeline: true
                script{
                    start = System.currentTimeMillis()
                    current_stage =env.STAGE_NAME 
                    def qg = waitForQualityGate() // Waiting for analysis to be completed
                    if(qg.status != 'OK'){ // If quality gate was not met, then present error
                        error "Pipeline aborted due to quality gate failure: ${qg.status}"
                    }
                    end = System.currentTimeMillis()
                    build_duration_msg = build_duration_msg +  "*" + current_stage + "*" + " : "  + Util.getTimeSpanString(end - start) +"\n"
                }
            }
          }
        }
        stage("Paso 5: Ejecutar proyecto"){
            steps {
                script {
                    start = System.currentTimeMillis()
                    current_stage =env.STAGE_NAME 
                    sh "echo 'Stage 4: Running .Jar file!'"
                    sh "nohup bash ./mvnw spring-boot:run  & >/dev/null"
                    end = System.currentTimeMillis()
                    build_duration_msg = build_duration_msg +  "*" + current_stage + "*" + " : "  + Util.getTimeSpanString(end - start) +"\n"
                }
            }
        }
        stage('Paso 6: Testear ejecución') {
            steps {
                script {
                    start = System.currentTimeMillis()
                    current_stage =env.STAGE_NAME 
                    sh "echo 'Stage 4:Testing artifact downloaded from Nexus'"                    
                    sh "sleep 20 && curl -X GET 'http://localhost:8081'"
                    end = System.currentTimeMillis()
                    build_duration_msg = build_duration_msg +  "*" + current_stage + "*" + " : "  + Util.getTimeSpanString(end - start) +"\n"
                }
            }
        }
        stage("Paso 6: Detener ejecución del proyecto"){
            steps {
                script {
                    start = System.currentTimeMillis()
                    current_stage =env.STAGE_NAME 
                    sh "sleep 5"
                    sh '''kill -9 $(pidof java | awk '{print $1}')'''
                    end = System.currentTimeMillis()
                    build_duration_msg = build_duration_msg +  "*" + current_stage + "*" + " : "  + Util.getTimeSpanString(end - start) +"\n"
                }
            }
        }
        stage("Paso 7: Subir a nexus"){
            when{            
                anyOf {
                    branch 'main';
                }
            }
            steps {
                script {
                    start = System.currentTimeMillis()
                    sh "echo 'Subir a nexus'" 
                    end = System.currentTimeMillis()
                    build_duration_msg = build_duration_msg +  "*" + current_stage + "*" + " : "  + Util.getTimeSpanString(end - start) +"\n"
                }
            }
        }
    }
    post{
        always{
            script{
                build_duration_msg = build_duration_msg + "\n *Total build time:* " +  "${currentBuild.durationString}".replaceAll(' and counting', "")
            }            
        }
        success{
            script{
                    current_stage = "Post Build"
                    slackSend color: 'good', message: "[${env.JOB_NAME}][Rama : ${env.BRANCH_NAME}] [Stage :${current_stage}][Resultado: ${currentBuild.result}](<${env.BUILD_URL}|Detalle>)${build_duration_msg}", tokenCredentialId: 'auter-token-id'
                }
            }
        failure{
            slackSend color: 'danger', message: "[${env.JOB_NAME}][Rama : ${env.BRANCH_NAME}] [Stage :${current_stage}][Resultado:${currentBuild.result}](<${env.BUILD_URL}|Detalle>)${build_duration_msg}", tokenCredentialId: 'auter-token-id'
        }
    }
}
