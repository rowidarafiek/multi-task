def call() {
    echo 'Updating deployment deployment.yaml'
    sh '''
    sed -i "s|image: .*|image: $IMAGE_NAME:$BUILD_NUMBER|" $DOCKER_REGISTRY_FILE
    '''
    echo 'Deploying to Kubernetes...'
    withCredentials([
        string(credentialsId: 'sa-cred', variable: 'TOKEN'),
        string(credentialsId: 'api-cred', variable: 'APIServer')
        ]) {
    sh '''
    kubectl apply -f deployment.yaml --server \"$APIServer\" --token \"$TOKEN\" --insecure-skip-tls-verify=true
    '''
}
}
