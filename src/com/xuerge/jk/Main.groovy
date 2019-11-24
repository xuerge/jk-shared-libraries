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
        }
    }
}

