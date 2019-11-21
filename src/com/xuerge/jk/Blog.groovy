package com.xuerge.jk

public class Blog implements Serializable {
    def script
    def work_dir="/root/blog"

    Blog(Object script) {
        this.script = script
    }

    def run() {
        script.node {
            script.echo "${script.credentials('test')}"
            script.sh "ssh -o StrictHostKeyChecking=no root@47.52.174.68 cd /root/blog;restart"
        }
    }
}

