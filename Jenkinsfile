node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/refsons/PCF-POC.git'          
      mvnHome = tool 'MAVEN_HOME'
      ansibleHome = tool 'ANSIBLE_HOME'
   }
   stage('Build') {
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -B -Dmaven.test.failure.ignore clean package"
      } else {
         bat(/"${mvnHome}\bin\mvn" -B -Dmaven.test.failure.ignore clean package/)
      }
   }
   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'
   }
   stage('Nexus Deploy'){
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' deploy"
      } else {
         bat(/"${mvnHome}\bin\mvn" deploy/)
      }
   }
   stage("Pivotal Cloud Foundry Deploy"){
       sh "'/usr/local/bin/ansible-playbook' ${WORKSPACE}/ansible/playbook.yml -f 10"
   }
}