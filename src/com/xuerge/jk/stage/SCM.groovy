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
        script.echo scmVars.GIT_COMMIT
        //result.commit_id = scmVars.GIT_COMMIT.trim().take(8)
//        result.commit_message = commitMessage()
//        message={GIT_BRANCH=origin/master, GIT_COMMIT=40ce461b6fbfb4e218af1daaacbba6cbe417f27f,
//                GIT_PREVIOUS_COMMIT=40ce461b6fbfb4e218af1daaacbba6cbe417f27f,
//                        GIT_PREVIOUS_SUCCESSFUL_COMMIT=40ce461b6fbfb4e218af1daaacbba6cbe417f27f,
//                                GIT_URL=https://github.com/xuerge/demo}
    }


    Map gitCheckout() {
        def scmVars = script.checkout(
                [$class: 'GitSCM',
                 branches: [[name: '*/master']],
                 doGenerateSubmoduleConfigurations: false,
                 extensions: [],
                 submoduleCfg: [],
                 userRemoteConfigs: [[url: 'https://github.com/xuerge/demo']]])

        return scmVars
    }

    def commitMessage() {
        def commitMessage = script.sh returnStdout: true,script: 'git log --format=%B -n 1'
        commitMessage.trim()
    }
}