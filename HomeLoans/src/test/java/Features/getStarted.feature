Feature: To check the Home Loans funtionality

  Scenario: To check the user start the loan application on valid credentials
    Given User is able to visit the Home Loans page
    When User enters the details
    And Click the checkbox
    And Click the Get Started button
    Then User will navigate to the next page

  @GetStarted
  Scenario Outline: To validate the correct loan amount
    Given User is able to visit the getstarted site
    When User enters the <Loan Amount> and <Mobile Number>
    And Click the checkbox
    And Click get started button
    Then User will navigate to the next page
    And Close all the browser

    Examples: 
      | Loan Amount | Mobile Number |
      |      500000 |    9876543210 |
      |     5000000 |    8971526362 |
      |      100000 |    7615342903 |

  @Emi
  Scenario Outline: EMI Calculator validity calculation
    Given Initialize the browser with chrome
    And Navigate to emi site
    When User enters <Loan Amount> and <Tanure> and <Rate of Interest>
    And Click on Calculate EMI button
    Then It will display EMI per month
    And Close the browser

    Examples: 
      | Loan Amount | Tanure | Rate of Interest |
      |      500000 |     10 |               10 |
      |     1000000 |      5 |               10 |
      |      100000 |      5 |                1 |

  @Eligibility
  Scenario Outline: Loan Eligibility Calculator validity
    Given Initialize the browser with chrome
    And Navigate to eligibility site
    When User enters <Loan Amount> and <Net Income> and <Existing Loan> and <Tanure> and <Rate of Interest>
    And User click the Check Eligibility button
    Then It will display the Eligibility amount
    And Close the browser

    Examples: 
      | Loan Amount | Net Income | Existing Loan | Tanure | Rate of Interest |
      |     2500000 |      50000 |        500000 |     10 |               10 |
      |     5000000 |      60000 |        400000 |      5 |                1 |
      |     1000000 |      70000 |        300000 |      5 |               10 |

  @BalanceTransfer
  Scenario Outline: Balance Transfer validity calculation
    Given Initialize the browser with chrome
    And Navigate to balancetransfer site
    And Click on Balance Transfer tab present under Home Loan Calculator
    When User enters the inputs in <Loan Amount> and <Current Tanure> and <Current Rate of Interest> and  <Installment Paid> and <Processing Fees> and <New Tanure> and <New Rate of Interest>under data fileds
    And Click the Compare button
    Then It will display the interest the user will lose
    And Close the browser

    Examples: 
      | Loan Amount | Current Tanure | Current Rate of Interest | Installment Paid | Processing Fees | New Tanure | New Rate of Interest |
      |      500000 |              6 |                        5 |               50 |               1 |          6 |                    9 |
      |     2500000 |              7 |                       10 |               40 |              10 |          5 |                   10 |
      |      100000 |              9 |                       10 |               50 |               5 |          9 |                   10 |

  @Explore
  Scenario: Validity of Explore button
    Given Initialize and open the browser
    And Navigate to the main home loans page
    When Click the Explore button
    Then User will be able to visit another page with Key Features
    And Close the browser
