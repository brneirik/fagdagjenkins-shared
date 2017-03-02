#!groovy 

//Somewhat based on https://github.com/bitwiseman/jenkins-pipeline-shared/blob/master/vars/sendNotifications.groovy

def call(String buildStatus = 'STARTED') {
	// build status of null means successful
	 buildStatus =  buildStatus ?: 'SUCCESSFUL'

	def color =     color = '#FF0000'

 	if (buildStatus == 'SUCCESSFUL') {
    	color = '#00FF00'
  	} else {
    	color = '#FF0000'
 	 }
  	slackSend(color: color, message: "Job ${env.JOB_NAME} ${buildStatus}")
}
