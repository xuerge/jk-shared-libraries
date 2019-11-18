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
            new SCM(script).gitCheckout()
            script.ansiColor('xterm') {
                script.timestamps {
                    try {
                        new SCM(script).gitCheckout()
                    } catch (Exception e) {
                        script.stackTrace(e)
                    }
                }
            }
        }
    }
}
