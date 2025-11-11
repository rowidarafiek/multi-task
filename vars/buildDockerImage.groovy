def call() {
    echo "Building Docker image"
    sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
}

