stage('Update Deployment YAML') {
    steps {
        script {
            echo "Updating deployment ${DEPLOYMENT_FILE}"
            sh "sed -i 's|image:.*|image: ${IMAGE_NAME}:${IMAGE_TAG}|' ${DEPLOYMENT_FILE}"
            
            // Verify the update
            echo "Verifying update..."
            sh "cat ${DEPLOYMENT_FILE} | grep 'image:'"
        }
    }
}
