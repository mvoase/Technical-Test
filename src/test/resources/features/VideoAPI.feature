@VideoAPI
Feature: Song Video API Test

  @VideoGET
  Scenario:
    Given I retrieve all the songs available
    Then I check the response code for the api
    And I retrieve information about a song
    Then I check the response code for the api


  @VideoPost
  Scenario:
    Given I Post a new Song into the API
    And I check the response code for the api for post

  #@VideoUpdate


  @VideoDelete
    Scenario:
      Given I delete the video
      And I check the for the api for delete


  @PlaylistGet
  Scenario:
    Given I retrieve my playlist
    Then I check the response code for the api
    And I retrieve information about a specific playlist
    Then I check the response code for the api

  #@PlaylistPost


  #PlaylistUpdate

  #PlaylistDelete
