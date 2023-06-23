Feature: Validate Admin Configuration in Admin Notification tab

  Background: For login to application
    Given User enters correct URL and opened login page

  @CRM_Tickets_Validate_Status_Dropdown_Under_NotificationTab_According_To_Admin_Setting
  Scenario: TC027 Verify Admin Status Configuration Matches Admin notification Status Dropdown Values
    Given User logged in as an admin
    When  User click on the Notification tab under general settings menu
    And   User click on the Add Notification button and under that click on status dropdown
    Then  User should see the following Status values in add notification dropdown:
      | New       |
      | Reviewed  |
      | Working   |
      | Complete  |

    And   click on cancel button from Add notification pop up

    When    User click on the Configuration tab and click on status option
    Then    User should see the following Status values:
      | New       |
      | Reviewed  |
      | Working   |
      | Complete  |

    Then    The displayed status values should match the Admin add notification pop up dropdown values


  @CRM_Tickets_Validate_Source_Dropdown_Under_NotificationTab_According_To_Admin_Setting
  Scenario: TC028 Verify Admin Source Configuration Matches Admin notification Source Dropdown Values
    When  User click on the Notification tab under general settings menu
    And   User click on the Add Notification button and under that click on Source dropdown
    Then  User should see the following Source values in add notification dropdown:
      | Not Specified   |
      | N/A             |
      | E-mail          |
      | Web             |
      | Phone           |
    And   click on cancel button from Add notification pop up

    When    User click on the Configuration tab and click on Source option
    Then    User should see the following Source values:
      | Not Specified   |
      | N/A             |
      | E-mail          |
      | Web             |
      | Phone           |

    Then    The displayed Source values should match the Admin add notification pop up dropdown values


  @CRM_Tickets_Validate_Priority_Dropdown_Under_NotificationTab_According_To_Admin_Setting
  Scenario: TC029 Verify Admin Priority Configuration Matches Admin notification Priority Dropdown Values
    When  User click on the Notification tab under general settings menu
    And   User click on the Add Notification button and under that click on Priority dropdown
    Then  User should see the following Priority values in add notification dropdown:
      | Not Specified   |
      | Low             |
      | Medium          |
      | High            |
      | Critical        |
    And   click on cancel button from Add notification pop up

    When    User click on the Configuration tab and click on Priority option
    Then    User should see the following priority values:
      | Not Specified   |
      | Low             |
      | Medium          |
      | High            |
      | Critical        |

    Then    The displayed Priority values should match the Admin add notification pop up dropdown values

  @CRM_Tickets_Validate_Type_Dropdown_Under_NotificationTab_According_To_Admin_Setting
  Scenario: TC030 Verify Admin Type Configuration Matches Admin notification Type Dropdown Values
    When  User click on the Notification tab under general settings menu
    And   User click on the Add Notification button and under that click on Type dropdown
    Then  User should see the following Type values in add notification dropdown:
      | Not Specified         |
      | Order management      |
      | Warehouse management  |
      | Broken product        |
    And   click on cancel button from Add notification pop up

    When    User click on the Configuration tab and click on Type option
    Then    User should see the following type values:
      | Not Specified         |
      | Order management      |
      | Warehouse management  |
      | Broken product        |

    Then    The displayed Type values should match the Admin add notification pop up dropdown values


  @CRM_Tickets_Validate_Application_Dropdown_Under_NotificationTab_According_To_Admin_Setting
  Scenario: TC031 Verify Admin Application Configuration Matches Admin notification Application Dropdown Values
    When  User click on the Notification tab under general settings menu
    And   User click on the Add Notification button and under that click on Application dropdown
    Then  User should see the following Application values in add notification dropdown:
      | Not Specified  |
      | OMSi           |
      | ERPi           |
      | WMSi           |
      | RE             |
      | Other          |
    And   click on cancel button from Add notification pop up

    When    User click on the Configuration tab and click on Module option
    Then    User should see the following module values:
      | Not Specified  |
      | OMSi           |
      | ERPi           |
      | WMSi           |
      | RE             |
      | Other          |

    Then    The displayed Application values should match the Admin add notification pop up dropdown values


  @CRM_Tickets_Validate_Reason_Dropdown_Under_NotificationTab_According_To_Admin_Setting
  Scenario: TC032 Verify Admin Reason Configuration Matches Admin notification Reason Dropdown Values
    When  User click on the Notification tab under general settings menu
    And   User click on the Add Notification button and under that click on Reason dropdown
    Then  User should see the following Reason values in add notification dropdown:
      | Not Specified                  |
      | Bug                            |
      | Technical assistance required  |
      | Complaint                      |
      | Problem                        |
    And   click on cancel button from Add notification pop up

    When    User click on the Configuration tab and click on Reason option
    Then    User should see the following reason values:
      | Not Specified                  |
      | Bug                            |
      | Technical assistance required  |
      | Complaint                      |
      | Problem                        |

    Then    The displayed Reason values should match the Admin add notification pop up dropdown values


  @CRM_Tickets_Validate_Category_Dropdown_Under_NotificationTab_According_To_Admin_Setting
  Scenario: TC033 Verify Admin Category Configuration Matches Admin notification Category Dropdown Values
    When  User click on the Notification tab under general settings menu
    And   User click on the Add Notification button and under that click on Category dropdown
    Then  User should see the following Category values in add notification dropdown:
      | Not Specified       |
      | System error        |
      | Question            |
      | IT support needed   |
    And   click on cancel button from Add notification pop up

    When    User click on the Configuration tab and click on Category option
    Then    User should see the following Category values:
      | Not Specified       |
      | System error        |
      | Question            |
      | IT support needed   |

    Then    The displayed Category values should match the Admin add notification pop up dropdown values


  @CRM_Tickets_Validate_Action_Dropdown_Under_NotificationTab_According_To_Admin_Setting
  Scenario: TC034 Verify Admin Action Configuration Matches Admin notification Action Dropdown Values
    When  User click on the Notification tab under general settings menu
    And   User click on the Add Notification button and under that click on Action dropdown
    Then  User should see the following Action values in add notification dropdown:
      | Not Specified       |
    And   click on cancel button from Add notification pop up

    When    User click on the Configuration tab and click on Action option
    Then    User should see the following Action values:
      | Not Specified       |

    Then    The displayed Action values should match the Admin add notification pop up dropdown values


  @CRM_Tickets_Validate_Feedback_Dropdown_Under_NotificationTab_According_To_Admin_Setting
  Scenario: TC035 Verify Admin Feedback Configuration Matches Admin notification Feedback Dropdown Values
    When  User click on the Notification tab under general settings menu
    And   User click on the Add Notification button and under that click on Feedback dropdown
    Then  User should see the following Feedback values in add notification dropdown:
      | Not Specified       |
    And   click on cancel button from Add notification pop up

    When    User click on the Configuration tab and click on Feedback option
    Then    User should see the following Feedback values:
      | Not Specified       |

    Then    The displayed Feedback values should match the Admin add notification pop up dropdown values


  @CRM_Tickets_Validate_FeedbackType_Dropdown_Under_NotificationTab_According_To_Admin_Setting
  Scenario: TC036 Verify Admin FeedbackType Configuration Matches Admin notification FeedbackType Dropdown Values
    When  User click on the Notification tab under general settings menu
    And   User click on the Add Notification button and under that click on FeedbackType dropdown
    Then  User should see the following FeedbackType values in add notification dropdown:
      | Not Specified       |
    And   click on cancel button from Add notification pop up

    When    User click on the Configuration tab and click on FeedbackType option
    Then    User should see the following FeedbackType values:
      | Not Specified       |

    Then    The displayed FeedbackType values should match the Admin add notification pop up dropdown values