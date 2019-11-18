package com.xuerge.jk

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
        script.echo "hello"
    }
}

