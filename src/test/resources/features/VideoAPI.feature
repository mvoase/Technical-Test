Feature: Song Video API Test

  @VideoGET
  Scenario:
    Given I retrieve all the songs available
    Then I check the response code for the api
    And I retrieve information about a song
    Then I check the response code for the api
    #And I check the video is available in the Api


  @VideoPost
  Scenario:
    Given I Post a new Song into the API
    Then I check the response code for the api
    And I check the video is available in the Api


  #@VideoUpdate



  @PlaylistGet
  Scenario:
    Given I retrieve my playlist
    Then I check the response code for the api
    And I retrieve information about a specific playlist
    Then I check the response code for the api


  #@PlaylistPost



