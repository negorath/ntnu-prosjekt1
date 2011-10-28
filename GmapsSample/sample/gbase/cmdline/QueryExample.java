/* Copyright (c) 2006 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.gbase.cmdline;

import com.google.api.gbase.client.GoogleBaseEntry;
import com.google.api.gbase.client.GoogleBaseFeed;
import com.google.api.gbase.client.GoogleBaseQuery;
import com.google.gdata.util.ServiceException;

import java.io.IOException;


/**
 * This class demonstrates how to send simple Google Base search queries
 * using the client library of the Google Base data API.
 *
 * The tool implemented by this class will connect to Google Base, run the
 * query and display some results.
 */
public class QueryExample extends Example {

  /**
   * Maximum number of results to return.
   */
  private static final int MAX_RESULTS = 10;

  /**
   * Runs the example.
   */
  public static void main(String[] args) throws IOException, ServiceException {
    String queryString = null;
    
    args = init(args, "Google-QueryExample-1.0");

    // Process command-line arguments
    if (args.length == 1) {
      queryString = args[0];
    } else {
      System.err.println("Invalid argument count.");
      System.err.println("Expected one argument:");
      System.err.println(" query");
      System.exit(1);
    }
    
    // Create a query URL from the given arguments
    GoogleBaseQuery query =
        new GoogleBaseQuery(urlFactory.getSnippetsFeedURL());
    query.setGoogleBaseQuery(queryString);
    query.setResultFormat(GoogleBaseQuery.ResultFormat.ATOM);
    query.setMaxResults(MAX_RESULTS);

    // Display the URL generated by the API
    System.out.println("Sending request to: " + query.getUrl());

    try {
      GoogleBaseFeed feed = service.query(query, GoogleBaseFeed.class);
      // Print the items
      printResult(feed);
    } catch (ServiceException e) {
      printServiceException(e);
    }
  }

  /**
   * Prints a few relevant attributes from each item in the feed to the output.
   *
   * @param feed a Google Base data API items feed
   */
  private static void printResult(GoogleBaseFeed feed) {
    if (feed.getTotalResults() == 0) {
      System.out.println("No matches.");
    } else {
      for (GoogleBaseEntry entry : feed.getEntries()) {
        System.out.println(entry.getGoogleBaseAttributes().getItemType() +
                           ": " + entry.getTitle().getPlainText() +
                           " - " +entry.getId());
      }
    }
  }
}
