Feature: Contact Us Form
Scenario: After some actions verify that is landing Home Page



Given Navigate to url "AutExcUrl"
Then Verify that home page is visible successfully
Then Click on Contact Us button
Then Verify "GET IN TOUCH" is visible
Then Enter a name to nameBox
Then Type email to mailBox
Then Type a Subject to subjectBox
Then  Type a message to messageBox
Then  Upload file
Then Click Submit button
And Click OK button
And Verify success message 'Success! Your details have been submitted successfully.' is visible
And Click 'Home' button and verify that landed to home page successfully