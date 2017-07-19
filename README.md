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
 @VideoDelete (Current issues with this test - see Issues with Test Pack).

------------------------------------
Issues with the Test Pack
------------------------------------

 - Currently Video Delete doesn't run in conjuction to Video Post (so in theory doesn't retrieve the new Song ID that you have implemented.
This is not something that is wrong with the API this is an issue with these tests and the delete function.
These test will fail and need looking at.

 - More tests needed to be added to query specific Artist, songs etc. For the purpose of this test I just wanted to try and hit every endpoint as possible,
  the other tests are something in which can be improved at a later date.

 - Posting in a new song currently uses raw JSON data from the code itself (obviously that means you will end up with duplicate entries of the same song within the DB, this needs changing so the pack pulls the data from a json file
  picks a random song and adds it into the API, checks for an existing field and doesn't import if the song is already there.

------------------------------------
Known Issues with API
------------------------------------

Currently the following tests will fail:
@VideoPost will fail on checking the response code
 - This is due to the response code expected return being 201 however the code returned is 200.

These tests will fail until these issues are fixed within the API.
