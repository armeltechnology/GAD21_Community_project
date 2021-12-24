# GAD21_Community_project
Launch in your GCP
Clone this repository by type this in your prompt shell: git clone https://github.com/armeltechnology/GAD21_Community_project.git
Change to the directory that contains the  project_community Healtcare NgRH by type this command : cd project_GAD21_Community_Healthcare-NgRH/
Open script file"initial_configuration_ngrh.sh" to change range of ip address if you want.
Run the executable file by running the following script command: . initial_configuration_ngrh.sh
This script file:
    Creates an App Engine application.
    Creates a Cloud Storage bucket.
    Exports environment variables GCLOUD_PROJECT and GCLOUD_BUCKET.
    Creates ngrhnet and ngrhsubnet for you in us-central.
    Prints out the Project ID.
Create Sql instance in the us-central region and setup the ip in the network you are nearly create
Create user 
Create database
Open file to src/main/resources/application.properties
Change all the information following your credential and your instance-name, database, password.
Ensure your in the path: cd  GAD21_Community_project.git/project_GAD21_Community_Healthcare-NgRH/
Runs this command  mvn clean install.
App Dev - Deploying the Application NgRH into App Engine Flexible Environment: Java run:
    Click on cloud editor and open app.yaml file in GAD21_Community_project.git/project_GAD21_Community_Healthcare-NgRH/app.yaml and then
        Be sure you replace [GCLOUD_BUCKET] with the actual bucket name GCLOUD_PROJECT-ngrh from your project. 
In Cloud Shell, Open Terminal, enter the following command to deploy the NgRH application to App Engine flexible environment.
    google app deploy
    google browse
Injoy your Ngounou_Remote_Hopital application thanks all...
