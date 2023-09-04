Feature: scenarios for User and Accounts admin feature1

  Background: For login to application and selecting Account# for Admin reports
    Given User enters URL and is on login page and entered credentials for Admin setting for Admin reports
    When User is on Home Page for Admin setting for Admin reports
    Then User Clicks on Permissions by drop down to select Customer Account# for Admin reports
    #Then User Clicks on Permissions by drop down to select Customer Account# to default

@LogoutAdminReport
Scenario:Loging out from the application
And Refresh the page if any dialog box is displayed
Then Click on user Icon on Order Entry page
And Click on Logout on Order Entry page