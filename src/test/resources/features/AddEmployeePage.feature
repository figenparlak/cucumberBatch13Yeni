Feature: This feature is  going to add employees in HRMS application

  Background:
    When user enters valid admin username and password
    And user clicks on login button
    Then admin user is successfully logged in
    When user clicks on PIM option
    And user clicks on add employee option

  @test
  Scenario: Add an employee
    When user enters firstName , middleName and lastName
    And user clicks on save button
    Then employee added successfully

  @override
  Scenario: Adding one employee from cucumber feature file
    When user enters "<oman>" , "tagai" and "gihid"
    And user clicks on save button
    Then employee added successfully
# BUNDA her eklenen kisi icin teste bastan basliyor
  @dataprovider
  Scenario Outline: Adding multiple employees from cucumber feature file
    When user enter "<firstName>" , "<middleName>" and "<lastName>"
    And user clicks on save button
    Then employee added successfully
    Examples:
      |firstName|middleName|lastName|
      |romid1    |MS        |zarif   |
      |rokan1   |MS        |elisa   |
      |mama1    |tarindi   |jamu    |
# burda teste her kisi icin bastan baslamiyor
  @datatable
  Scenario: Adding multiple employees using data table
    When user adds multiple employees and verify they are added
      |firstName|middleName|lastName|
      |khryswana|MS        |jaman   |
      |zamis    |MS        |Gaukhar |
      |tamir    |MS        |microsoft|

  @excel
  Scenario: Adding employees from excel file
    When user adds multiple employees from excel file using "employeeData" sheet and verify the employee has added


