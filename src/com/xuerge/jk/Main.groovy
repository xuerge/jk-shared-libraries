package com.xuerge.jk

import com.xuerge.jk.stage.Compile
import com.xuerge.jk.stage.SCM

public class Main implements Serializable {
    def script
    def env
    def result
//    def stages = [
//            Scm
//    ]

    Main(Object script, String env) {
        this.script = script
        this.env = env
        this.result = [
            commit_id:''
        ]

    }

    def run() {
        script.node {
            script.cleanWs()
            script.stage('scm'){
                new SCM(script, result).run()
            }
            script.stage('compile'){
                new Compile(script).run()
            }
            script.stage('artifact'){
                def content = 'FROM openjdk:8-jdk-alpine\n' +
                        'ARG JAR_FILE\n' +
                        'COPY ${JAR_FILE} app.jar\n' +
                        'ENTRYPOINT ["java","-jar","/app.jar"]'

                script.writeFile file: "Dockerfile", text: content
                script.sh 'docker build --build-arg JAR_FILE=target/*.jar -t yipianlarou/devops-demo-springboot .'
                script.sh 'docker push yipianlarou/devops-demo-springboot'
            }
        }
    }
}

