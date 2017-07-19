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
      Given I Post a new Song into the API
      And I delete the video

  @PlaylistGet
  Scenario:
    Given I retrieve my playlist
    Then I check the response code for the api
    And I retrieve information about a specific playlist
    Then I check the response code for the api

  @PlaylistPost
    Scenario:
      Given I create a new playlist
      Then I check the response code for the api for post
      And I retrieve my playlist

  @PlaylistUpdate
    Scenario:
      Given I retrieve all the songs available
      And I retrieve my playlist
      Then I add a song to a playlist
      And I retrieve information about a specific playlist
      Then I check the response code for the api for post


  #@PlayListSongRemove


  @PlaylistDelete
  Scenario: Add in a new playlist and then delete
    Given I create a new playlist
    And I delete the playlist
    Then I check the for the api for delete
