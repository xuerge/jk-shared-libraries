package com.xuerge.jk

import com.xuerge.jk.stage.SCM

public class Main implements Serializable {
    def script
    def env
//    def stages = [
//            Scm
//    ]

    Main(Object script, String env) {
        this.script = script
        this.env = env

    }

    def run() {
        script.node {
            script.cleanWs()
            script.stage('a'){
                script.echo 'a'
            }
            script.stage('b'){
                script.echo 'b'
            }
        }
    }
}

