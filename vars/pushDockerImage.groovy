def call() {
    echo "Pushing Docker image"
    withCredentials([usernamePassword(credentialsId: "${DOCKER_CREDS}", usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
        sh "echo ${DOCKER_PASS} | docker login -u ${DOCKER_USER} --password-stdin"
        sh "docker push ${IMAGE_NAME}:${IMAGE_TAG}"
    }
}

