package com.xuerge.jk

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

    }

    def run() {
        script.node {
            script.cleanWs()
            new SCM(script, result).run()
            script.echo result.commit_id
        }
    }
}

