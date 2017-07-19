-------------------------------------
Technical Test
-------------------------------------

This Java project uses BDD test automation alongside Apache Fluent HC in order to interrogate an API. 

The API carries a series of JSON data that includes details of Songs as and playlists. 


-------------------------------------
Running these tests 
-------------------------------------

In order to see the specific failues where the API is falling over I have split these tests into individual runners.
This isn't something that I would use going forward as having a large number of runners for such a small API wouldn't be needed.

However I have implemented it in this way, to track the Pass/Failed tests for the time being - i.e. so its not one long test and it just falls over straight away.


The following runners will needed to be created as a Junit in order for these tests to run.

 - VideoPlayListAPITestRunnerTest
 This runner uses a GET for all the playlists available
 @PlaylistGET

 - VideoSongAPITestRunnerTest
 This pulls through all the songs available using a GET request
 @VideoGET

 - VideoSongPostAPITestRunnerTest
 This is the test for posting a new song into the API
 @VideoPost

 - VideoSongDeleteAPITestRunnerTest
 This is the test runner for deleting the song you have just added from the API
 @VideoDelete


------------------------------------
Known Issues with API
------------------------------------

Currently the following tests will fail:
@VideoPost will fail on checking the response code
 - This is due to the response code expected return being 201 however the code returned is 200.

@VideoDelete will also fail due to the response code
 - This should return 204 code, but returns 200 also.

These tests will fail until these issues are fixed within the API.
