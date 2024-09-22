# patient-monitoring-service
This repo is created for the virtual cloud computing project which aims to eliminate the need of monitors and reduce the cost of hardware by directly visualizing vitals via a web application.
This repo contains the code for generating mock data for UI. 
The code contails app-controller files where the logic for defining whether a particular vital value received is within the normal range or not. If not, the dialogue box is set to show a light red colour else, green. Along with this the code also ensures the ecg waveform is plotted and rendered when an API call is made from the UI to get the data every 5 seconds and vitals data every 8 seconds. 
