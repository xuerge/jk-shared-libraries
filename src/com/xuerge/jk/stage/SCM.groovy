package com.xuerge.jk.stage

class SCM {
    def script
    def result

    SCM(script,result) {
        this.script = script
        this.result = result
    }

    public void run() {
        def scmVars = gitCheckout()
        result.commit_id = scmVars.GIT_COMMIT.trim().take(8)
        result.commit_message = commitMessage()
    }


    Map gitCheckout() {
        def scmVars = script.checkout(
                [$class: 'GitSCM',
                 branches: [[name: '*/master']],
                 doGenerateSubmoduleConfigurations: false,
                 extensions: [], submoduleCfg: [],
                 userRemoteConfigs: [[url: 'https://github.com/xuerge/demo']]])
        return scmVars
    }

    def commitMessage() {
        def commitMessage = script.sh returnStdout: true,script: 'git log --format=%B -n 1'
        commitMessage.trim()
    }
}