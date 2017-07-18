@VideoAPI
  Feature: Song Video API Test

    Scenario:
      Given I retrieve all the songs available
      Then I upload a new video to the playlist
      #And I check the video is available in the Api