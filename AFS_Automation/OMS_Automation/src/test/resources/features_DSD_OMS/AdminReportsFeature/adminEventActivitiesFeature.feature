Feature: Test scenarios for Admin, for genterating reports in events/activies tab with differnt events

  Background: For login to application and selecting Account# for Admin reports
    Given User enters URL and is on login page and entered credentials for Admin setting for Admin reports
    When User is on Home Page for Admin setting for Admin reports

  @Logon/Logoff
  Scenario Outline: Test scenario for verifying functionality of Event activities log tab with logon/logoff event
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>" for Reports, Admin Options for event and activities
    Then User selects "<Admin Options>" in Orders page in admin login and validate user is in selected Tab
    Then User selects Customer Accoun# "<Add filter>", From and End dates for Creating reports
    And User selects User name and "<Event>" to genrate report
    And User click on clicks on export .csv
    Then User click on Download .pdf to download document
    Then User click on reset button in Administration tab and all the webelement should be clear
    Examples:
      | Main menu  |  Sub menu        |   Admin Options          | Add filter  |Event          |
      | Reports    |  Administration  |   Events/ Activities log | Account #   |Log on/Log off |

  @Registration
  Scenario Outline: Test scenario for verifying functionality of Event activities log tab with Registration
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>" for Reports, Admin Options for event and activities
    Then User selects "<Admin Options>" in Orders page in admin login and validate user is in selected Tab
    Then User selects Customer Accoun# "<Add filter>", From and End dates for Creating reports
    And User selects User name and "<Event>" to genrate report
    And User click on clicks on export .csv
    Then User click on Download .pdf to download document
    Then User click on reset button in Administration tab and all the webelement should be clear
    Examples:
      | Main menu  |  Sub menu        |   Admin Options          | Add filter  |Event          |
      | Reports    |  Administration  |   Events/ Activities log | Account #   |Registration   |

  @NewOrder
  Scenario Outline: Test scenario for verifying functionality of Event activities log tab with New order
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>" for Reports, Admin Options for event and activities
    Then User selects "<Admin Options>" in Orders page in admin login and validate user is in selected Tab
    Then User selects Customer Accoun# "<Add filter>", From and End dates for Creating reports
    And User selects User name and "<Event>" to genrate report
    And User click on clicks on export .csv
    Then User click on Download .pdf to download document
    Then User click on reset button in Administration tab and all the webelement should be clear
    Examples:
      | Main menu  |  Sub menu        |   Admin Options          | Add filter  |Event          |
      | Reports    |  Administration  |   Events/ Activities log | Account #   |New order      |

  @EditOrder
  Scenario Outline: Test scenario for verifying functionality of Event activities log tab with Edit order
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>" for Reports, Admin Options for event and activities
    Then User selects "<Admin Options>" in Orders page in admin login and validate user is in selected Tab
    Then User selects Customer Accoun# "<Add filter>", From and End dates for Creating reports
    And User selects User name and "<Event>" to genrate report
    And User click on clicks on export .csv
    Then User click on Download .pdf to download document
    Then User click on reset button in Administration tab and all the webelement should be clear
    Examples:
      | Main menu  |  Sub menu        |   Admin Options          | Add filter  |Event           |
      | Reports    |  Administration  |   Events/ Activities log | Account #   |Edit order      |

  @CancelOrder
  Scenario Outline: Test scenario for verifying functionality of Event activities log tab with cancel order
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>" for Reports, Admin Options for event and activities
    Then User selects "<Admin Options>" in Orders page in admin login and validate user is in selected Tab
    Then User selects Customer Accoun# "<Add filter>", From and End dates for Creating reports
    And User selects User name and "<Event>" to genrate report
    And User click on clicks on export .csv
    Then User click on Download .pdf to download document
    Then User click on reset button in Administration tab and all the webelement should be clear
    Examples:
      | Main menu  |  Sub menu        |   Admin Options          | Add filter  |Event           |
      | Reports    |  Administration  |   Events/ Activities log | Account #   |Cancel order      |

  @NewStandingOrder
  Scenario Outline: Test scenario for verifying functionality of Event activities log tab with New standing order
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>" for Reports, Admin Options for event and activities
    Then User selects "<Admin Options>" in Orders page in admin login and validate user is in selected Tab
    Then User selects Customer Accoun# "<Add filter>", From and End dates for Creating reports
    And User selects User name and "<Event>" to genrate report
    And User click on clicks on export .csv
    Then User click on Download .pdf to download document
    Then User click on reset button in Administration tab and all the webelement should be clear
    Examples:
      | Main menu  |  Sub menu        |   Admin Options          | Add filter  |Event                   |
      | Reports    |  Administration  |   Events/ Activities log | Account #   |New standing order      |

  @EditStandingOrder
  Scenario Outline: Test scenario for verifying functionality of Event activities log tab with edit order
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>" for Reports, Admin Options for event and activities
    Then User selects "<Admin Options>" in Orders page in admin login and validate user is in selected Tab
    Then User selects Customer Accoun# "<Add filter>", From and End dates for Creating reports
    And User selects User name and "<Event>" to genrate report
    And User click on clicks on export .csv
    Then User click on Download .pdf to download document
    Then User click on reset button in Administration tab and all the webelement should be clear
    Examples:
      | Main menu  |  Sub menu        |   Admin Options          | Add filter  |Event                 |
      | Reports    |  Administration  |   Events/ Activities log | Account #   |Edit standing order   |

  @PasswordRequest
  Scenario Outline: Test scenario for verifying functionality of Event activities log tab with Password request
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>" for Reports, Admin Options for event and activities
    Then User selects "<Admin Options>" in Orders page in admin login and validate user is in selected Tab
    Then User selects Customer Accoun# "<Add filter>", From and End dates for Creating reports
    And User selects User name and "<Event>" to genrate report
    And User click on clicks on export .csv
    Then User click on Download .pdf to download document
    Then User click on reset button in Administration tab and all the webelement should be clear
    Examples:
      | Main menu  |  Sub menu        |   Admin Options          | Add filter  |Event                 |
      | Reports    |  Administration  |   Events/ Activities log | Account #   |Password request      |

  @AutoGeneratedOrder
  Scenario Outline: Test scenario for verifying functionality of Event activities log tab with auto generated order
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>" for Reports, Admin Options for event and activities
    Then User selects "<Admin Options>" in Orders page in admin login and validate user is in selected Tab
    Then User selects Customer Accoun# "<Add filter>", From and End dates for Creating reports
    And User selects User name and "<Event>" to genrate report
    And User click on clicks on export .csv
    Then User click on Download .pdf to download document
    Then User click on reset button in Administration tab and all the webelement should be clear
    Examples:
      | Main menu  |  Sub menu        |   Admin Options          | Add filter  |Event                |
      | Reports    |  Administration  |   Events/ Activities log | Account #   |Auto-generated order |

  @EmailNotification
  Scenario Outline: Test scenario for verifying functionality of Event activities log tab with email notification
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>" for Reports, Admin Options for event and activities
    Then User selects "<Admin Options>" in Orders page in admin login and validate user is in selected Tab
    Then User selects Customer Accoun# "<Add filter>", From and End dates for Creating reports
    And User selects User name and "<Event>" to genrate report
    And User click on clicks on export .csv
    Then User click on Download .pdf to download document
    Then User click on reset button in Administration tab and all the webelement should be clear
    Examples:
      | Main menu  |  Sub menu        |   Admin Options          | Add filter  |Event                |
      | Reports    |  Administration  |   Events/ Activities log | Account #   |Email notification   |

  @GoalModification
  Scenario Outline: Test scenario for verifying functionality of Event activities log tab with Goal modification
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>" for Reports, Admin Options for event and activities
    Then User selects "<Admin Options>" in Orders page in admin login and validate user is in selected Tab
    Then User selects Customer Accoun# "<Add filter>", From and End dates for Creating reports
    And User selects User name and "<Event>" to genrate report
    And User click on clicks on export .csv
    Then User click on Download .pdf to download document
    Then User click on reset button in Administration tab and all the webelement should be clear
    Examples:
      | Main menu  |  Sub menu        |   Admin Options          | Add filter  |Event                |
      | Reports    |  Administration  |   Events/ Activities log | Account #   |Goal modification    |

  @BlockOutDates
  Scenario Outline: Test scenario for verifying functionality of Event activities log tab with Blackout date modification
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>" for Reports, Admin Options for event and activities
    Then User selects "<Admin Options>" in Orders page in admin login and validate user is in selected Tab
    Then User selects Customer Accoun# "<Add filter>", From and End dates for Creating reports
    And User selects User name and "<Event>" to genrate report
    And User click on clicks on export .csv
    Then User click on Download .pdf to download document
    Then User click on reset button in Administration tab and all the webelement should be clear
    Examples:
      | Main menu  |  Sub menu        |   Admin Options          | Add filter  |Event                      |
      | Reports    |  Administration  |   Events/ Activities log | Account #   |Blackout date modification |

  @CutoffMgmtModification
  Scenario Outline: Test scenario for verifying functionality of Event activities log tab with cutoff mgmt modification
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>" for Reports, Admin Options for event and activities
    Then User selects "<Admin Options>" in Orders page in admin login and validate user is in selected Tab
    Then User selects Customer Accoun# "<Add filter>", From and End dates for Creating reports
    And User selects User name and "<Event>" to genrate report
    And User click on clicks on export .csv
    Then User click on Download .pdf to download document
    Then User click on reset button in Administration tab and all the webelement should be clear
    Examples:
      | Main menu  |  Sub menu        |   Admin Options          | Add filter  |Event                    |
      | Reports    |  Administration  |   Events/ Activities log | Account #   |Cutoff mgmt modification |

  @CutoffOverrideModification
  Scenario Outline: Test scenario for verifying functionality of Event activities log tab with cutoff override modification
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>" for Reports, Admin Options for event and activities
    Then User selects "<Admin Options>" in Orders page in admin login and validate user is in selected Tab
    Then User selects Customer Accoun# "<Add filter>", From and End dates for Creating reports
    And User selects User name and "<Event>" to genrate report
    And User click on clicks on export .csv
    Then User click on Download .pdf to download document
    Then User click on reset button in Administration tab and all the webelement should be clear
    Examples:
      | Main menu  |  Sub menu        |   Admin Options          | Add filter  |Event                        |
      | Reports    |  Administration  |   Events/ Activities log | Account #   |Cutoff override modification |
