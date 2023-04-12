@parallel
Feature: As a potential homebuyer

  I want to use the Personal Information
  page of my bank's mortgage application

  Background: Common steps for all scenarios in sign up page
    Given userName1
#    Then all required fields are filled out

  Scenario Outline: User fills out Personal Information information
    Then an additional section for personal information  information is displayed
    Then the user enters the personal information neqativ first name "<firstName>"
    Then all required fields negativ are filled out
    Examples:
      | firstName          |
      | j                h |
      | john2023           |
      | 1514545152023      |

  @parallel
  Scenario Outline: User fills out Personal Information information
    Then an additional section for personal information  information is displayed
    When the user enters the personal information "<firstName>","<middlename>","<lastName>","<email>","<dateofbirth>"
    Then all required fields positiv are filled out
    Examples:
      | firstName  | middlename | lastName    | email                      | dateofbirth |
      | Frederic   | Frederic   | Majury      | fmajury0@twitpic.com       | 01051991    |
      | Paige      | Paige      | Bromell     | pbromell1@adobe.com        | 02051992    |
      | Paige      | Paige      | Dahill      | ddahill2@rakuten.co.jp     | 03051993    |
      | Whitney    | Whitney    | Gourlie     | wgourlie3@ask.com          | 04051994    |
      | Magnum     | Magnum     | Gasson      | mgasson4@webeden.co.uk     | 05051995    |
      | Brook      | Brook      | Watsham     | bwatsham5@senate.gov       | 06051996    |
      | Forrest    | Forrest    | Bloodworthe | fbloodworthe6@berkeley.edu | 07051997    |
      | Alessandra | Alessandra | Offord      | aofford7@fema.gov          | 08051998    |
      | Elsey      | Elsey      | Tanfield    | etanfield8@tuttocitta.it   | 09051999    |
      | Wenonah    | Wenonah    | Grimwad     | wgrimwad9@histats.com      | 10052000    |