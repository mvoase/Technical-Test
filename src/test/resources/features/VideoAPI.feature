Feature: Song Video API Test

  @VideoGET
  Scenario:
    Given I retrieve all the songs available
    Then I retrieve information about the first song
    #And I check the video is available in the Api


  @VideoPost
  Scenario:
    Given I Post a new Song into the API
