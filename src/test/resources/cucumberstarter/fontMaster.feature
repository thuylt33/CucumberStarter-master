Feature: FontMaster
  Scenario: Show err message for invalid mail
    Given I stayed at testmaster homepage
    When I provide invalid mail "khanh111.tx" and click DangKy
    Then I should see the err message for invalid mail

Scenario Outline: Show Exited_Mail message in registration
    Given I stayed at testmaster homepage
    When I provide  existed account "<mail>" and press Enter
    Then I should see the Exited_Mail message "<mail>"
    Examples:
    |mail|
    |thuy2011ptit@gmail.com|
    
  
 Scenario Outline: Show default value gender and newsletter in NOT_Exited_Mail input
    Given I stayed at testmaster homepage
    When I provide not existed account "<mail>" and press Enter
    Then I should see the extra information is opened
    And I see  default value gender "<gender>" and newsletter "<newsletter>"  
    Examples:
      
    |mail      | gender       |newsletter      |
    |@gmail.com|Không xác định|Nhận tất cả các loại tin|
     
    Scenario Outline: Show requested_Name message
    Given I stayed at testmaster homepage
    When I provide not existed account <mail> and press Enter
    And I provide null_Name
    And I provide gender 
    And I provide newsletter 
    And T press btn DongY
    Then I should requested_Name message 
      Examples:
       
    |mail      | gender       |newsletter              |
    |"@gmail.com"|Nam         |"Nhận tất cả các loại tin"| 
    

@tag 
 Scenario Outline: Show success message and one confirmation email is sent to me
    Given I stayed at testmaster homepage
    When I provide not existed account <mail> and press Enter
    And I provide Name <name>
   And I provide gender 
    And I provide newsletter 
    And T press btn DongY
    Then I should success alert
        Examples:
    
    |mail      | name      |
    |"@gmail.com"|"Lê Thị Thùy"|
    |"@gmail.com.vn"|"Lê Thị Thanh"|
   
   

 

    
    
    
